package vues.panneaux.center;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauMessages_Center extends JPanel{

	private static final long serialVersionUID = 1L;

	String message = null;
	
	//*********CONSTRUCTEUR*********
	public PanneauMessages_Center() {
		this.setBackground(Color.red);
	}

	//*********METHODES*********
    public void paint(Graphics g) {
        super.paint(g);
        
        g.setFont(new Font("default", Font.BOLD, this.getHeight() / 5));
        g.setColor(Color.MAGENTA);
        g.drawString(message, 100, this.getHeight() / 2);
    }

    @Override
    public Dimension getPreferredSize() {
        // Définir la taille du panneau haut à un tiers de la hauteur du PanneauCentre
        Dimension dim = super.getPreferredSize();
        dim.height = getParent().getHeight() / 3;  // Un tiers de la hauteur du PanneauCentre
        return dim;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
