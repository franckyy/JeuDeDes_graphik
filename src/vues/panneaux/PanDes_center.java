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
	
	public int initNbreJoueurs() {
		
		
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
	    
	    button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = jtf.getText();
								
				if (text.matches("^([2-7])$")) {
					ctrl.setNbreJoueurs((int) Integer.parseInt(text));
//					nbreJoueurs = (int) Integer.parseInt(text);
				}
			}
		});
	    
	    return nbreJoueurs;
	}
	

	public void initPrenoms(int nbreJoueurs_) {
		//les éléments suivants sont pour essayer
		l1.setText("youpi");
		jtf.setBackground(Color.red);
	}
}
