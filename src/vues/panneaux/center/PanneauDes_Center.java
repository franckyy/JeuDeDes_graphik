package vues.panneaux.center;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ctrl.Control;

public class PanneauDes_Center extends JPanel {

    private static final long serialVersionUID = 1L;
    Control ctrl = null;

    // Tableau pour stocker les valeurs des dés
    private int[] valeursDes = {1, 2, 3, 4, 5};  // Valeurs initiales
    private Color[] couleursDes = {Color.white, Color.white, Color.white, Color.white, Color.white};  // Couleurs initiales des dés

    //*********CONSTRUCTEUR*********
    public PanneauDes_Center(Control ctrl_) {
    	System.out.println("PanneauDes_Center(Control ctrl_)");
        this.ctrl = ctrl_;
        ctrl.setPanDes(this);
        this.setBackground(Color.pink);
    }

    //*********METHODES*********

    @Override
    public Dimension getPreferredSize() {
        // Définir la taille du panneau bas à deux tiers de la hauteur du PanneauCentre
        Dimension dim = super.getPreferredSize();
        dim.height = getParent().getHeight() * 2 / 3;  // Deux tiers de la hauteur du PanneauCentre
        dim.width = 600;  // Largeur fixe pour les dés
        return dim;
    }

    // Méthode pour mettre à jour les valeurs des dés
    public void setValeursDes(int[] valeurs) {
    	System.out.println("PanneauDes_Center - void setValeursDes(int[] valeurs)");
        if (valeurs != null && valeurs.length == 5) {
            this.valeursDes = valeurs;
            repaint();  // Redessiner le panneau avec les nouvelles valeurs
        }
    }

    // Méthode pour griser les dés spécifiés
    public void griserDes(int[] griserDes) {
    	System.out.println("PanneauDes_Center - void griserDes(int[] griserDes)");
        for (int i = 0; i < griserDes.length; i++) {
            if (griserDes[i] == -1) {
                couleursDes[i] = Color.gray;  // Changer la couleur du dé en gris
            }
            else {
                couleursDes[i] = Color.white;  // Changer la couleur du dé en gris
            }
        }

        // Utiliser invokeLater pour garantir le redessin sur le thread d'interface graphique
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                repaint();
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
    	System.out.println("PanneauDes_Center - void paint(Graphics g)");
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        // Améliorer la qualité du rendu graphique
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Déterminer les dimensions des dés en pourcentage de la taille du panneau
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Taille des dés : 10% de la largeur et 20% de la hauteur du panneau
        int tailleDe = Math.min(panelWidth, panelHeight) / 3;  // Taille des dés basée sur la taille du panneau
        int espacement = tailleDe / 2;  // Espacement entre les dés (moitié de la taille d'un dé)

        // Coordonnées de départ pour le premier dé
        int xStart = (panelWidth - (tailleDe * 5 + espacement * 4)) / 2;  // Centrer horizontalement
        int yStart = panelHeight / 2 - tailleDe / 2; // Centrer verticalement

        // Dessiner les 5 dés
        for (int i = 0; i < 5; i++) {
            // Calculer la position de chaque dé
            int x = xStart + i * (tailleDe + espacement);

            // Dessiner le dé (rectangle avec coins arrondis)
            g2d.setColor(couleursDes[i]);
            g2d.fillRoundRect(x, yStart, tailleDe, tailleDe, 15, 15); // coins arrondis

            // Dessiner le contour du dé
            g2d.setColor(Color.black);
            g2d.drawRoundRect(x, yStart, tailleDe, tailleDe, 15, 15);

            // Dessiner les points sur le dé en fonction de la valeur
            dessinerPoints(g2d, valeursDes[i], x, yStart, tailleDe);
        }
    }

    // Méthode pour dessiner les points sur un dé
    private void dessinerPoints(Graphics2D g2d, int valeur, int x, int y, int taille) {
        int pointSize = taille / 8;  // Taille des points (10% de la taille du dé)

        switch (valeur) {
            case 1:
                g2d.fillOval(x + taille / 2 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize);
                break;
            case 2:
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / pointSize, pointSize, pointSize);
                break;
            case 3:
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + taille / 2 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                break;
            case 4:
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                break;
            case 5:
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + taille / 2 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize);
                break;
            case 6:
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize); // Haut gauche
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize); // Haut droite
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize); // Bas gauche
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize); // Bas droite
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize); // Milieu gauche
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize); // Milieu droite
                break;
        }
    }
}
