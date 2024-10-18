package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanPersonalScore extends JPanel {
	public PanPersonalScore(int screenSize, int height) {
		this.setPreferredSize(new Dimension((int) Math.round( screenSize / 8), height));
	}
	
    public void paint(Graphics g) {
        super.paint(g);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(10,20,80,80);
        g.setColor(Color.YELLOW);
        g.fillOval(100,50,80,80);
        g.setColor(c);
        g.drawString("JOUEUR 1", 12, 12);
    }
}
