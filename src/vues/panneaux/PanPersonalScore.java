package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanPersonalScore extends JPanel {
	
	int xScreenSize;
	int xPanSize;
	int xTextPos;
	int yTextPos = 40;
	int rank;
	
	public PanPersonalScore(int screenSize_, int yPanSize, int rank_) {
		this.xScreenSize = screenSize_;
		this.xPanSize = (int) Math.round( xScreenSize / 8);
		this.xTextPos = (int) Math.round(xPanSize / 4);
		this.rank = rank_;
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
	}
	
    public void paint(Graphics g) {
        super.paint(g);
        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillRect(10,20,80,80);
//        g.setColor(Color.YELLOW);
//        g.fillOval(100,50,80,80);
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("default", Font.BOLD, 15));
        g.drawString("JOUEUR " + (rank + 1), xTextPos, yTextPos);
        g.setColor(Color.GREEN);
        g.drawString("LILIE", xTextPos, yTextPos + 20);
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("default", Font.BOLD, 15));
        g.drawString("SCORE ", xTextPos, yTextPos + 40);
        g.setColor(Color.GREEN);
        g.drawString("1250", xTextPos, yTextPos + 60);
    }
}
