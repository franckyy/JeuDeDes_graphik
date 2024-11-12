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
		this(1000, _tour, _prenom, _ctrl);
	}

	public Joueur(int _nbrePts, int _tour, String _prenom, Control _ctrl){
		this.nbrePts = _nbrePts;
		this.tour = _tour;
		this.prenom = _prenom;
		this.ctrl = _ctrl;
		
	}
	
	//******Setters Getters
	public void setNbrePts(int _nbrePts){
		this.nbrePts = this.getNbrePts() - _nbrePts;
		
		if(this.nbrePts == 0) {
			ctrl.gagne();
		} else if(this.nbrePts < 0) {
			ctrl.scoreNegatif();
		}else {
			
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

