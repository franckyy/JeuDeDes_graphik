package vues.panneaux.center;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DessinDe extends JPanel {
    private int valeurDe;

    // Constructeur pour initialiser la valeur du dé (1 à 6)
    public DessinDe(int valeurDe) {
        this.valeurDe = valeurDe;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dessiner le contour du dé avec des angles arrondis
        g.setColor(Color.BLACK);
        g.drawRoundRect(50, 50, 100, 100, 20, 20); // Position (50, 50), taille 100x100, angles arrondis (20, 20)

        // Placer les points du dé selon sa valeur
        g.setColor(Color.BLACK);
        dessinerPoints(g, valeurDe);
    }

    private void dessinerPoints(Graphics g, int valeur) {
        int x = 50; // Coordonnées de départ
        int y = 50;
        int tailleCase = 100; // Taille de la case

        int r = 20; // Taille du point
        int demiCase = tailleCase / 2;

        // Position des points (coordonnées relatives au coin supérieur gauche)
        int[][] positions = {
            {x + demiCase, y + demiCase}, // centre (pour 1, 3, 5)
            {x + tailleCase / 4, y + tailleCase / 4}, // coin haut gauche (pour 2, 4, 5, 6)
            {x + 3 * tailleCase / 4, y + tailleCase / 4}, // coin haut droit (pour 2, 4, 5, 6)
            {x + tailleCase / 4, y + 3 * tailleCase / 4}, // coin bas gauche (pour 4, 5, 6)
            {x + 3 * tailleCase / 4, y + 3 * tailleCase / 4}, // coin bas droit (pour 4, 5, 6)
            {x + demiCase, y + tailleCase / 4}, // milieu haut (pour 6)
            {x + demiCase, y + 3 * tailleCase / 4} // milieu bas (pour 6)
        };

        // Dessin des points en fonction de la valeur
        switch (valeur) {
            case 1:
                g.fillOval(positions[0][0] - r / 2, positions[0][1] - r / 2, r, r);
                break;
            case 2:
                g.fillOval(positions[1][0] - r / 2, positions[1][1] - r / 2, r, r);
                g.fillOval(positions[2][0] - r / 2, positions[2][1] - r / 2, r, r);
                break;
            case 3:
                g.fillOval(positions[0][0] - r / 2, positions[0][1] - r / 2, r, r);
                g.fillOval(positions[1][0] - r / 2, positions[1][1] - r / 2, r, r);
                g.fillOval(positions[4][0] - r / 2, positions[4][1] - r / 2, r, r);
                break;
            case 4:
                g.fillOval(positions[1][0] - r / 2, positions[1][1] - r / 2, r, r);
                g.fillOval(positions[2][0] - r / 2, positions[2][1] - r / 2, r, r);
                g.fillOval(positions[3][0] - r / 2, positions[3][1] - r / 2, r, r);
                g.fillOval(positions[4][0] - r / 2, positions[4][1] - r / 2, r, r);
                break;
            case 5:
                g.fillOval(positions[0][0] - r / 2, positions[0][1] - r / 2, r, r);
                g.fillOval(positions[1][0] - r / 2, positions[1][1] - r / 2, r, r);
                g.fillOval(positions[2][0] - r / 2, positions[2][1] - r / 2, r, r);
                g.fillOval(positions[3][0] - r / 2, positions[3][1] - r / 2, r, r);
                g.fillOval(positions[4][0] - r / 2, positions[4][1] - r / 2, r, r);
                break;
            case 6:
                g.fillOval(positions[1][0] - r / 2, positions[1][1] - r / 2, r, r);
                g.fillOval(positions[2][0] - r / 2, positions[2][1] - r / 2, r, r);
                g.fillOval(positions[3][0] - r / 2, positions[3][1] - r / 2, r, r);
                g.fillOval(positions[4][0] - r / 2, positions[4][1] - r / 2, r, r);
                g.fillOval(positions[5][0] - r / 2, positions[5][1] - r / 2, r, r);
                g.fillOval(positions[6][0] - r / 2, positions[6][1] - r / 2, r, r);
                break;
        }
    }
}
