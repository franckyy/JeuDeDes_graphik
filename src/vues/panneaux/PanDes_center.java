package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanDes_center extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanDes_center(int xPanSize, int yPanSize) {
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		this.setBackground(Color.red);
	}
	
	public void initJeu() {
		this.setBackground(Color.green);
	}
}
