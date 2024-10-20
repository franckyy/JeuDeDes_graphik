package vues.panneaux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanDes_center extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int xPanSize, yPanSize;
	
	JLabel l1;
	JTextField jtf;
	JButton button;

	public PanDes_center(int xPanSize_, int yPanSize_) {
		this.xPanSize = xPanSize_;
		this.yPanSize = yPanSize_;
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
	}
	
	public void initNbreJoueurs() {
	    l1 = new JLabel("Quel est le nombre de joueurs ? (entre 2 et 7 joueurs)");
	    
	    Font font = new Font("Arial", Font.BOLD, 35);
	    
	    l1.setFont(font);
	    l1.setBounds(xPanSize / 6, yPanSize / 2, 1000, 100);
	    this.add(l1);
	    
	    jtf = new JTextField("2", 10);
	    jtf.setBackground(Color.cyan);
	    jtf.setBounds(xPanSize / 6, yPanSize / 2 + 100, 100, 50);
	    jtf.setFont(font);
	    
	    this.add(jtf);
	    	   
	    button = new JButton("Valider");
	    button.setBounds(xPanSize / 6 + 200, yPanSize / 2 + 100, 200, 50);
	    button.setFont(font);
	    
	    this.add(button);
	    
	    this.setBackground(Color.GRAY);
	}
}
