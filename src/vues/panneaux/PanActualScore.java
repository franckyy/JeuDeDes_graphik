package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanActualScore extends JPanel {

	int xPanSize;
	int yPanSize;
	
	public PanActualScore(int xScreenSize_, int yScreenSize_) {
		this.xPanSize = (int) Math.round(yScreenSize_ * 0.8);
		this.yPanSize = (int) Math.round(yScreenSize_);
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		this.setBackground(Color.yellow);
	}
}
