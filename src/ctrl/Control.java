package ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

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
	private boolean premierLancer = true;
    private Dice dice;  // Instance de la classe Dice pour gérer les lancers
    private int[] desInterdits = new int[5];	// tableau pour les dés qui ne devront pas être relancés
    private int pointsCumules = 0;	//C'est le total des points de tous les lancers
    private boolean finTour = false;
    private int pointsLancer = 0;//C'est le total des points donnés par les dés lors d'un seul lancer
    private Map<String, Integer> nbres = null;
    
	private String[] prenomsJoueurs = null;
	
	public static void main(String[] args) {
		Control ctrl = new Control();
	}
	
//*********CONSTRUCTEUR***********
	public Control() {
		System.out.println("Control()");
		
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
        	joueurs[i] = new Joueur(i, prenomsJoueurs[i], this);
        }
        
		//création et affichage de l'interface graphique
		cadre = new Cadre(this, joueurs);
		
		//Définition de l'état des boutons par la méthode updateBoutons afin de pouvoir ultérieurement les redéfinir
	    Runnable lancerAction = () -> {
	        lancerDes();
            panCommands.enableBoutons(false);
	    };
		
		//Définition de l'état des boutons par la méthode updateBoutons afin de pouvoir ultérieurement les redéfinir
	    Runnable arreterAction = () -> {
	        // Logique pour l'action du bouton Arrêter (si nécessaire)
	    	finirLancer();
	    };
	    
		panCommands.updateButtons("Lancer les des", lancerAction, "Arreter le tour", arreterAction);

		this.messBienvenue(joueurs[joueurActuel]);
	}

	//*********METHODES***********
	private void messBienvenue(Joueur joueur) {
		System.out.println("Control - void messBienvenue(Joueur joueur)");

	    attendre(100, () -> {
	        pan_center.setMessage("Bonjour");
	        
	        pan_center.setMessage2("Bienvenue dans notre jeu de dés");
	        pan_center.repaint();
	        
	        attendre(3000, () -> {
	            pan_center.setMessage("à toi de lancer les dés " + joueur.getPrenom());

		        pan_center.setMessage2("");
	            pan_center.repaint();
	            
	            panCommands.enableBoutons(true);
	        });
	    });
	}

	public void lancerDes() {
		System.out.println("Control - void lancerDes()");
		
		dice.lancerDes(desInterdits, premierLancer);  // Lancer les dés
                
		//affiche les valeurs des dés dans le panneau Des et rempli le tableau
		panDes.setValeursDes(dice.getValeursDes());
		
		//affiche les valeurs de chaque dé dans le panneau actual score east
		panScoreEast.setDes(dice.getValeursDes());
		
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        panCommands.enableBoutons(true);
		    }
		});
		
		pointsLancer = this.verificationDes(dice.getValeursDes());
		pointsCumules = pointsCumules + pointsLancer;
		
		//affichage des scores du lancer sur le panneauEast
		panScoreEast.setScore(pointsLancer);
		panScoreEast.setScoreCumul(pointsCumules);
		panScoreEast.repaint();
		
		//TODO Le joueur souhaite-t'il relancer les dés ?
		//si oui, il va falloir ajouter le score actuel avec le score du prochain lancer
			//S'il ne réalise pas de score au prochain lancer, le joueur perd tout son score
		//si non, on ajoute le score actuel au score du joueur
		
		pan_center.setMessage("Le score de votre lancer est de " + pointsLancer + " points");
		pan_center.setMessage2("Souhaitez vous relancer au risque de tout perdre ?");
		pan_center.repaint();
	}//	fin lancerDes()
	
	public void finirLancer() {
		System.out.println("Control - void finirTour()");
		
		//Lorsque le joueur arrete son tour, il faut ajouter le score actuel au score du joueur et l'afficher dans panneau north
		//Il est alors demandé au joueur suivant de jouer
		
		//On met le score du joueur actuel à jour
		int retour = joueurs[joueurActuel].setNbrePts(pointsCumules);

		//L'entier retour aura la valeur 0  par défaut, 1 si le joueur a gagné et -1 si le score passe en négatif
		
		switch(retour) {
			case 0://joueur gagne
				System.out.println("Control - void finirTour() - switch(" + retour + ")");

				//On affiche le score du joueur actuel dans son panneau de score north
				panScores_north.setScorePanScores(joueurs[joueurActuel]);
				panScores_north.repaint();
				
				//Message de félicitations
				pan_center.setMessage("Bravo " + joueurs[joueurActuel].getPrenom() + " vous avez gagné !");
				pan_center.setMessage2("");
				pan_center.repaint();
				
				//PanneauScore du joueur actuel et gagnant en vert.
		    	panScores_north.updateBackgroundColorsWinner(joueurActuel);
				
			    Runnable restartAction = () -> {
			        // Logique pour commencer une nouvelle partie
			        cadre.dispose();
			    	this.restartLogic(); // Ou this::restartApplication si JAR

			    };
		    	
			    Runnable arreterAction = () -> {
			        // Logique pour fermer le jeu
			    	System.exit(0);
			    };
		    	
				panCommands.updateButtons("Rejouer", restartAction, "Arreter le jeu", arreterAction);
				
				break;
			case 1://Joueur arrete et prend les poins
				System.out.println("Control - void finirTour() - switch(" + retour + ")");

				//ré initialiser le tableau desInterdits seulement si nous sommes dans le dernier lancer du tour
				for(int i = 0; i<= 4; i++) {
					desInterdits[i] = 0;
				}

				//On affiche le score du joueur actuel dans son panneau de score north
				panScores_north.setScorePanScores(joueurs[joueurActuel]);
				panScores_north.repaint();
				
				//on passe au joueur suivant
				this.setJoueurActuel();

				pointsCumules = 0;
				pointsLancer = 0;
				finTour = true;
				
				//message pour le joueur suivant
				pan_center.setMessage("à toi de lancer les dés " + joueurs[joueurActuel].getPrenom());
				pan_center.setMessage2("");
				pan_center.repaint();
				
				break;
			case -1://Score négatif
				System.out.println("Control - void finirTour() - switch(" + retour + ")");

				pointsCumules = 0;
				pointsLancer = 0;
				finTour = true;
				
				
				panCommands.enableBoutons(false);
				
				//Message de félicitations
				pan_center.setMessage("Votre lancer est supérieur à votre score.");
				pan_center.setMessage2("");
				pan_center.repaint();
				

				attendre(2000, () -> {
					//Message de félicitations
					pan_center.setMessage("Passez votre tour");
					pan_center.repaint();

					finTour = true;

					//ré initialiser le tableau desInterdits seulement si nous sommes dans le dernier lancer du tour
					for(int i = 0; i<= 4; i++) {
						desInterdits[i] = 0;
					}
					
			        attendre(2000, () -> {
			            // Message pour le joueur suivant sans changer immédiatement de joueur
			            int joueurSuivant = (joueurActuel + 1) % joueurs.length;
			            pan_center.setMessage("à toi de lancer les dés " + joueurs[joueurSuivant].getPrenom());
			            pan_center.repaint();

			            // On passe au joueur suivant après l'affichage du message
			            attendre(500, this::setJoueurActuel);
			            
			            panCommands.enableBoutons(true);
			        });
				});
				
				break;
		}
	}

	//Méthode pour paramétrer les ActionPerformed des boutons
	public void updatePanCommands(String lancerText, Runnable lancerAction, String arreterText, Runnable arreterAction) {
	    panCommands.updateButtons(lancerText, lancerAction, arreterText, arreterAction);
	}
	
	public void restartLogic() {
	    // Réinitialiser tous les objets nécessaires
	    // Exemple : recréer l'interface graphique
	    this.main(null); // Si votre méthode `main` est accessible et initie le programme
	}

	
	// Méthode pour démarrer un délai
	private void attendre(int milliseconds, Runnable action) {
		System.out.println("Control - void attendre(int milliseconds, Runnable action)");
	    Timer timer = new Timer(milliseconds, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Code à exécuter après le délai
	            action.run();
	            // Arrête le Timer après exécution si c'est un délai unique
	            ((Timer) e.getSource()).stop();
	        }
	    });
	    timer.setRepeats(false); // Exécuter une seule fois
	    timer.start();           // Démarrer le timer
	}

	private int verificationDes(int[] lancers) {
		System.out.println("Control - int verificationDes(int[] lancers)");

		//Il ne faut vérifier que les dés qui ont été grisés ou la totalité des dés du premier lancer
		pointsLancer = 0;
		
		// Création d'une Map pour stocker les variables dynamiques
        nbres = new HashMap<>();
		
        nbres.put("nbre1", 0);
        nbres.put("nbre2", 0);
        nbres.put("nbre3", 0);
        nbres.put("nbre4", 0);
        nbres.put("nbre5", 0);
        nbres.put("nbre6", 0);
		
		for(int i = 0; i < 5; i++) {
			int chiffre = lancers[i];
			
			//vérification des valeurs des dés pour préparer la vérification du score
			if(premierLancer == true || desInterdits[1] == 0) {
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
			}//end if(premierLancer == true || desInterdits[1] == 0)
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
		
		//TODO voir les points suivants jusqu'au prochain TODO
		
		// si tous les dés sont interdits, on passe au joueur suivant
		if(Arrays.stream(desInterdits).anyMatch(x -> x == 0)) {	
			//je passe au joueur suivant sans calcul de score car score = 0
			//Ce sera le premier lancer du joueur suivant
			this.setJoueurActuel();
			premierLancer = true;
		} else if(Arrays.stream(desInterdits).anyMatch(x -> x != 0)){

			//si tous les dés font un score :
			
			// -> ils pourront être relancés par le joueur actuel
			// -> ce sera compté comme un premier lancer pour le joueur actuel
			premierLancer = true;
			
			//si ce n'est pas une suite, ils pourront être relancés et ce sera compté comme un premier lancer
			/*
			 * Conditions :
			 * 
			 * -Aucun dés interdits
			 * -j'ai des 1, des 5 ou des triples 2, 3, 4 ou 6
			 * 
			 */
			if((nbres.get("nbre2") >= 3 || nbres.get("nbre3") >= 3 || nbres.get("nbre4") >= 3 || nbres.get("nbre6") >= 3 
					|| nbres.get("nbre1") >= 1 || nbres.get("nbre5") >= 1)) {
				//je dois calculer le score
				
				//ré initialiser le tableau desInterdits
				for(int i = 0; i<= 4; i++) {
					desInterdits[i] = 0;
				}
			}
			
			//si j'ai une suite, on connait le score
			//Vérification d'une suite 
			if(((nbres.get("nbre1") == 1 && nbres.get("nbre2") == 1 && nbres.get("nbre3") == 1 && nbres.get("nbre4") == 1 && nbres.get("nbre5") == 1)
				|| (nbres.get("nbre2") == 1 && nbres.get("nbre3") == 1 && nbres.get("nbre4") == 1 && nbres.get("nbre5") == 1 && nbres.get("nbre6") == 1))){
				
				pointsLancer = pointsLancer + 500;
				
				//ré initialiser le tableau desInterdits
				for(int i = 0; i<= 4; i++) {
					desInterdits[i] = 0;
				}
			}
		}		
		//TODO voir les lignes d'avant jusqu'au TODO
			
		return calculPoints(lancers);
	}//	fin de verificationDes(int[] lancers)
	
	private int calculPoints(int[] lancers) {

		if(nbres.get("nbre1") != 0){
			switch(nbres.get("nbre1")){
				case 1:
					pointsLancer = pointsLancer + 100;
						//nbreDesRestants = nbreDesRestants - 1;
					break;
				case 2:
					pointsLancer = pointsLancer + 200;
//					nbreDesRestants = nbreDesRestants - 2;
					break;
				case 3:
					pointsLancer = pointsLancer + 1000;
//					nbreDesRestants = nbreDesRestants - 3;
					break;
				case 4:
					pointsLancer = pointsLancer + 2000;
//					nbreDesRestants = nbreDesRestants - 4;
					break;
				case 5:
					pointsLancer = pointsLancer + 3000;
//					nbreDesRestants = nbreDesRestants - 5;
					break;
			}	//fin switch nbre1
		}	//fin if nbre1
		
		if(nbres.get("nbre2") == 3 || nbres.get("nbre2") == 4 || nbres.get("nbre2") == 5){
			switch(nbres.get("nbre2")){
				case 3:
					pointsLancer = pointsLancer + 200;
//					nbreDesRestants = nbreDesRestants - 3;
					break;
				case 4:
					pointsLancer = pointsLancer + 400;
//					nbreDesRestants = nbreDesRestants - 4;
					break;
				case 5:
					pointsLancer = pointsLancer + 600;
//					nbreDesRestants = nbreDesRestants - 5;
					break;
			}	//fin switch nbre2
		}	//fin du if nbre2
		
		if(nbres.get("nbre3") > 2){
			switch(nbres.get("nbre3")){
				case 3:
					pointsLancer = pointsLancer + 300;
//					nbreDesRestants = nbreDesRestants - 3;
					break;
				case 4:
					pointsLancer = pointsLancer + 600;
//					nbreDesRestants = nbreDesRestants - 4;
					break;
				case 5:
					pointsLancer = pointsLancer + 900;
//					nbreDesRestants = nbreDesRestants - 5;
					break;
			}	//fin switch nbre3
		}	//fin if nbre3
		
		if(nbres.get("nbre4") > 2){
			switch(nbres.get("nbre4")){
				case 3:
					pointsLancer = pointsLancer + 400;
//					nbreDesRestants = nbreDesRestants - 3;
					break;
				case 4:
					pointsLancer = pointsLancer + 800;
//					nbreDesRestants = nbreDesRestants - 4;
					break;
				case 5:
					pointsLancer = pointsLancer + 1200;
//					nbreDesRestants = nbreDesRestants - 5;
					break;
			}	//fin switch nbre4
		}	//fin if nbre4
		
		if(nbres.get("nbre5") != 0){
			switch(nbres.get("nbre5")){
				case 1:
					pointsLancer = pointsLancer + 50;
//					nbreDesRestants = nbreDesRestants - 1;
					break;
				case 2:
					pointsLancer = pointsLancer + 100;
//					nbreDesRestants = nbreDesRestants - 2;
					break;
				case 3:
					pointsLancer = pointsLancer + 500;
//					nbreDesRestants = nbreDesRestants - 3;
					break;
				case 4:
					pointsLancer = pointsLancer + 1000;
//					nbreDesRestants = nbreDesRestants - 4;
					break;
				case 5:
					pointsLancer = pointsLancer + 1500;
//					nbreDesRestants = nbreDesRestants - 5;
					break;
			}	//fin switch nbre5
		}	//fin if nbre5
		
		if(nbres.get("nbre6") > 2){
			switch(nbres.get("nbre6")){
				case 3:
					pointsLancer = pointsLancer + 600;
//					nbreDesRestants = nbreDesRestants - 3;
					break;
				case 4:
					pointsLancer = pointsLancer + 1200;
//					nbreDesRestants = nbreDesRestants - 4;
					break;
				case 5:
					pointsLancer = pointsLancer + 1800;
//					nbreDesRestants = nbreDesRestants - 5;
					break;
			}	//fin switch nbre6
		}	//fin if nbre6		

		//Lorsque nous avons fini de compter les points, on sait que le premier lancer du joueur est terminé et qu'il va passer au lancer suivant
		premierLancer = false;
	
		return pointsLancer;
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

	public void setJoueurActuel() {
		System.out.println("Control - void setJoueurActuel()");
		//lorsqu'on passe au joueur suivant, le joueur suivant fait son premier lancer de son tour !
		premierLancer = true;
		
		//si le joueur actuel est le dernier, il faut alors réinitialiser pour revenir au premier joueur
		//sinon, on incrémente
		if(this.joueurActuel == joueurs.length - 1) {
			joueurActuel = 0;
		    if (panScores_north != null) {
		    	panScores_north.updateBackgroundColors(joueurActuel);
		    }
		}else {
			joueurActuel++;
		    if (panScores_north != null) {
		    	panScores_north.updateBackgroundColors(joueurActuel);
		    }
		}
//		this.joueurActuel = joueurActuel;
	}

	public int getJoueurActuel() {
		return joueurActuel;
	}
}
