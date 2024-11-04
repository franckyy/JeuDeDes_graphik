package ctrl;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modeles.Joueur;
import vues.Cadre;

public class Control {

	Cadre cadre = null;
	Joueur joueur = null;
	
	int nbreJoueurs = 0;
	
	public static void main(String[] args) {
		Control ctrl = new Control();
	}
	
//*********CONSTRUCTEUR***********
	public Control() {

        // Demande le nombre de joueurs
        String nombreJoueursStr = JOptionPane.showInputDialog(null, "Veuillez entrer le nombre de joueurs :", "Demande de nombre de joueurs", JOptionPane.QUESTION_MESSAGE);

        // Vérifie si une valeur a été saisie et si c'est un nombre valide
        if (nombreJoueursStr != null && !nombreJoueursStr.trim().isEmpty()) {
            try {
                nbreJoueurs = Integer.parseInt(nombreJoueursStr);
                
                // Liste pour stocker les prénoms des joueurs
                ArrayList<String> prénomsJoueurs = new ArrayList<>();
                
                // Demande le prénom de chaque joueur
                for (int i = 1; i <= nbreJoueurs; i++) {
                    String prénom = JOptionPane.showInputDialog(null, "Veuillez entrer le prénom du joueur " + i + " :", "Demande de prénom", JOptionPane.QUESTION_MESSAGE);
                    if (prénom != null && !prénom.trim().isEmpty()) {
                        prénomsJoueurs.add(prénom);
                    } else {
                        JOptionPane.showMessageDialog(null, "Prénom non saisi pour le joueur " + i + ".", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Affiche la liste des prénoms
                String message = "Les prénoms des joueurs sont :\n" + String.join(", ", prénomsJoueurs);
                JOptionPane.showMessageDialog(null, message, "Liste des Joueurs", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aucun nombre saisi.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
		//affichage de l'interface graphique
		Cadre cadre = new Cadre(this);
	    
		//affichage question nombre de joueurs
		nbreJoueurs = cadre.initNbreJoueurs();
			
		//instanciations des panneaux de score des joueurs
		cadre.initPanScores(nbreJoueurs);
		
		//affichage question prénoms des joueurs
		cadre.initPrenoms(nbreJoueurs);
	}

//*********METHODES***********
	public int getNbreJoueurs() {
		return this.nbreJoueurs;
	}

	public void setNbreJoueurs(int nbreJoueurs_) {
		this.nbreJoueurs = nbreJoueurs_;
	}
}
