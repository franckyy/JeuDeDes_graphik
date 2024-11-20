package modeles;

import java.util.Random;

public class Dice {
    private static final int MAX_FACE = 6;  // Nombre de faces d'un dé classique
    private int[] valeursDes;

    public Dice(int nombreDeDes) {
        valeursDes = new int[nombreDeDes];
    }

    public void lancerDes(int[] desInterdits, boolean premierLancer) {
        Random rand = new Random();
        
        if(premierLancer == true) {
            for (int i = 0; i < valeursDes.length; i++) {
                valeursDes[i] = rand.nextInt(MAX_FACE) + 1;  // Lancer un dé entre 1 et 6
            }
        } else {
            for(int i = 0; i < desInterdits.length; i++) {// permet de ne lancer que les dés qui doivent être lancés
            	if(desInterdits[i] == -1) {
            		valeursDes[i] = rand.nextInt(MAX_FACE) + 1;  // Lancer un dé entre 1 et 6
            	}
            }	
        }
    }

    public int[] getValeursDes() {
        return valeursDes;
    }
}