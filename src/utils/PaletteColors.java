package utils;

import java.awt.Color;

/*
Principal color RGB: 225–136–234   RGB: 208–89–220   RGB: 192–53–207   RGB: 177–19–194   RGB: 143–2–158

Secondary color #1   RGB: 248–143–180   RGB: 242–96–148   RGB: 238–58–122   RGB: 233–20–95   RGB: 211–0–75

Secondary color #2   RGB: 197–249–143   RGB: 172–245–97   RGB: 151–241–59   RGB: 130–237–20   RGB: 110–217–0

Complement color   RGB: 238–253–146   RGB: 231–252–100   RGB: 225–251–62   RGB: 218–250–21   RGB: 202–235–0

********************************
Les zones secondaires sont des éléments visuels qui ne demandent pas une attention immédiate mais restent importants pour l’expérience de jeu.
Pour ton interface, cela pourrait inclure :
	Zone d'affichage des scores, Panneaux d'information ou aides : Les textes d'instructions, des messages ou des conseils
	Éléments de navigation secondaires : Si ton interface a des onglets, des options ou des boutons qui ne sont pas les actions principales.
Utiliser une couleur secondaire permet de créer une hiérarchie visuelle sans surcharger l'interface.
 */

public class PaletteColors {
    public static final Color HOT_GREY = new Color(85, 85, 85);
    
    public static final Color VIOLET_1_CLAIR = new Color(225, 136, 234);
    public static final Color VIOLET_2 = new Color(208, 89, 220);
    public static final Color VIOLET_3 = new Color(192, 53, 207);
    public static final Color VIOLET_4 = new Color(177, 19, 194);
    public static final Color VIOLET_5_FONCE = new Color(143, 2, 158);

    public static final Color SECOND_ROSE_1_CLAIR = new Color(248, 143, 180);
    public static final Color SECOND_ROSE_2 = new Color(242, 96, 148);
    public static final Color SECOND_ROSE_3 = new Color(238, 58, 122);
    public static final Color SECOND_ROSE_4 = new Color(233, 20, 95);
    public static final Color SECOND_ROSE_5_FONCE = new Color(211, 0, 75);


    public static final Color SECOND_VERT_1_CLAIR = new Color(197, 249, 143);
    public static final Color SECOND_VERT_2 = new Color(172, 245, 97);
    public static final Color SECOND_VERT_3 = new Color(151, 241, 59);
    public static final Color SECOND_VERT_4 = new Color(130, 237, 20);
    public static final Color SECOND_VERT_5_FONCE = new Color(110, 217, 0);

    public static final Color COMPL_JAUNE_1_CLAIR = new Color(238, 253, 146);
    public static final Color COMPL_JAUNE_2 = new Color(231, 252, 100);
    public static final Color COMPL_JAUNE_3 = new Color(225, 251, 62);
    public static final Color COMPL_JAUNE_4 = new Color(218, 250, 21);
    public static final Color COMPL_JAUNE_5_FONCE = new Color(202, 235, 0);
    
    public static final Color BACKGROUND_SECOND = VIOLET_1_CLAIR;
    public static final Color BACKGROUND_DES = VIOLET_3;
    public static final Color BACKGROUND_JOUEURS = VIOLET_5_FONCE;    
    
    public static final Color BACKGROUND = new Color(245, 245, 245);
    public static final Color BUTTON_PRINC = SECOND_ROSE_1_CLAIR;
}