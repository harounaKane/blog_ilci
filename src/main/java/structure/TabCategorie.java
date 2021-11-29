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
import modele.Categorie;

public class TabCategorie {

	private Connection connection;

	public TabCategorie() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public void connect() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "");
	}
	
	public List<Categorie> getCategories() throws SQLException{
		List<Categorie> list = new ArrayList<Categorie>();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM categorie");
		
		while(resultSet.next()) {
			list.add(new Categorie(resultSet.getString("nom")));
		}
		
		return list;
	}
	
	public Categorie getCategorie(String nom) throws SQLException {
		System.out.println(nom);
		try {
			String sql = "SELECT * FROM categorie WHERE nom = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setNString(1, nom);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return new Categorie( resultSet.getNString("nom") );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}







