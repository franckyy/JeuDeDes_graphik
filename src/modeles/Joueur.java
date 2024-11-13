package modeles;

import ctrl.Control;

public class Joueur{
	//******attributs
	int nbrePts;	//nombre de points de départ pour chaque joueur
	int tour;	//ordre de départ
	String prenom;
	Control ctrl = null;
	
	//******constructeurs
	public Joueur(int _tour, String _prenom, Control _ctrl){
		this(600, _tour, _prenom, _ctrl);
		System.out.println("Joueur(int _tour, String _prenom, Control _ctrl)");
	}

	public Joueur(int _nbrePts, int _tour, String _prenom, Control _ctrl){
		System.out.println("Joueur(int _nbrePts, int _tour, String _prenom, Control _ctrl)");
		this.nbrePts = _nbrePts;
		this.tour = _tour;
		this.prenom = _prenom;
		this.ctrl = _ctrl;
		
	}
	
	//******Setters Getters
	public int setNbrePts(int _nbrePts){
		System.out.println("Joueur - void setNbrePts(int _nbrePts)");
		//L'entier retourné aura la valeur 0  par défaut, 1 si le joueur a gagné et 2 si le score passe en négatif
		this.nbrePts = this.getNbrePts() - _nbrePts;
		
		if(this.nbrePts == 0) {
			return 1;
		} else if(this.nbrePts < 0) {
			return 2;
		}else {
			return 0;
		}
	}
	
	public int getNbrePts(){
		return nbrePts;
	}
	
	public void setTour(int _tour){
		this.tour = _tour;
	}
	
	public int getTour(){
		return tour;
	}
	
	public void setPrenom(String _prenom){
		this.prenom = _prenom;
	}
	
	public String getPrenom(){
		return prenom;
	} 
}

