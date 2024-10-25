package vues;

import javax.swing.JFrame;

import ctrl.Control;

public class Cadre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Control ctrl = null;
	PanneauPrincipal panneau = null;
	
	//*********CONSTRUCTEUR*********
	public Cadre(Control ctrl_) {
		this.ctrl = ctrl_;
		
		panneau = new PanneauPrincipal(ctrl);
		
		//paramétrages cadre
	    this.setTitle("Jeu de dés");
	    this.setContentPane(panneau);
//	    this.setLocationRelativeTo(null);	//fenêtre centrée à l'écran
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	}
	
	
	//*********METHODES*********
	public int initNbreJoueurs() {
		return panneau.initNbreJoueurs();
	}

	public void initPrenoms(int nbreJoueurs_) {
		panneau.initPrenoms(nbreJoueurs_);
	}


	public void initPanScores(int nbreJoueurs) {
		panneau.initPanScores(nbreJoueurs);
	}
}
