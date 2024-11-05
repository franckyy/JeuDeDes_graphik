package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanPersonalScore extends JPanel {
	
	private static final long serialVersionUID = 1L;
	int xScreenSize, xPanSize, xTextPos, rank;
	int yTextPos = 40;
	String prénomJoueur = "John";
	
	//*********CONSTRUCTEUR*********
	public PanPersonalScore(int xScreenSize_, int yPanSize_, int rank_, String prénomJoueur_) {
		this.xScreenSize = xScreenSize_;
		this.xPanSize = (int) Math.round( xScreenSize / 8);
		this.xTextPos = (int) Math.round(xPanSize / 4);
		this.rank = rank_;
		this.prénomJoueur = prénomJoueur_;
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize_));
	}
	
	//*********METHODES*********
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("default", Font.BOLD, 15));
        g.setColor(Color.MAGENTA);
        g.drawString("JOUEUR " + (rank + 1), xTextPos, yTextPos);
        g.setColor(Color.GREEN);
        g.drawString(prénomJoueur, xTextPos, yTextPos + 20);
        g.setColor(Color.MAGENTA);
        g.drawString("SCORE ", xTextPos, yTextPos + 50);
        g.setColor(Color.GREEN);
        g.drawString("1250", xTextPos, yTextPos + 70);
    }
}
