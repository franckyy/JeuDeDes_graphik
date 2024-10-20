package vues;

import javax.swing.JFrame;

public class Cadre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PanneauPrincipal panneau = null;
	
	public Cadre() {
		panneau = new PanneauPrincipal();
		
		//paramétrages cadre
	    this.setTitle("Jeu de dés");
	    this.setContentPane(panneau);
//	    this.setLocationRelativeTo(null);	//fenêtre centrée à l'écran
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	}
	
	public void initJeu() {
		panneau.initJeu();
	}
}
