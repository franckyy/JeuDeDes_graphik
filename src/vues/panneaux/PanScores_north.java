package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class PanScores_north extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	int xPanSize, yPanSize, yPanPersSize, nbreJoueurs;
	String[] prénomsJoueurs = null;
	
	//*********CONSTRUCTEUR*********
	public PanScores_north(int xPanSize_, int yPanSize_, int nbreJoueurs_, String[] prénomsJoueurs_) {
		this.xPanSize = xPanSize_;
		this.yPanSize = yPanSize_;
		this.nbreJoueurs = nbreJoueurs_;
		this.prénomsJoueurs = prénomsJoueurs_;
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		//hauteur du panneauPersonnel affiché
		yPanPersSize = (int) Math.round(yPanSize * 0.85);
		this.setLayout(new FlowLayout(1, 15, (int) Math.round((yPanSize - yPanPersSize) / 2)));	//FlowLayout​(int align, int hgap, int vgap)

		for(int i = 0; i < nbreJoueurs; i++) {
			this.add(new PanPersonalScore(xPanSize, yPanPersSize, i, prénomsJoueurs[i]));
			this.setBackground(Color.RED);
		}
		
		this.setBackground(Color.GRAY);
	}

	//*********METHODES*********
}
