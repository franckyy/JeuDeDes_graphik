package vues.panneaux.east;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import ctrl.Control;

public class PanActualScore_east extends JPanel {

	private static final long serialVersionUID = 1L;
	int xTextPos, yTextPos;
	int score = 0;
	
	Dimension dim = null;
	Control ctrl = null;

	//*********CONSTRUCTEUR*********
	public PanActualScore_east(Dimension dim_, Control _ctrl) {

		this.ctrl =_ctrl;
		
		ctrl.setPanScoreEast(this);
		
		this.dim = dim_;
		
		this.xTextPos = (int) Math.round(dim.width / 4);
		this.yTextPos = (int) Math.round(dim.height / 2);
		
		this.setPreferredSize(dim);

		this.setLayout(new FlowLayout(1, 0, (int) Math.round(dim.getHeight() / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(Color.GREEN);
	}

	//*********METHODES*********
	public void setMessage(int _score) {
		this.setScore(_score);
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
        g.drawString("" + score, xTextPos + 5, yTextPos + 240);
    }

	//*********GETTERS and SETTERS*********
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
