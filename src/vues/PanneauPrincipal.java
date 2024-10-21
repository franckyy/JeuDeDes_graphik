package vues;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JPanel;

import vues.panneaux.PanActualScore_east;
import vues.panneaux.PanCommands_south;
import vues.panneaux.PanDes_center;
import vues.panneaux.PanScores_north;

public class PanneauPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Cadre cadre = null;
	PanDes_center des = null;
	String text;
	int nbreJoueurs;

	public PanneauPrincipal(Cadre cadre_) {
		
		this.cadre = cadre_;
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		//Récupération de la taille de l'écran afin de gérer les tailles de Panels
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xScreenSize = ((int) tk.getScreenSize().getWidth());  
		int yScreenSize = ((int) tk.getScreenSize().getHeight()); 
		
		//insertions des différents panneaux
		this.setLayout(new BorderLayout());
		
		//Paramétrages des dimensions de tous les sous panneaux
		int xPanNorth = xScreenSize;
		int yPanNorth = (int) Math.round(yScreenSize * 0.2);
		
		int xPanSouth = xScreenSize;
		int yPanSouth = (int) Math.round(yScreenSize * 0.1);
		
		int xPanEast = (int) Math.round(xScreenSize * 0.2);
		int yPanEast = (int) Math.round(yScreenSize * 0.3);
		
		int xPanCenter = (int) Math.round(xScreenSize * 0.8);
		int yPanCenter = (int) Math.round(yScreenSize * 0.3);
		
		PanScores_north scores = new PanScores_north(xPanNorth, yPanNorth);
		PanCommands_south commandes = new PanCommands_south(xPanSouth, yPanSouth);
		PanActualScore_east actualScore = new PanActualScore_east(xPanEast, yPanEast);
		des = new PanDes_center(xPanCenter, yPanCenter);
		
		this.add(scores ,BorderLayout.NORTH);
		this.add(des,BorderLayout.CENTER);
		this.add(actualScore,BorderLayout.EAST);
		this.add(commandes,BorderLayout.SOUTH);		
	}
	
	public void initNbreJoueurs() {
		des.initNbreJoueurs();
	}
	
	public void setNbreJoueurs(int NbreJoueurs_) {
		new Cadre().setNbreJoueurs(NbreJoueurs_);
	}
}
