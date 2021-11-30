package article;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Auteur;
import modele.Categorie;
import modele.Commentaire;
import structure.TabArticle;
import structure.TabAuteur;
import structure.TabCategorie;

/**
 * Servlet implementation class Article
 */
@WebServlet("/Article")
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String vue = "";
	final String vueDefault = "/index.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article() {
        super(); 
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		vue = vueDefault;
		TabAuteur tabAut;
		TabCategorie tabCat;
		TabArticle tabArt;
		
		try {
			tabAut = new TabAuteur();
			
			tabCat = new TabCategorie();
			
			tabArt = new TabArticle();
			tabArt.connect();
			
			request.setAttribute("articles", tabArt.getArticles());
			
			if( action != null ) {
				if( action.equals("articleClicked") ) {
			
					String id = request.getParameter("id");
					request.setAttribute("article", tabArt.getArticle(Integer.valueOf(id)));
					request.setAttribute("commentaires", tabArt.getCommentaires(Integer.valueOf(id)));
					vue = "/vues/article.jsp";
				}else if( action.equals("admin") ) {
					vue = "/vues/admin.jsp";
				}else if( action.equals("delete") ) { 
					int id = Integer.valueOf(request.getParameter("id"));
					tabArt.delete(id);
					response.sendRedirect("Article?action=admin");
					return;
				}else if( action.equals("update") ) {
					modele.Article article = tabArt.getArticle(Integer.valueOf(request.getParameter("id")));
					request.setAttribute("article", article);
					vue = "/vues/updateArticle.jsp";
					
				}else if(action.equals("newArticle")) {
					request.setAttribute("auteurs", tabAut.getAuteurs());
					request.setAttribute("categories", tabCat.getCategories());
					vue = "/vues/editeArticle.jsp";
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher(vue).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		TabArticle tabArt;
		try {
			tabArt = new TabArticle();
			tabArt.connect();
			TabAuteur tabAut = new TabAuteur();
			TabCategorie tabCat = new TabCategorie();
			
			if( action.equals("Commenter") ) { 
				String pseudo = request.getParameter("pseudo");
				String comment = request.getParameter("comment");
				int id = Integer.valueOf(request.getParameter("id"));
				Commentaire commentaire = new Commentaire(0, pseudo, comment, tabArt.getArticle(id));
				tabArt.ajouterCommentaire(commentaire);
				
				response.sendRedirect("Article?action=articleClicked&id="+id);
				return;
				
			}else if( action.equals("Ajouter") ) {
				String titre = request.getParameter("titre");
				String contenu= request.getParameter("contenu");
				Auteur auteur = tabAut.getAuteur(Integer.valueOf(request.getParameter("auteur")));
				Categorie categorie = new Categorie(request.getParameter("categorie"));
				modele.Article article = new modele.Article(0, titre, contenu, auteur, categorie);
				
				tabArt.ajouterArticle(article);
				response.sendRedirect( "Article?action=admin" );
			    return;

			}else if( action.equals("Modiffier") ) {
				String titre = request.getParameter("titre");
				String contenu = request.getParameter("contenu");
				int id = Integer.valueOf(request.getParameter("id"));
				
				tabArt.update(id, titre, contenu);
			    response.sendRedirect( "Article?action=admin" );
			    return;
			//	getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getServletContext().getRequestDispatcher(vueDefault).forward(request, response);
	}

}












