package ctrl;

import modeles.Joueur;
import vues.Cadre;

public class Control {

	Cadre cadre = null;
	Joueur joueur = null;
	
	int nbreJoueurs = 0;
	
	public static void main(String[] args) {
		Control ctrl = new Control();
	}
	
//*********CONSTRUCTEUR***********
	public Control() {
		//affichage de l'interface graphique
		Cadre cadre = new Cadre(this);
	    
		//affichage question nombre de joueurs
		nbreJoueurs = cadre.initNbreJoueurs();
		
		do {
		}while( nbreJoueurs == 0);
			
		//affichage question prénoms des joueurs
		cadre.initPrenoms(nbreJoueurs);
	}

//*********METHODES***********
	public int getNbreJoueurs() {
		return this.nbreJoueurs;
	}

	public void setNbreJoueurs(int nbreJoueurs_) {
		this.nbreJoueurs = nbreJoueurs_;
	}
}
