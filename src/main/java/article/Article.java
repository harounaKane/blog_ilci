package article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import structure.TabAuteur;

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
		
		
		
		if( action != null ) {
			if( action.equals("articleClicked") ) {
				//
				request.setAttribute("id", request.getParameter("id"));
				vue = "/vues/article.jsp";
			}else if( action.equals("admin") ) {
				//
				vue = "/vues/admin.jsp";
			}else if( action.equals("delete") ) { 
				System.out.println("delete");
				vue = "/vues/admin.jsp";
				
			}else if( action.equals("update") ) {
				//
				System.out.println("update");
				request.setAttribute("titre", "le titre");
				request.setAttribute("content", "le contenu");
				vue = "/vues/updateArticle.jsp";
				
			}else if(action.equals("newArticle")) {
				TabAuteur tabAu= new TabAuteur();
				
				request.setAttribute("auteurs", tabAu.getTabAut());
				
				vue = "/vues/editeArticle.jsp";
			}
		}


		getServletContext().getRequestDispatcher(vue).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		
		
		if( action.equals("Commenter") ) { 
			String pseudo = request.getParameter("pseudo");
			String comment = request.getParameter("comment");
			int id = Integer.valueOf(request.getParameter("id"));
			System.out.println(pseudo +" "+comment);
			vue = "/vues/article.jsp";
		}else if( action.equals("Ajouter") ) {
			//
			System.out.println("ajouter");

		}else if( action.equals("Modiffier") ) {
			//
			System.out.println("modif");

		}
		
		getServletContext().getRequestDispatcher(vueDefault).forward(request, response);
	}

}












