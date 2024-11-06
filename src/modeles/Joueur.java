package modeles;

public class Joueur{
	//******attributs
	int nbrePts;	//nombre de points de départ pour chaque joueur
	int tour;	//ordre de départ
	String prenom;
	
	//******constructeurs
	public Joueur(int _tour, String _prenom){
		this(5000, _tour + 1, _prenom);
	}

	public Joueur(int _nbrePts, int _tour, String _prenom){
		this.nbrePts = _nbrePts;
		this.tour = _tour;
		this.prenom = _prenom;
	}
	
	//******Setters Getters
	public void setNbrePts(int _nbrePts){
			this.nbrePts = _nbrePts;
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

