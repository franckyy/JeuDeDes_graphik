package ctrl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import modeles.Dice;
import modeles.Joueur;
import vues.Cadre;
import vues.panneaux.center.Pan_center;
import vues.panneaux.center.PanneauDes_Center;
import vues.panneaux.east.PanActualScore_east;
import vues.panneaux.north.PanScores_north;
import vues.panneaux.south.PanCommands_south;

public class Control {

	private Cadre cadre = null;
	private Joueur[] joueurs = null;
	private PanScores_north panScores_north = null;
	private Pan_center pan_center = null;
	private PanneauDes_Center panDes = null;
	private PanCommands_south panCommands = null;
	private PanActualScore_east panScoreEast = null;
	private int nbreJoueurs = 0;
	private int joueurActuel = 0;
    private Dice dice;  // Instance de la classe Dice pour gérer les lancers
    private int[] desInterdits = new int[5];	// tableau pour les dés qui ne devront pas être relancés
    
	private String[] prenomsJoueurs = null;
	
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
        
        //instanciation des dés
        this.dice = new Dice(5);  // Par exemple, 5 dés par joueur
        
        //Instanciation des joueurs
        joueurs = new Joueur[nbreJoueurs];
        
        for (int i = 0; i <= nbreJoueurs - 1; i++) {
        	joueurs[i] = new Joueur(i, prenomsJoueurs[i]);
        }
        
		//création et affichage de l'interface graphique
		cadre = new Cadre(this, joueurs);

		this.messBienvenue(joueurs[joueurActuel]);
	}

	//*********METHODES***********
	private void messBienvenue(Joueur joueur) {
		pan_center.setMessage("Bonjour");
		pan_center.repaint();
		
		this.attendre(2000);

		pan_center.setMessage("Bienvenue dans notre jeu de dés");
		pan_center.repaint();	
		
		this.attendre(2000);

		pan_center.setMessage("à toi de lancer les dés " + joueur.getPrenom());
		pan_center.repaint();
		
		panCommands.enableBoutons(true);
	}

	public void lancerDes() {
		dice.lancerDes();  // Lancer les dés
                
		//affiche les valeurs des dés dans le panneau Des
		panDes.setValeursDes(dice.getValeursDes());
		
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        panCommands.enableBoutons(true);
		    }
		});
		
		this.verificationDes(dice.getValeursDes());
	}//	fin lancerDes()

	private void verificationDes(int[] lancers) {

		//évaluation du score
		int score = 0;
		
		// Création d'une Map pour stocker les variables dynamiques
        Map<String, Integer> nbres = new HashMap<>();
		
        nbres.put("nbre1", 0);
        nbres.put("nbre2", 0);
        nbres.put("nbre3", 0);
        nbres.put("nbre4", 0);
        nbres.put("nbre5", 0);
        nbres.put("nbre6", 0);
		
		for(int chiffre : lancers) {
		
			//vérification des lancers
				
				switch(chiffre){
					case 1:
						nbres.put("nbre1", nbres.get("nbre1") + 1);
						break;
					case 2:
						nbres.put("nbre2", nbres.get("nbre2") + 1);
						break;
					case 3:
						nbres.put("nbre3", nbres.get("nbre3") + 1);
						break;
					case 4:
						nbres.put("nbre4", nbres.get("nbre4") + 1);
						break;
					case 5:
						nbres.put("nbre5", nbres.get("nbre5") + 1);
						break;
					case 6:
						nbres.put("nbre6", nbres.get("nbre6") + 1);
						break;
				}	//end switch			
		}// fin de for(int chiffre : lancers) 
		
		// voir si il n'y a aucun score :
		int rangLancers = 0;
		//Si nous avons une suite, aucun dé n'est interdit
		if(!((nbres.get("nbre1") == 1 && nbres.get("nbre2") == 1 &&nbres.get("nbre3") == 1 &&nbres.get("nbre4") == 1 &&nbres.get("nbre5") == 1) 
					|| (nbres.get("nbre2") == 1 &&nbres.get("nbre3") == 1 &&nbres.get("nbre4") == 1 &&nbres.get("nbre5") == 1 && nbres.get("nbre6") == 1))) {

			for(int chiffre : lancers) {
				//je dois recréer le nom de la variable nbrex avec le chiffre du dé
				String valeurDe = "nbre" + chiffre;
	
				if(chiffre != 1 && chiffre != 5 && nbres.get(valeurDe) <= 2) {
					desInterdits[rangLancers] = -1;
				}
				
				rangLancers++;
			}
		}
		//demander au panneauDes de griser les dés qui ne font pas de scores
		panDes.griserDes(desInterdits);
		
		//ré initialiser le tableau desInterdits
		for(int i = 0; i<= 4; i++) {
			desInterdits[i] = 0;
		}
		

		
		//Avant de vérifier, je dois voir si tous les dés ne sont pas interdits.
		
		if(Arrays.stream(desInterdits).anyMatch(x -> x == 0)) {			
			
			//Vérification d'une suite 
			if((nbres.get("nbre1") == 1 && nbres.get("nbre2") == 1 && nbres.get("nbre3") == 1 && nbres.get("nbre4") == 1 && nbres.get("nbre5") == 1)
				|| (nbres.get("nbre2") == 1 && nbres.get("nbre3") == 1 && nbres.get("nbre4") == 1 && nbres.get("nbre5") == 1 && nbres.get("nbre6") == 1)){
				
				score = score + 500;
			
			//Vérification des autres possibilités
			}else{
				if(nbres.get("nbre1") != 0){
					switch(nbres.get("nbre1")){
						case 1:
							score = score + 100;
								//nbreDesRestants = nbreDesRestants - 1;
							break;
						case 2:
							score = score + 200;
	//						nbreDesRestants = nbreDesRestants - 2;
							break;
						case 3:
							score = score + 1000;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							score = score + 2000;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							score = score + 3000;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre1
				}	//fin if nbre1
				
				if(nbres.get("nbre2") == 3 || nbres.get("nbre2") == 4 || nbres.get("nbre2") == 5){
					switch(nbres.get("nbre2")){
						case 3:
							score = score + 200;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							score = score + 400;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							score = score + 600;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre2
				}	//fin du if nbre2
				
				if(nbres.get("nbre3") > 2){
					switch(nbres.get("nbre3")){
						case 3:
							score = score + 300;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							score = score + 600;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							score = score + 900;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre3
				}	//fin if nbre3
				
				if(nbres.get("nbre4") > 2){
					switch(nbres.get("nbre4")){
						case 3:
							score = score + 400;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							score = score + 800;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							score = score + 1200;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre4
				}	//fin if nbre4
				
				if(nbres.get("nbre5") != 0){
					switch(nbres.get("nbre5")){
						case 1:
							score = score + 50;
	//						nbreDesRestants = nbreDesRestants - 1;
							break;
						case 2:
							score = score + 100;
	//						nbreDesRestants = nbreDesRestants - 2;
							break;
						case 3:
							score = score + 500;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							score = score + 1000;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							score = score + 1500;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre5
				}	//fin if nbre5
				
				if(nbres.get("nbre6") > 2){
					switch(nbres.get("nbre6")){
						case 3:
							score = score + 600;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							score = score + 1200;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							score = score + 1800;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre6
				}	//fin if nbre6		
			}//	fin du else
		}

		pan_center.setMessage("score : " + score);
		pan_center.repaint();
	}//	fin de verificationDes(int[] lancers)
	
	public void finirTour() {
		pan_center.setMessage("coucou clic !! clic !!");
		pan_center.repaint();
	}

	private void attendre(int temps) {
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//*********GETTERS AND SETTERS*********
	public int getNbreJoueurs() {
		return this.nbreJoueurs;
	}

	public void setNbreJoueurs(int nbreJoueurs_) {
		this.nbreJoueurs = nbreJoueurs_;
	}

	public void setPanScores_north(PanScores_north panScores_north_) {
		this.panScores_north = panScores_north_;
	}

	public void setPan_center(Pan_center _pan_center) {
		this.pan_center = _pan_center;
	}
	
	public void setPanDes(PanneauDes_Center _panDes) {
		this.panDes = _panDes;
	}

	public void setPanCommands(PanCommands_south _panCommands) {
		this.panCommands = _panCommands;
	}

	public void setPanScoreEast(PanActualScore_east _panScoreEast) {
		this.panScoreEast = _panScoreEast;
	}
}
