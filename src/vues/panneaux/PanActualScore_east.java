package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanActualScore_east extends JPanel {

	public PanActualScore_east(int xScreenSize, int yScreenSize) {
		//transformation de y double en entier avec calcul de pourcentage
		int widhtPan = (int) Math.round(xScreenSize * 0.2);
		int heightPan = (int) Math.round(yScreenSize * 0.3);
		this.setPreferredSize(new Dimension(widhtPan, heightPan));

		this.setBackground(Color.GREEN);
		
	}
}
