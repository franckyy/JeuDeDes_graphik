package utils;

import java.awt.Color;

/*
 * 
 * Voici une palette harmonieuse autour d'un violet sobre, chaleureux et non agressif :

    Violet principal : (128, 90, 178)
        Un violet doux mais profond qui peut être la couleur principale de ton interface, donnant un ton accueillant.

    Lavande clair : (204, 192, 229)
        Idéal pour les arrière-plans ou les zones secondaires, ajoutant une douceur sans dominer l'espace.

    Gris chaud : (85, 85, 85)
        Un gris aux tons neutres qui peut équilibrer la palette en étant moins froid et plus chaleureux pour les textes ou les éléments discrets.

    Rose poudré : (219, 170, 194)
        Une couleur d'accent qui ajoute de la chaleur à l'ensemble sans être trop vive. Parfaite pour attirer l’attention sur certains éléments sans agresser visuellement.

Ces couleurs créent un ensemble harmonieux et agréable pour un jeu, en apportant à la fois chaleur et subtilité.

********************************
*
*Les zones secondaires sont des éléments visuels qui ne demandent pas une attention immédiate mais restent importants pour l’expérience de jeu. Pour ton interface, cela pourrait inclure :

    Zone d'affichage des scores : Un fond en lavande clair rendrait cette zone bien visible tout en restant douce.
    Panneaux d'information ou aides : Les textes d'instructions, des messages ou des conseils peuvent être sur fond lavande pour les démarquer sans trop attirer l’attention.
    Éléments de navigation secondaires : Si ton interface a des onglets, des options ou des boutons qui ne sont pas les actions principales, ils peuvent aussi utiliser cette couleur.

Utiliser une couleur secondaire, comme le lavande clair, permet de créer une hiérarchie visuelle sans surcharger l'interface.
 */

public class PaletteColors {
    public static final Color VIOLET = new Color(144, 80, 194); // violet neutre
    public static final Color VIOLET_DARK = new Color(97, 20, 157); // violet plus foncé
    public static final Color VIOLET_LIGHT = new Color(206, 168, 235); // violet clair
    public static final Color MYSTIC_PURPLE = new Color(153, 50, 204); // Violet mystique
    public static final Color POWDER_PINK = new Color(179, 11, 124); // rose poudré
    public static final Color HOT_GREY = new Color(85, 85, 85); // gris chaud
    public static final Color BACKGROUND_SECOND = VIOLET_LIGHT;
    public static final Color BACKGROUND_DES = VIOLET;
    public static final Color BACKGROUND_JOUEURS = VIOLET_DARK;    
    
    public static final Color BACKGROUND = new Color(245, 245, 245); // couleur de fond neutre

    public static final Color BUTTON_COLOR = new Color(200, 100, 255); // couleur pour les boutons
}