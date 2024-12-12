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

	String message = "";// message en première ligne
	String message2 = "";// message de la deuxième ligne
	
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
        g.setColor(PaletteColors.HOT_GREY);
        
        // Calculer la largeur des messages
        int messageWidth = g.getFontMetrics().stringWidth(message);
        int message2Width = g.getFontMetrics().stringWidth(message2);
        
        // Calculer les positions X pour centrer les textes
        int x = (this.getWidth() - messageWidth) / 2;
        int x2 = (this.getWidth() - message2Width) / 2;
        
        //deux lignes, deux messages
        g.drawString(message, x, this.getHeight() * 2 / 4);
        g.drawString(message2, x2, this.getHeight() * 3 / 4);
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

    public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}
}
