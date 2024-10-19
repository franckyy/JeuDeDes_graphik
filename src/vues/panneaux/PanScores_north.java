package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanScores_north extends JPanel {
	
	public PanScores_north(int xPanSize, int yPanSize) {
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		//hauteur du panneauPersonnel affiché
		int yPanPersSize = (int) Math.round(yPanSize * 0.85);
		this.setLayout(new FlowLayout(1, 15, (int) Math.round((yPanSize - yPanPersSize) / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(Color.GRAY);
		
		for(int i = 0; i < 7; i++) {
			PanPersonalScore psc = new PanPersonalScore(xPanSize, yPanPersSize, i);
			this.add(psc);
		}
	}
}
