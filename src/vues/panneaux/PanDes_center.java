package vues.panneaux;

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
	
	JLabel l1;
	JTextField jtf;
	JButton button;
	
	Dimension dim = null;

	//*********CONSTRUCTEUR*********
	public PanDes_center(Control ctrl_, Dimension dim_) {
		this.ctrl = ctrl_;
		this.dim = dim_;
		this.setPreferredSize(dim);
	}
	//*********METHODES*********
}
