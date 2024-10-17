package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanActualScore_east extends JPanel {

	public PanActualScore_east(int x, int y) {
		//transformation de y double en entier avec calcul de pourcentage
		int heightPan = (int) Math.round(y * 0.3);
		int widhtPan = (int) Math.round(x * 0.2);
		this.setPreferredSize(new Dimension(widhtPan, heightPan));

		this.setBackground(Color.GREEN);
		
	}
}
