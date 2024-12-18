package vues.panneaux.north;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import modeles.Joueur;
import utils.PaletteColors;

public class PanPersonalScore extends JPanel {
	
	private static final long serialVersionUID = 1L;
	int xScreenSize, xPanSize, xTextPos, rank, score;
	int yTextPos = 40;
	String prénomJoueur = "John";
	Joueur joueur = null;

	final Color coulTextes = PaletteColors.HOT_GREY;
	final Color coulTextesTitres = PaletteColors.VIOLET_5_FONCE;
	
	//*********CONSTRUCTEUR*********
	public PanPersonalScore(int xScreenSize_, int yPanSize_, Joueur joueur_, Color coul_) {
		System.out.println("PanPersonalScore(int xScreenSize_, int yPanSize_, Joueur joueur_)");
		this.xScreenSize = xScreenSize_;
		this.xPanSize = (int) Math.round( xScreenSize / 8);
		this.xTextPos = (int) Math.round(xPanSize / 4);
		this.joueur = joueur_;
		this.score = joueur.getNbrePts();
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize_));
		
		this.setBackground(coul_);
	}
	
	//*********METHODES*********
    public void paint(Graphics g) {
    	System.out.println("PanPersonalScore - void paint(Graphics g)");
        super.paint(g);
        g.setFont(new Font("default", Font.BOLD, 22));
        g.setColor(coulTextesTitres);
        g.drawString("JOUEUR " + (joueur.getTour() + 1), xTextPos, yTextPos);
        g.setColor(coulTextes);
        g.drawString(joueur.getPrenom(), xTextPos, yTextPos + 30);
        g.setColor(coulTextesTitres);
        g.drawString("SCORE ", xTextPos, yTextPos + 60);
        g.setColor(coulTextes);
        g.drawString(score + "", xTextPos, yTextPos + 90);
    }

	public void setScore(int score_) {
		this.score = score_;
	}
}
