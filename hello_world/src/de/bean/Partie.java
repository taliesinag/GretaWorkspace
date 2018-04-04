package de.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Partie {
	private final static String URL = "jdbc:sqlite:C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/bdd/base";
	private final static String QUERY_FIND_PARTIE = "SELECT * FROM partie WHERE id = ?;";
	private final static String QUERY_SAVE_PARTIE = "INSERT INTO partie (joueur1, joueur2, tourEnCours, joueurActif) VALUES (?, ?, ?, ?);";
	private final static String QUERY_UPDATE_PARTIE = "UPDATE partie SET joueur1 = ?, joueur2 = ?, tourEnCours = ?, joueurActif = ? WHERE id = ? ;";

	private Joueur joueur1, joueur2;
	private int tourEnCours;
	private Joueur joueurActif;
	private long id;

	public Partie(String nomJ1, String nomJ2) {
		joueur1 = new Joueur(nomJ1);
		joueur2 = new Joueur(nomJ2);
		tourEnCours = 1;
		joueurActif = joueur1;

	}

	public void ajouter1Tour() {
		tourEnCours++;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public int getTourEnCours() {
		return tourEnCours;
	}

	public void setTourEnCours(int tourEnCours) {
		this.tourEnCours = tourEnCours;
	}

	public Joueur getJoueurActif() {
		return joueurActif;
	}

	public void setJoueurActif(Joueur joueurActif) {
		this.joueurActif = joueurActif;
	}

	public boolean updatePartie() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_UPDATE_PARTIE);
			// Remplir la requête
			joueur1.updateJoueur();
			stmt.setLong(1, joueur1.getId());

			joueur2.updateJoueur();
			stmt.setLong(2, joueur2.getId());

			stmt.setInt(3, tourEnCours);
			stmt.setLong(4, joueurActif.getId());
			stmt.setLong(5, id);
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

	public boolean savePartie() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_SAVE_PARTIE, Statement.RETURN_GENERATED_KEYS);
			// Remplir la requête
			joueur1.saveJoueur();
			stmt.setLong(1, joueur1.getId());

			joueur2.saveJoueur();
			stmt.setLong(2, joueur2.getId());

			stmt.setInt(3, tourEnCours);
			stmt.setLong(4, joueurActif.getId());
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

	public boolean getPartieBDD() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_FIND_PARTIE);
			// Remplir la requête
			stmt.setLong(1, id);

			ResultSet rset = stmt.executeQuery();

			joueur1 = new Joueur(rset.getLong("joueur1"));
			joueur2 = new Joueur(rset.getLong("joueur2"));
			tourEnCours = rset.getInt("tourEnCours");
			joueurActif = rset.getInt("joueurActif") == joueur1.getId() ? joueur1 : joueur2;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
