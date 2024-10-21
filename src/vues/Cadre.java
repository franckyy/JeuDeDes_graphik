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
	
	public void initNbreJoueurs() {
		panneau.initNbreJoueurs();
	}
}
