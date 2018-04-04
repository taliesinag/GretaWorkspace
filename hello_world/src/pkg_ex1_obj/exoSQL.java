package pkg_ex1_obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class exoSQL {

	private final static String URL = "jdbc:sqlite:C:/Users/JAVA/Documents/java/maBase";
	private final static String QUERY_FIND_ELEVES = "SELECT * FROM eleve ";
	private final static String QUERY_SAVE_ELEVES = "INSERT INTO Eleve (prenom, note) VALUES (?, ?);";

	public static void main(String[] args) {
		Eleve eleveBean = new Eleve();
		eleveBean.setNote(12);
		eleveBean.setNom("Toto");

		ajouterEleve(eleveBean);

		ArrayList<Eleve> eleveBeans = getEleves();
		for (Eleve e : eleveBeans) {
			System.out.println(e);
		}
		System.out.println("exoSQL.main()");

	}

	public static void ajouterEleve(Eleve eleve) {
		// TODO Ajout de l'élève en base
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_SAVE_ELEVES, Statement.RETURN_GENERATED_KEYS);
			// Remplir la requête
			stmt.setString(1, eleve.getNom());
			stmt.setInt(2, eleve.getNote());
			// Lancer la requête
			stmt.executeUpdate();

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

	}

	public static ArrayList<Eleve> getEleves() {
		ArrayList<Eleve> eleveBeans = new ArrayList<>();
		// TODO Récupérer la liste des élèves dans la base
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(QUERY_FIND_ELEVES);
			while (rset.next()) {
				Eleve eleve = rsetToEleve(rset);
				eleveBeans.add(eleve);
			}
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

		return eleveBeans;
	}

	private static Eleve rsetToEleve(final ResultSet rset) throws SQLException {
		final Eleve eleve = new Eleve();
		eleve.setId(rset.getInt("id"));
		eleve.setNom(rset.getString("prenom"));
		eleve.setNote(rset.getInt("note"));
		return eleve;
	}

}
