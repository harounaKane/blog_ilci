package modele;

public class Article {
	
	private int id;
	private String titre;
	private String contenu;
	private Auteur auteur;
	private Categorie categorie;
	
	public Article() {}

	public Article(int id, String titre, String contenu, Auteur auteur, Categorie categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.auteur = auteur;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", auteur=" + auteur + ", categorie="
				+ categorie + "]";
	}
	
	

}
