package vues.panneaux.north;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import ctrl.Control;
import modeles.Joueur;
import utils.PaletteColors;

public class PanScores_north extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	int xPanSize, yPanSize, yPanPersSize;
	String[] prénomsJoueurs = null;
	Joueur[] joueurs = null;
	Control ctrl = null;
	PanPersonalScore[] PanScores = null;

	final Color coulBackPanel = PaletteColors.BACKGROUND_JOUEURS;
	
	//*********CONSTRUCTEUR*********
	public PanScores_north(int xPanSize_, int yPanSize_, Joueur[] joueurs_, Control ctrl_) {
		System.out.println("PanScores_north(int xPanSize_, int yPanSize_, Joueur[] joueurs_, Control ctrl_)");
		this.xPanSize = xPanSize_;
		this.yPanSize = yPanSize_;
		this.joueurs = joueurs_;
		this.ctrl = ctrl_;
		
		ctrl.setPanScores_north(this);	//on instancie this chez le controlleur afin qu'il puisse envoyer les données directement sans passer par Cadre ... etc
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		//hauteur du panneauPersonnel affiché
		yPanPersSize = (int) Math.round(yPanSize * 0.85);
		this.setLayout(new FlowLayout(1, 15, (int) Math.round((yPanSize - yPanPersSize) / 2)));	//FlowLayout​(int align, int hgap, int vgap)

		PanScores = new PanPersonalScore[joueurs.length];
		
		//Création d'un tableau de PanScores
		for(int i = 0; i < joueurs.length; i++) {
			if(i == ctrl_.getJoueurActuel()) {// panneau du joueur actuel
				PanScores[i] = new PanPersonalScore(xPanSize, yPanPersSize, joueurs[i], PaletteColors.COMPL_JAUNE_1_CLAIR);				
			} else {// panneau des autres joueurs
				PanScores[i] = new PanPersonalScore(xPanSize, yPanPersSize, joueurs[i], PaletteColors.SECOND_ROSE_3);
			}
		}
		
		for(int i = 0; i < joueurs.length; i++) {
			this.add(PanScores[i]);
			this.setBackground(Color.RED);
		}
		
		this.setBackground(coulBackPanel);
	}
	
	//*********METHODES*********
	public void setScorePanScores(Joueur joueur) {
		PanScores[joueur.getTour()].setScore(joueur.getNbrePts());
	}
	
	public void updateBackgroundColors(int joueurActuel) {
	    for (int i = 0; i < PanScores.length; i++) {
	        if (i == joueurActuel) {
	            PanScores[i].setBackground(PaletteColors.COMPL_JAUNE_1_CLAIR); // couleur du joueur actuel
	        } else {
	            PanScores[i].setBackground(PaletteColors.SECOND_ROSE_3); // couleur des autres joueurs
	        }
	        PanScores[i].repaint(); // Réactualise l'affichage
	    }
	}
}
