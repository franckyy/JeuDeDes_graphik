package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
	
	JPanel panMessages = null;
	JPanel panDes = null;

	//*********CONSTRUCTEUR*********
	public PanDes_center(Control ctrl_, Dimension dim_) {
		this.ctrl = ctrl_;
		this.dim = dim_;
		this.setPreferredSize(dim);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panMessages = new JPanel();
		panDes = new JPanel();
		
		panMessages.setBackground(Color.red);
		panDes.setBackground(Color.pink);
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(panMessages);
		this.add(panDes);
	}


	//*********METHODES*********
}
