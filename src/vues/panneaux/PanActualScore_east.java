package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanActualScore_east extends JPanel {

	private static final long serialVersionUID = 1L;
	int xTextPos;
	int yTextPos;
	
	public PanActualScore_east(int xPanSize, int yPanSize) {

		this.xTextPos = (int) Math.round(xPanSize / 4);
		this.yTextPos = (int) Math.round(yPanSize / 2);
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));

		this.setLayout(new FlowLayout(1, 0, (int) Math.round(yPanSize / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(Color.GREEN);
	}
	
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("default", Font.BOLD, 15));
        g.setColor(Color.MAGENTA);
        g.drawString("Dé 1", xTextPos, yTextPos);
        g.setColor(Color.RED);
        g.drawString("1", xTextPos + 5, yTextPos + 20);
        g.setColor(Color.MAGENTA);
        g.drawString("Dé 2", xTextPos, yTextPos + 40);
        g.setColor(Color.RED);
        g.drawString("5", xTextPos + 5, yTextPos + 60);
        g.setColor(Color.MAGENTA);
        g.drawString("Dé 3", xTextPos, yTextPos + 80);
        g.setColor(Color.RED);
        g.drawString("5", xTextPos + 5, yTextPos + 100);
        g.setColor(Color.MAGENTA);
        g.drawString("Dé 4", xTextPos, yTextPos + 120);
        g.setColor(Color.RED);
        g.drawString("3", xTextPos + 5, yTextPos + 140);
        g.setColor(Color.MAGENTA);
        g.drawString("Dé 5", xTextPos, yTextPos + 160);
        g.setColor(Color.RED);
        g.drawString("5", xTextPos + 5, yTextPos + 180);

        g.setColor(Color.MAGENTA);
        g.drawString("Total", xTextPos, yTextPos + 220);
        g.setColor(Color.RED);
        g.drawString("600", xTextPos + 5, yTextPos + 240);
    }
}
