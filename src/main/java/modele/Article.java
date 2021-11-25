package modele;

public class Article {
	
	private int id;
	private String titre;
	private String contenu;
	private Auteur auteur;
	private Categorie categoie;
	
	public Article() {}

	public Article(int id, String titre, String contenu, Auteur auteur, Categorie categoie) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.auteur = auteur;
		this.categoie = categoie;
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

	public Categorie getCategoie() {
		return categoie;
	}

	public void setCategoie(Categorie categoie) {
		this.categoie = categoie;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", auteur=" + auteur + ", categoie="
				+ categoie + "]";
	}
	
	

}
