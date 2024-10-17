package vues;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cadre extends JFrame {
	
	public Cadre() {
		PanneauPrincipal panneau = new PanneauPrincipal();
		
		//paramétrages cadre
	    this.setTitle("Jeu de dés");
	    this.setContentPane(panneau);
//	    this.setLocationRelativeTo(null);	//fenêtre centrée à l'écran
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	}
}
