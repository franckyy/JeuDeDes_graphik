package vues;

import javax.swing.JFrame;

import ctrl.Control;
import modeles.Joueur;

public class Cadre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Control ctrl = null;
	PanneauPrincipal panneau = null;
	String[] prénomsJoueurs = null;
	Joueur[] joueurs = null;
	
	//*********CONSTRUCTEUR*********
	public Cadre(Control ctrl_, Joueur[] joueurs_) {
		this.ctrl = ctrl_;
		this.joueurs = joueurs_;
		
		panneau = new PanneauPrincipal(ctrl, joueurs);
		
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
