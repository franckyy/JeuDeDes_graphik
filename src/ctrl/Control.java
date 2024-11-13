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
    private Dice dice;  // Instance de la classe Dice pour gérer les lancers
    private int[] desInterdits = new int[5];	// tableau pour les dés qui ne devront pas être relancés
    private int score = 0;
    
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

		this.messBienvenue(joueurs[joueurActuel]);
	}

	//*********METHODES***********
	private void messBienvenue(Joueur joueur) {
		System.out.println("Control - void messBienvenue(Joueur joueur)");
		
	    attendre(2000, () -> {
	        pan_center.setMessage("Bienvenue dans notre jeu de dés");
	        pan_center.repaint();
	        
	        attendre(2000, () -> {
	            pan_center.setMessage("à toi de lancer les dés " + joueur.getPrenom());
	            pan_center.repaint();
	            
	            panCommands.enableBoutons(true);
	        });
	    });
	}

	public void lancerDes() {
		System.out.println("Control - void lancerDes()");
		
		dice.lancerDes();  // Lancer les dés
                
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
		
		score = this.verificationDes(dice.getValeursDes());
		
		//affichage du score sur le panneauEast
		panScoreEast.setScore(score);
		panScoreEast.repaint();
		
		//TODO Le joueur souhaite-t'il relancer les dés ?
		//si oui, il va falloir ajouter le score actuel avec le score du prochain lancer
			//S'il ne réalise pas de score au prochain lancer, le joueur perd tout son score
		//si non, on ajoute le score actuel au score du joueur
		
		
	}//	fin lancerDes()

	private int verificationDes(int[] lancers) {
		System.out.println("Control - int verificationDes(int[] lancers)");
		
		//évaluation du score
		int _score = 0;
		
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
				
				_score = _score + 500;
			
			//Vérification des autres possibilités
			}else{
				if(nbres.get("nbre1") != 0){
					switch(nbres.get("nbre1")){
						case 1:
							_score = _score + 100;
								//nbreDesRestants = nbreDesRestants - 1;
							break;
						case 2:
							_score = _score + 200;
	//						nbreDesRestants = nbreDesRestants - 2;
							break;
						case 3:
							_score = _score + 1000;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							_score = _score + 2000;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							_score = _score + 3000;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre1
				}	//fin if nbre1
				
				if(nbres.get("nbre2") == 3 || nbres.get("nbre2") == 4 || nbres.get("nbre2") == 5){
					switch(nbres.get("nbre2")){
						case 3:
							_score = _score + 200;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							_score = _score + 400;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							_score = _score + 600;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre2
				}	//fin du if nbre2
				
				if(nbres.get("nbre3") > 2){
					switch(nbres.get("nbre3")){
						case 3:
							_score = _score + 300;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							_score = _score + 600;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							_score = _score + 900;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre3
				}	//fin if nbre3
				
				if(nbres.get("nbre4") > 2){
					switch(nbres.get("nbre4")){
						case 3:
							_score = _score + 400;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							_score = _score + 800;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							_score = _score + 1200;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre4
				}	//fin if nbre4
				
				if(nbres.get("nbre5") != 0){
					switch(nbres.get("nbre5")){
						case 1:
							_score = _score + 50;
	//						nbreDesRestants = nbreDesRestants - 1;
							break;
						case 2:
							_score = _score + 100;
	//						nbreDesRestants = nbreDesRestants - 2;
							break;
						case 3:
							_score = _score + 500;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							_score = _score + 1000;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							_score = _score + 1500;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre5
				}	//fin if nbre5
				
				if(nbres.get("nbre6") > 2){
					switch(nbres.get("nbre6")){
						case 3:
							_score = _score + 600;
	//						nbreDesRestants = nbreDesRestants - 3;
							break;
						case 4:
							_score = _score + 1200;
	//						nbreDesRestants = nbreDesRestants - 4;
							break;
						case 5:
							_score = _score + 1800;
	//						nbreDesRestants = nbreDesRestants - 5;
							break;
					}	//fin switch nbre6
				}	//fin if nbre6		
			}//	fin du else
		}

		return _score;
	}//	fin de verificationDes(int[] lancers)
	
	public void finirTour() {
		System.out.println("Control - void finirTour()");
		
		//Lorsque le joueur arrete son tour, il faut ajouter le score actuel au score du joueur et l'afficher dans panneau north
		//Il est alors demandé au joueur suivant de jouer
		
		//On met le score du joueur actuel à jour
		joueurs[joueurActuel].setNbrePts(score);

		System.out.println("Control - void finirTour()_suite");
		
		//On affiche le score du joueur actuel dans son panneau de score north
		panScores_north.setScorePanScores(joueurs[joueurActuel]);
		panScores_north.repaint();
		
		//on passe au joueur suivant
		this.setJoueurActuel();
		
		//message pour le joueur suivant
		pan_center.setMessage("à toi de lancer les dés " + joueurs[joueurActuel].getPrenom());
		pan_center.repaint();
	}

	public void gagne() {
		System.out.println("Control - void gagne()");
		//On affiche le score du joueur actuel dans son panneau de score north
		panScores_north.setScorePanScores(joueurs[joueurActuel]);
		panScores_north.repaint();
		
		//Message de félicitations
		pan_center.setMessage("Bravo " + joueurs[joueurActuel].getPrenom() + " vous avez gagné !");
		pan_center.repaint();
		
		//TODO fin du jeu -> recommencer ? 
	}
	
	public void scoreNegatif() {
		System.out.println("Control - void scoreNegatif()");
		

		//Message de félicitations
		pan_center.setMessage("Votre lancer est supérieur à votre score. Passez votre tour");
		pan_center.repaint();
		
		 attendre(2000, () -> {
				//Message de félicitations
				pan_center.setMessage("Votre lancer est supérieur à votre score. Passez votre tour");
				pan_center.repaint();
		 });
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
		//si le joueur actuel est le dernier, il faut alors réinitialiser pour revenir au premier joueur
		//sinon, on incrémente
		if(this.joueurActuel == joueurs.length - 1) {
			joueurActuel = 0;
		}else {
			joueurActuel++;
		}
//		this.joueurActuel = joueurActuel;
	}
}
