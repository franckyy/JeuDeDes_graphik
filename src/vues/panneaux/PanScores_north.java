package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanScores_north extends JPanel {
	
	public PanScores_north(int xScreenSize, int yScreenSize) {
		
		int yPanSize = (int) Math.round(yScreenSize * 0.2); //hauteur du panneau de scores NORTH
		this.setPreferredSize(new Dimension(xScreenSize, yPanSize));
		
		//hauteur du panneauPersonnel affiché
		int yPanPersSize = (int) Math.round(yPanSize * 0.85);
		this.setLayout(new FlowLayout(1, 15, (int) Math.round((yPanSize - yPanPersSize) / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(Color.GRAY);
		
		for(int i = 0; i < 7; i++) {
			PanPersonalScore psc = new PanPersonalScore(xScreenSize, yPanPersSize, i);
			this.add(psc);
		}
	}
}
