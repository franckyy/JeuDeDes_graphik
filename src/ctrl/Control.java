package ctrl;

import modeles.Joueur;
import vues.Cadre;

public class Control {

	Cadre cadre = null;
	Joueur joueur = null;
	
	Integer nbreJoueurs = null;
	
	public static void main(String[] args) {
		Control ctrl = new Control();
	}
	
//*********CONSTRUCTEUR***********
	public Control() {
		//affichage de l'interface graphique
		Cadre cadre = new Cadre(this);
		
		//attente
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
		//affichage question nombre de joueurs
		nbreJoueurs = cadre.initNbreJoueurs();
		
		do {
			//on attends que la valeur du nbreJoueurs soit validée par l'utilisateur
		}while(nbreJoueurs == 0);
			
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
