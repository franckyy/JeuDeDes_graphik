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
	int nbreJoueurs;
	String[] prénomsJoueurs = null;
	
	//*********CONSTRUCTEUR*********
	public Cadre(Control ctrl_, int nbreJoueurs_, String[] prénomsJoueurs_) {
		this.ctrl = ctrl_;
		this.nbreJoueurs = nbreJoueurs_;
		this.prénomsJoueurs = prénomsJoueurs_;
		
		panneau = new PanneauPrincipal(ctrl, nbreJoueurs, prénomsJoueurs);
		
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
}
