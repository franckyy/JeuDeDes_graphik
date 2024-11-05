package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ctrl.Control;

public class PanDes_center extends JPanel {

	private static final long serialVersionUID = 1L;

	Control ctrl = null;
	
	int xPanSize, yPanSize;
	int nbreJoueurs = 0;
	
	JLabel l1;
	JTextField jtf;
	JButton button;

	public PanDes_center(Control ctrl_, int xPanSize_, int yPanSize_) {
		this.ctrl = ctrl_;
		this.xPanSize = xPanSize_;
		this.yPanSize = yPanSize_;
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
	}
}
