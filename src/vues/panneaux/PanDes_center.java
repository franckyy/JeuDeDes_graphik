package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanDes_center extends JPanel {

	public PanDes_center(int xPanSize, int yPanSize) {
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		this.setBackground(Color.red);
	}
}
