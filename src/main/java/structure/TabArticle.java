package structure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Article;
import modele.Auteur;
import modele.Categorie;
import modele.Commentaire;

public class TabArticle{

	private Connection connection;
	
	TabAuteur tabAut = new TabAuteur();
	TabCategorie tabCat = new TabCategorie();


	public TabArticle() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public void connect() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "");
	}
	
	public List<Article> getArticles() throws SQLException, ClassNotFoundException{
		List<Article> list = new ArrayList<Article>();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM article");
		
		while(resultSet.next()) {
			System.out.println( tabAut.getAuteur(resultSet.getInt("auteur")) );
			Article art = new Article(
					resultSet.getInt("id"), 
					resultSet.getString("titre"), 
					resultSet.getString("contenu"),
					tabAut.getAuteur(resultSet.getInt("auteur")),
					tabCat.getCategorie(resultSet.getString("categorie"))
				);
			list.add(art);
		}
		
		return list;
	}

	public Article getArticle(int id) throws SQLException {
		
		String sql = "SELECT * FROM article WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		resultSet.next();
		
		return new Article(
				resultSet.getInt("id"), 
				resultSet.getString("titre"), 
				resultSet.getString("contenu"), 
				tabAut.getAuteur(resultSet.getInt("auteur")), 
				tabCat.getCategorie(resultSet.getString("categorie"))
			);
	}

	public List<Commentaire> getCommentaires(int id) throws SQLException {
		String sql = "SELECT * FROM commentaire WHERE article = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		List<Commentaire> list = new ArrayList<Commentaire>();
		
		while(resultSet.next()) {
			Commentaire com = new Commentaire(
						resultSet.getInt("id"), 
						resultSet.getString("pseudo"), 
						resultSet.getString("contenu"), 
						getArticle(id)
				);
			list.add(com);
		}
		
		return list;
	}

	public void ajouterCommentaire(Commentaire comment) throws SQLException {
		String sql = "INSERT INTO commentaire (pseudo, contenu, article) VALUES(?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, comment.getPseudo());
		stmt.setString(2, comment.getContenu());
		stmt.setInt(3, comment.getArticle().getId());
		
		stmt.executeUpdate();
		
	}

	public void update(int id, String titre, String contenu) throws SQLException {
		connect();
		String sql = "UPDATE article SET titre = ?, contenu = ? WHERE id = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, titre);
		statement.setString(2, contenu);
		statement.setInt(3, id);
		
		statement.executeUpdate();
		
	}

	public void delete(int id) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("DELETE FROM article WHERE id = ?");
		statement.setInt(1, id);
		
		statement.executeUpdate();
		
	}

	public void ajouterArticle(Article article) throws SQLException {
		String query = "INSERT INTO article VALUE(null, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, article.getTitre());
		statement.setString(2, article.getContenu());
		statement.setInt(3, article.getAuteur().getId());
		statement.setString(4, article.getCategorie().getNom());
		
		statement.executeUpdate();
		
	}

}







