package ctrl;

import javax.swing.JOptionPane;

import modeles.Joueur;
import vues.Cadre;
import vues.panneaux.center.Pan_center;
import vues.panneaux.north.PanScores_north;
import vues.panneaux.south.PanCommands_south;

public class Control {

	Cadre cadre = null;
	Joueur[] joueurs = null;
	PanScores_north panScores_north = null;
	Pan_center pan_center = null;
	PanCommands_south panCommands = null;
	int nbreJoueurs = 0;

	int incrResult;	//commence à 1 pour nous montrer l'emplacement du premier dé dans le tableau
	
	String[] prenomsJoueurs = null;
	
	public static void main(String[] args) {
		Control ctrl = new Control();
	}
	
//*********CONSTRUCTEUR***********
	public Control() {

		String relancer = "";
		
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
        
        //Instanciation des joueurs
        joueurs = new Joueur[nbreJoueurs];
        
        for (int i = 0; i <= nbreJoueurs - 1; i++) {
        	joueurs[i] = new Joueur(i, prenomsJoueurs[i]);
        }
        
		//affichage de l'interface graphique
		cadre = new Cadre(this, joueurs);

		this.messBienvenue();
				
		boolean gagne = false;
		
		do {
			for(Joueur joueur : joueurs) {
				
				this.messJoueurJoue(joueur);
				
				
			}	//end for(joueur)
		}while(gagne != true);
	}

	//*********METHODES***********
	private void messBienvenue() {
		pan_center.setMessage("Bonjour");
		pan_center.repaint();
		
		this.attendre(1500);

		pan_center.setMessage("Bienvenue dans notre jeu de dés");
		pan_center.repaint();	
		
		this.attendre(1500);
	}
	
	private void messJoueurJoue(Joueur joueur) {
		pan_center.setMessage("à toi de lancer les dés " + joueur.getPrenom());
		pan_center.repaint();
		
		panCommands.enableBoutons(true);
		
		this.attendre(1500);
	}
	
	public int getNbreJoueurs() {
		return this.nbreJoueurs;
	}

	public void setNbreJoueurs(int nbreJoueurs_) {
		this.nbreJoueurs = nbreJoueurs_;
	}

	public void setPanScores_north(PanScores_north panScores_north_) {
		this.panScores_north = panScores_north_;
	}

	public void setPan_center(Pan_center pan_center) {
		this.pan_center = pan_center;
	}
	
	public void setPanCommands(PanCommands_south panCommands) {
		this.panCommands = panCommands;
	}

	private void attendre(int temps) {
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
