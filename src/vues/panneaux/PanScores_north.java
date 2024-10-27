package vues.panneaux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanScores_north extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	int xPanSize, yPanSize, yPanPersSize;

	PanPersonalScore[] pans = null;
	
	//*********CONSTRUCTEUR*********
	public PanScores_north(int xPanSize_, int yPanSize_) {
		this.xPanSize = xPanSize_;
		this.yPanSize = yPanSize_;
		
		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		//hauteur du panneauPersonnel affiché
		yPanPersSize = (int) Math.round(yPanSize * 0.85);
		this.setLayout(new FlowLayout(1, 15, (int) Math.round((yPanSize - yPanPersSize) / 2)));	//FlowLayout​(int align, int hgap, int vgap)

		this.setBackground(Color.GRAY);
	}

	//*********METHODES*********
	public void initPanScores(int nbreJoueurs_) {
		for(int i = 0; i < nbreJoueurs_; i++) {
			pans[i] = new PanPersonalScore(xPanSize, yPanPersSize, i);
			this.add(pans[i]);
			this.setBackground(Color.RED);
		}
	}
}
