package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import ctrl.Control;
import modeles.Joueur;

public class PanScores_north extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	int xPanSize, yPanSize, yPanPersSize;
	String[] prénomsJoueurs = null;
	Joueur[] joueurs = null;
	Control ctrl = null;
	
	//*********CONSTRUCTEUR*********
	public PanScores_north(int xPanSize_, int yPanSize_, Joueur[] joueurs_, Control ctrl_) {
		this.xPanSize = xPanSize_;
		this.yPanSize = yPanSize_;
		this.joueurs = joueurs_;
		this.ctrl = ctrl_;
		
		ctrl.setPanScores_north(this);
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		//hauteur du panneauPersonnel affiché
		yPanPersSize = (int) Math.round(yPanSize * 0.85);
		this.setLayout(new FlowLayout(1, 15, (int) Math.round((yPanSize - yPanPersSize) / 2)));	//FlowLayout​(int align, int hgap, int vgap)

		for(int i = 0; i < joueurs.length; i++) {
			this.add(new PanPersonalScore(xPanSize, yPanPersSize, joueurs[i]));
			this.setBackground(Color.RED);
		}
		
		this.setBackground(Color.GRAY);
	}
	
	//*********METHODES*********
	//TODO prévoir méthode pour mettre à jour les scores des joueurs une fois que leur tour est terminé
}
