package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanActualScore_east extends JPanel {

	public PanActualScore_east(int xScreenSize_, int yScreenSize_) {
		//transformation de y double en entier avec calcul de pourcentage
		int widhtPan = (int) Math.round(xScreenSize_ * 0.2);
		int heightPan = (int) Math.round(yScreenSize_ * 0.3);
		this.setPreferredSize(new Dimension(widhtPan, heightPan));

		this.setLayout(new FlowLayout(1, 0, (int) Math.round(heightPan / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(Color.GREEN);
		
		PanActualScore pas = new PanActualScore(widhtPan, heightPan);
		this.add(pas);
	}
}
