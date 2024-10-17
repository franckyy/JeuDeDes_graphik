package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanPersonalScore extends JPanel {
	public PanPersonalScore(int height) {
		
		
		this.setPreferredSize(new Dimension(200, height));
		this.setBackground(Color.CYAN);
//		Graphics g = getGraphics();
//		g.drawLine(100, 100, 100, 100);
//		g.dispose();
	}
}
