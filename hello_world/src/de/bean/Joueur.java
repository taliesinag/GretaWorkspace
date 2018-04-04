package de.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.controllers.ControleurDe;

public class Joueur {
	private final static String URL = "jdbc:sqlite:C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/bdd/base";
	private final static String QUERY_FIND_JOUEUR = "SELECT * FROM joueur WHERE id = ? ";
	private final static String QUERY_SAVE_JOUEUR = "INSERT INTO joueur (nom, tricheur, scorePartie) VALUES (?, ?, ?);";
	private final static String QUERY_UPDATE_JOUEUR = "UPDATE joueur SET nom = ?, tricheur = ?, scorePartie = ? WHERE id = ? ;";

	private int scorePartie;
	private String nom;
	private Gobelet gobelet;
	private boolean tricheur;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Joueur(String nom) {
		this.nom = nom;
		scorePartie = 0;
		tricheur = false;
		newGobelet();

	}

	public Joueur(long id) {
		this.id = id;
		getJoueurBDD();

	}

	private void newGobelet() {
		gobelet = new Gobelet(tricheur);

	}

	public boolean isTricheur() {
		return tricheur;
	}

	public void setTricheur(boolean tricheur) {
		this.tricheur = tricheur;
		newGobelet();
	}

	public void lancer() {
		ControleurDe.log("" + nom);
		gobelet.lancer();
		ControleurDe.log(" obtient " + gobelet.getDe1Value() + " + " + gobelet.getDe2Value() + " = "
				+ gobelet.getScoreDe() + "\n");
		if (gobelet.getScoreDe() >= ControleurDe.SCOREAFAIRE) {
			ControleurDe.log("Il gagne donc 1 points.\n");
			ajouter1pts();
		} else {
			ControleurDe.log("Il ne gagne pas de points.\n");
		}
	}

	public Gobelet getGobelet() {
		return gobelet;
	}

	public void ajouter1pts() {
		scorePartie = scorePartie + 1;
	}

	public String getNom() {
		return nom;
	}

	public int getScorePartie() {
		return scorePartie;
	}

	public boolean updateJoueur() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_UPDATE_JOUEUR);
			// Remplir la requête

			stmt.setString(1, nom);

			stmt.setBoolean(2, tricheur);

			stmt.setInt(3, scorePartie);
			stmt.setLong(4, id);
			// Lancer la requête
			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// On ferme la connexion
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean saveJoueur() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_SAVE_JOUEUR, Statement.RETURN_GENERATED_KEYS);
			// Remplir la requête
			stmt.setString(1, nom);
			stmt.setBoolean(2, tricheur);
			stmt.setInt(3, scorePartie);
			// Lancer la requête
			int affectedRows = stmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					setId(generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// On ferme la connexion
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean getJoueurBDD() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_FIND_JOUEUR);
			// Remplir la requête
			stmt.setLong(1, id);

			ResultSet rset = stmt.executeQuery();

			nom = rset.getString("nom");
			tricheur = rset.getBoolean("tricheur");
			scorePartie = rset.getInt("scorePartie");
			return true;

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {// On ferme la connexion
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;

	}

}
