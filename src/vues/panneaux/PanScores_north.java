package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanScores_north extends JPanel {
	
	public PanScores_north(int x, int y) {
		//transformation de y double en entier avec calcul de pourcentage
		int height = (int) Math.round(y * 0.2);
		this.setPreferredSize(new Dimension(x, height));
		
		this.setBackground(Color.BLUE);
	}
}
