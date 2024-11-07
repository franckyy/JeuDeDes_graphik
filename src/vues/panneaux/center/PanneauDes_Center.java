package vues.panneaux.center;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanneauDes_Center extends JPanel{

	private static final long serialVersionUID = 1L;

	//*********CONSTRUCTEUR*********
	public PanneauDes_Center() {
		this.setBackground(Color.pink);
	}

	//*********METHODES*********

    @Override
    public Dimension getPreferredSize() {
        // Définir la taille du panneau bas à deux tiers de la hauteur du PanneauCentre
        Dimension dim = super.getPreferredSize();
        dim.height = getParent().getHeight() * 2 / 3;  // Deux tiers de la hauteur du PanneauCentre
        return dim;
    }
}
