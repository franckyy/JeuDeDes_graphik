package ctrl;

import javax.swing.JOptionPane;

import modeles.Joueur;
import vues.Cadre;

public class Control {

	Cadre cadre = null;
	Joueur joueur = null;
	
	int nbreJoueurs = 0;
	
	String[] prenomsJoueurs = null;
	
	public static void main(String[] args) {
		Control ctrl = new Control();
	}
	
//*********CONSTRUCTEUR***********
	public Control() {

        // Demande le nombre de joueurs
        while (true) {
            try {
            	nbreJoueurs = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs (entre 2 et 7) ?"));
                if (nbreJoueurs >= 2 && nbreJoueurs <= 7) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Le nombre de joueurs doit être entre 2 et 7.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.");
            }
        }

        prenomsJoueurs = new String[nbreJoueurs];
        
        try {
            
            // Demande le prénom de chaque joueur
            for (int i = 0; i <= nbreJoueurs - 1; i++) {
                String prenom = JOptionPane.showInputDialog(null, "Veuillez entrer le prénom du joueur " + i + " :", "Demande de prénom", JOptionPane.QUESTION_MESSAGE);
                if (prenom != null && !prenom.trim().isEmpty()) {
                    prenomsJoueurs[i] = prenom;
                } else {
                    JOptionPane.showMessageDialog(null, "Prénom non saisi pour le joueur " + i + ".", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
		//affichage de l'interface graphique
		cadre = new Cadre(this, nbreJoueurs, prenomsJoueurs);
	}

//*********METHODES***********
	public int getNbreJoueurs() {
		return this.nbreJoueurs;
	}

	public void setNbreJoueurs(int nbreJoueurs_) {
		this.nbreJoueurs = nbreJoueurs_;
	}
}
