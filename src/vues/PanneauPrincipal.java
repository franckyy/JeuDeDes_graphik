package vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

import ctrl.Control;
import modeles.Joueur;
import vues.panneaux.center.Pan_center;
import vues.panneaux.east.PanActualScore_east;
import vues.panneaux.north.PanScores_north;
import vues.panneaux.south.PanCommands_south;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Control ctrl = null;
	Pan_center des = null;
	String text;
	PanScores_north scores = null;
	String[] prénomsJoueurs = null;
	Joueur[] joueurs = null;
	Dimension dimCenter = null;
	Dimension dimEast = null;

	//*********CONSTRUCTEUR*********
	public PanneauPrincipal(Control ctrl_, Joueur[] joueurs_) {
		System.out.println("PanneauPrincipal(Control ctrl_, Joueur[] joueurs_)");
		this.ctrl = ctrl_;
		this.joueurs = joueurs_;
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
		
		dimEast = new Dimension((int) Math.round(xScreenSize * 0.2), (int) Math.round(yScreenSize * 0.3));
		
		scores = new PanScores_north(xPanNorth, yPanNorth, joueurs, ctrl);
		PanCommands_south commandes = new PanCommands_south(xPanSouth, yPanSouth, ctrl);
		PanActualScore_east actualScore = new PanActualScore_east(dimEast, ctrl);
		des = new Pan_center(ctrl);
		
		this.add(scores ,BorderLayout.NORTH);
		this.add(des,BorderLayout.CENTER);
		this.add(actualScore,BorderLayout.EAST);
		this.add(commandes,BorderLayout.SOUTH);		
	}
	
	//*********METHODES*********
}
