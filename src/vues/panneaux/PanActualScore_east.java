package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanActualScore_east extends JPanel {

	public PanActualScore_east(int xPanSize, int yPanSize) {
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));

		this.setLayout(new FlowLayout(1, 0, (int) Math.round(yPanSize / 2)));	//FlowLayout​(int align, int hgap, int vgap)
		
		this.setBackground(Color.GREEN);
		
		PanActualScore pas = new PanActualScore(xPanSize, yPanSize);
		this.add(pas);
	}
}
