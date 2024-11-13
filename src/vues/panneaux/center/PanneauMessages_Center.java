package vues.panneaux.center;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import utils.PaletteColors;

public class PanneauMessages_Center extends JPanel{

	private static final long serialVersionUID = 1L;

	final Color coulBackPanel = PaletteColors.BACKGROUND_SECOND;

	String message = "";
	
	//*********CONSTRUCTEUR*********
	public PanneauMessages_Center() {
		System.out.println("PanneauMessages_Center()");
		this.setBackground(coulBackPanel);
	}

	//*********METHODES*********
    public void paint(Graphics g) {
    	System.out.println("PanneauMessages_Center - void paint(Graphics g)");
        super.paint(g);

        g.setFont(new Font("default", Font.BOLD, this.getHeight() / 5));
        g.setColor(Color.MAGENTA);
        
        // Calculer la largeur du message
        int messageWidth = g.getFontMetrics().stringWidth(message);
        
        // Calculer la position X pour centrer le texte
        int x = (this.getWidth() - messageWidth) / 2;
        
        g.drawString(message, x, this.getHeight() / 2);
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
