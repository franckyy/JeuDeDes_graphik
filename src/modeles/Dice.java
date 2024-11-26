package modeles;

import java.util.Random;

import ctrl.Control;

public class Dice {
    private static final int MAX_FACE = 6;  // Nombre de faces d'un dé classique
    private int[] valeursDes;

	Control ctrl = null;

    public Dice(int nombreDeDes, Control ctrl_) {
        valeursDes = new int[nombreDeDes];
        this.ctrl = ctrl_;
    }

    public void lancerDes(boolean premierLancer) {
        Random rand = new Random();
        
        
        
        if(premierLancer == true) {
            for (int i = 0; i < valeursDes.length; i++) {
                valeursDes[i] = rand.nextInt(MAX_FACE) + 1;  // Lancer un dé entre 1 et 6
            }
        } else {
            for(int i = 0; i < ctrl.getDesInterdits().length; i++) {// permet de ne lancer que les dés qui doivent être lancés
            	//ici, il faut dégriser les dés -1 et peut-être passer les dés 0 en status 1
            	//qui prendraient une autre couleur signifiant qu'ils ont déjà participé au score
            	if(ctrl.getDesInterdits()[i] == -1) {
            		valeursDes[i] = rand.nextInt(MAX_FACE) + 1;  // Lancer un dé entre 1 et 6
            		ctrl.setDesInterdits(i, 0);
            	} else if(ctrl.getDesInterdits()[i] == 0) {
            		ctrl.setDesInterdits(i, 1);
            	}
            }	
        }
    }

    public int[] getValeursDes() {
        return valeursDes;
    }
}