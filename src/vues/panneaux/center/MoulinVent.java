package vues.panneaux.center;

import java.awt.Color;
import java.awt.Graphics2D;

public class MoulinVent {
    public static void dessiner(Graphics2D g2d, int x, int y, int taille) {
        // Calculer la taille des éléments du moulin
        int centreX = x + taille / 2;
        int centreY = y + taille / 2;
        int rayon = taille / 3;

        // Couleurs pour les pales du moulin
        Color paleColor = Color.BLACK;
        
        // Dessiner les 4 pales du moulin
        g2d.setColor(paleColor);
        g2d.fillPolygon(new int[]{centreX, centreX - rayon, centreX + rayon}, 
                        new int[]{centreY - rayon, centreY, centreY}, 3); // Pales haut-gauche et bas-droit
        
        g2d.fillPolygon(new int[]{centreX, centreX - rayon, centreX + rayon}, 
                        new int[]{centreY + rayon, centreY, centreY}, 3); // Pales bas-gauche et haut-droit

        // Dessiner la barre du centre du moulin
        g2d.setColor(Color.BLACK);
        g2d.fillRect(centreX - 5, centreY - 5, 10, 10); // Centre du moulin
    }
}

