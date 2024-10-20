package ctrl;

import vues.Cadre;

public class Start_Jeu {

	int nbreJoueurs;
	
	public static void main(String[] args) {
		Cadre cadre = new Cadre();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
		cadre.initNbreJoueurs();
	}


	public void setNbreJoueurs(int NbreJoueurs_) {
		this.nbreJoueurs = NbreJoueurs_;
	}
}
