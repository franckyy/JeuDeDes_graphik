package vues;

import javax.swing.JFrame;

import ctrl.Start_Jeu;

public class Cadre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PanneauPrincipal panneau = null;
	int nbreJoueurs;
	
	public Cadre() {
		panneau = new PanneauPrincipal(this);
		
		//paramétrages cadre
	    this.setTitle("Jeu de dés");
	    this.setContentPane(panneau);
//	    this.setLocationRelativeTo(null);	//fenêtre centrée à l'écran
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	}
	
	public void initNbreJoueurs() {
		panneau.initNbreJoueurs();
	}
	

	public void setNbreJoueurs(int NbreJoueurs_) {
		this.nbreJoueurs = NbreJoueurs_;
	}
}
