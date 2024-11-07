package vues.panneaux.center;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanneauMessages_Center extends JPanel{

	private static final long serialVersionUID = 1L;

	//*********CONSTRUCTEUR*********
	public PanneauMessages_Center() {
		this.setBackground(Color.red);
	}

	//*********METHODES*********

    @Override
    public Dimension getPreferredSize() {
        // Définir la taille du panneau haut à un tiers de la hauteur du PanneauCentre
        Dimension dim = super.getPreferredSize();
        dim.height = getParent().getHeight() / 3;  // Un tiers de la hauteur du PanneauCentre
        return dim;
    }

}
