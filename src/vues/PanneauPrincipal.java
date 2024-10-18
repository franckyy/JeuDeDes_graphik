package vues;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

import vues.panneaux.PanActualScore_east;
import vues.panneaux.PanCommands_south;
import vues.panneaux.PanDes_center;
import vues.panneaux.PanScores_north;

public class PanneauPrincipal extends JPanel {

	public PanneauPrincipal() {
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		//Récupération de la taille de l'écran afin de gérer les tailles de Panels
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xScreenSize = ((int) tk.getScreenSize().getWidth());  
		int yScreenSize = ((int) tk.getScreenSize().getHeight()); 
		
		//insertions des différents panneaux
		this.setLayout(new BorderLayout());
		
		PanScores_north scores = new PanScores_north(xScreenSize, yScreenSize);
		PanCommands_south commandes = new PanCommands_south(xScreenSize, yScreenSize);
		PanActualScore_east actualScore = new PanActualScore_east(xScreenSize, yScreenSize);
		PanDes_center des = new PanDes_center();
		
		this.add(scores ,BorderLayout.NORTH);
		this.add(des,BorderLayout.CENTER);
		this.add(actualScore,BorderLayout.EAST);
		this.add(commandes,BorderLayout.SOUTH);		
	}
}
