package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanScores_north extends JPanel {
	
	public PanScores_north(int x, int y) {
		
		//transformation de y double en entier avec calcul de pourcentage
		int height = (int) Math.round(y * 0.2); //hauteur du panneau de scores NORTH
		this.setPreferredSize(new Dimension(x, height));
		
		//hauteur du panneauPersonnel affiché
		int heightFils = (int) Math.round(height * 0.85);
		this.setLayout(new FlowLayout(0, 10, (int) Math.round((height - heightFils) / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(Color.BLUE);
		
		PanPersonalScore psc = new PanPersonalScore(heightFils);
		
		this.add(psc);
	}
}
