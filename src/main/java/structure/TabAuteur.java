package structure;

import java.util.ArrayList;

import modele.Auteur;

public class TabAuteur {
	
	private ArrayList<Auteur> tabAut= new ArrayList<Auteur>();
	
	public TabAuteur() {
		tabAut.add(new Auteur(1,"Dembele","Moussa"));
		tabAut.add(new Auteur(2,"Put","Kev"));
	}

	public ArrayList<Auteur> getTabAut() {
		return tabAut;
	}

	public void setTabAut(ArrayList<Auteur> tabAut) {
		this.tabAut = tabAut;
	}
}
