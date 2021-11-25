package modele;

public class Commentaire {

	private int id;
	private String pseudo;
	private String contenu;
	private Article article;
	
	public Commentaire() {
		// TODO Auto-generated constructor stub
	}

	public Commentaire(int id, String pseudo, String contenu, Article article) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.contenu = contenu;
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", pseudo=" + pseudo + ", contenu=" + contenu + ", article=" + article + "]";
	}
	
	
	
}
