package structure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Auteur;

public class TabAuteur {
	
	private Connection connection;
	
	public TabAuteur() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	public void connect() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "");
	}
	
	public List<Auteur> getAuteurs() throws SQLException{
		List<Auteur> list = new ArrayList<Auteur>();
		
		Statement stmt = connection.createStatement();
		ResultSet auteurs = stmt.executeQuery("SELECT * FROM auteur");
		
		while(auteurs.next()) {
			Auteur auteur = new Auteur(
					auteurs.getInt("id"),
					auteurs.getString("prenom"),
					auteurs.getString("nom")
					);
			list.add(auteur);
		}
		
		return list;
	}
	
	public Auteur getAuteur(int id) {
		try {
			String sql = "SELECT * FROM auteur WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return new Auteur(
						resultSet.getInt("id"),
						resultSet.getString("prenom"),
						resultSet.getString("nom")
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TabAuteur aut = new TabAuteur();
		aut.connect();
		List<Auteur> res = aut.getAuteurs();
		for(Auteur a : res)
			System.out.println(a);
	}
	
}
