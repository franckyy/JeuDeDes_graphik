package vues.panneaux.center;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import ctrl.Control;
import utils.PaletteColors;

public class PanneauDes_Center extends JPanel {

    private static final long serialVersionUID = 1L;

    private final Color coulBackPanel = PaletteColors.BACKGROUND_DES;
    private Color frameColor = PaletteColors.SECOND_VERT_4; // Couleur par défaut du cadre

    private Control ctrl = null;
    private int[] valeursDes = {1, 2, 3, 4, 5};
    private Color[] couleursDes = {Color.white, Color.white, Color.white, Color.white, Color.white};

    public PanneauDes_Center(Control ctrl_) {
        this.ctrl = ctrl_;
        ctrl.setPanDes(this);
        this.setBackground(coulBackPanel);
    }

    // Méthode pour définir la couleur du cadre
    public void setFrameColor(Color color) {
        this.frameColor = color;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        dim.height = getParent().getHeight() * 2 / 3;
        dim.width = 600;
        return dim;
    }

    public void setValeursDes(int[] valeurs) {
        if (valeurs != null && valeurs.length == 5) {
            this.valeursDes = valeurs;
            repaint();
        }
    }

    public void griserDes(int[] griserDes) {
        for (int i = 0; i < griserDes.length; i++) {
            if (griserDes[i] == -1) {//dés sans valeur
                couleursDes[i] = Color.gray;
            } else if(griserDes[i] == 1){// dés ayant déjà participé au score
                couleursDes[i] = Color.red;
            } else {//le dés avec valeur
                couleursDes[i] = Color.white;
            }
        }
        SwingUtilities.invokeLater(this::repaint);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dessiner le cadre autour du panneau
        int frameThickness = 20;
        g2d.setColor(frameColor);
        g2d.setStroke(new BasicStroke(frameThickness));

        int inset = frameThickness / 2;
        g2d.drawRect(inset, inset, getWidth() - frameThickness, getHeight() - frameThickness);

        // Appeler la méthode pour dessiner les dés
        paintDice(g2d);
    }

    private void paintDice(Graphics2D g2d) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int tailleDe = Math.min(panelWidth, panelHeight) / 3;
        int espacement = tailleDe / 2;

        int xStart = (panelWidth - (tailleDe * 5 + espacement * 4)) / 2;
        int yStart = panelHeight / 2 - tailleDe / 2;

        for (int i = 0; i < 5; i++) {
            int x = xStart + i * (tailleDe + espacement);
            g2d.setColor(couleursDes[i]);
            g2d.fillRoundRect(x, yStart, tailleDe, tailleDe, 15, 15);

            // Dessiner les points ou le moulin à vent sur le dé
            if (valeursDes[i] == 0) {
                // Si la valeur est 0, dessiner le moulin à vent (étape 3)
                dessinerMoulin(g2d, x, yStart, tailleDe);
            } else {
                // Sinon, dessiner les points classiques
                dessinerPoints(g2d, valeursDes[i], x, yStart, tailleDe);
            }
        }
    }

    private void dessinerPoints(Graphics2D g2d, int valeur, int x, int y, int taille) {
        int pointSize = taille / 8;  // Taille des points

        g2d.setColor(Color.black); // Couleur des points
        switch (valeur) {
            case 1:
                g2d.fillOval(x + taille / 2 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize);
                break;
            case 2:
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
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
                g2d.fillOval(x + taille / 2 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                break;
            case 6:
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + 3 * taille / 4 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + taille / 4 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize);
                g2d.fillOval(x + 3 * taille / 4 - pointSize / 2, y + taille / 2 - pointSize / 2, pointSize, pointSize);
                break;
        }
    }

    // Méthode pour dessiner un moulin à vent dans un dé
    private void dessinerMoulin(Graphics2D g2d, int x, int y, int taille) {
        g2d.setColor(Color.BLACK);
        // Calcul des points de l'éolienne
        int centerX = x + taille / 2;
        int centerY = y + taille / 2;
        int rayon = taille / 4;

        // Dessiner les 4 branches du moulin à vent
        g2d.fillPolygon(new int[] {centerX, centerX - rayon, centerX, centerX + rayon},
                        new int[] {centerY - rayon, centerY, centerY + rayon, centerY},
                        4);
        // Optionnel: Dessiner un cercle central pour l'axe
        g2d.fillOval(centerX - 5, centerY - 5, 10, 10);
    }
}
