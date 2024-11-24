package vues.panneaux.east;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import ctrl.Control;
import utils.PaletteColors;

public class PanActualScore_east extends JPanel {

	private static final long serialVersionUID = 1L;
	// Création d'une Map pour stocker les variables dynamiques
    Map<String, String> des = new HashMap<>();
    
	int xTextPos, yTextPos;
	int score = 0;
	int scoreCumul = 0;
	
	Dimension dim = null;
	Control ctrl = null;

	final Color coulBackPanel = PaletteColors.BACKGROUND_SECOND;
	final Color coulTextes = PaletteColors.HOT_GREY;
	final Color coulTextesTitres = PaletteColors.VIOLET_5_FONCE;

	//*********CONSTRUCTEUR*********
	public PanActualScore_east(Dimension dim_, Control _ctrl) {
		System.out.println("PanActualScore_east(Dimension dim_, Control _ctrl)");
		this.ctrl =_ctrl;
		
		//initialisation de la Map qui contient les faces des dés
		des.put("de1", "1");
		des.put("de2", "2");
		des.put("de3", "3");
		des.put("de4", "4");
		des.put("de5", "5");
		
		ctrl.setPanScoreEast(this);
		
		this.dim = dim_;
		
		this.xTextPos = (int) Math.round(dim.width / 4);
		this.yTextPos = (int) Math.round(dim.height / 2);
		
		this.setPreferredSize(dim);

		this.setLayout(new FlowLayout(1, 0, (int) Math.round(dim.getHeight() / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(coulBackPanel);
	}

	//*********METHODES*********
	public void setMessage(int _score) {
		this.setScore(_score);
	}

	public void paint(Graphics g) {
		System.out.println("PanActualScore_east - void paint(Graphics g)");
        super.paint(g);
        g.setFont(new Font("default", Font.BOLD, 30));
        g.setColor(coulTextesTitres);
        g.drawString("Dé 1", xTextPos, yTextPos);
        g.setColor(coulTextes);
        g.drawString(des.get("de1"), xTextPos + 5, yTextPos + 30);
        g.setColor(coulTextesTitres);
        g.drawString("Dé 2", xTextPos, yTextPos + 60);
        g.setColor(coulTextes);
        g.drawString(des.get("de2"), xTextPos + 5, yTextPos + 90);
        g.setColor(coulTextesTitres);
        g.drawString("Dé 3", xTextPos, yTextPos + 120);
        g.setColor(coulTextes);
        g.drawString(des.get("de3"), xTextPos + 5, yTextPos + 150);
        g.setColor(coulTextesTitres);
        g.drawString("Dé 4", xTextPos, yTextPos + 180);
        g.setColor(coulTextes);
        g.drawString(des.get("de4"), xTextPos + 5, yTextPos + 210);
        g.setColor(coulTextesTitres);
        g.drawString("Dé 5", xTextPos, yTextPos + 240);
        g.setColor(coulTextes);
        g.drawString(des.get("de5"), xTextPos + 5, yTextPos + 270);

        g.setColor(coulTextesTitres);
        g.drawString("Total", xTextPos, yTextPos + 330);
        g.setColor(coulTextes);
        g.drawString("" + score, xTextPos + 5, yTextPos + 360);

        g.setColor(coulTextesTitres);
        g.drawString("Total cumulé", xTextPos, yTextPos + 410);
        g.setColor(coulTextes);
        g.drawString("" + scoreCumul, xTextPos + 5, yTextPos + 440);
    }

	public void setDes(int[] valeursDes) {
		System.out.println("PanActualScore_east - void setDes(int[] valeursDes)");
		for(int i = 1; i <= 5; i++) {
			des.put("de" + i, valeursDes[i - 1] + "");
		}
	}
	
	//*********GETTERS and SETTERS*********
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
