package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MessageBDD {

	private final static String URL = "jdbc:sqlite:C:/Users/JAVA/Documents/java/javaBase/JavaBase.db";
	private final static String QUERY_FIND_MESSAGES = "SELECT * FROM messageBean ORDER BY id ASC";
	private final static String QUERY_SAVE_MESSAGE = "INSERT INTO messageBean (user, message) VALUES (?, ?);";

	public static ArrayList<MessageBean> maList = new ArrayList<>();

	public static ArrayList<MessageBean> getMessages() {
		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<MessageBean> maList = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_FIND_MESSAGES);
			// Remplir la requête

			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				maList.add(new MessageBean(rset.getString("user"), rset.getString("message")));
			}
			return maList;

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {// On ferme la connexion
				try {
					con.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		}

		return maList;
	}

	public static void addMessage(MessageBean message) {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(URL); // La connexion
			stmt = con.prepareStatement(QUERY_SAVE_MESSAGE);
			// Remplir la requête
			stmt.setString(1, message.getUser());
			stmt.setString(2, message.getMessage());
			// Lancer la requête
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// On ferme la connexion
			if (con != null) {
				try {
					con.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		}
		// maList.add(message);

	}

}
