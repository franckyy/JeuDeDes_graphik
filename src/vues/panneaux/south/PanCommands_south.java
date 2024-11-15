package vues.panneaux.south;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import ctrl.Control;
import utils.PaletteColors;

public class PanCommands_south extends JPanel {

	private static final long serialVersionUID = 1L;
	
    // Déclaration de la police statique
    private static Font font;

	final double BUTTON_HEIGHT_RATIO = 0.8;
	final double BUTTON_WIDTH_RATIO = 0.45;
	final double FONT_SIZE_RATIO = 0.02;
	
	final Color coulBackPanel = PaletteColors.BACKGROUND_SECOND;
	
	Control ctrl = null;
	JButton boutLancer = null; 
	JButton boutArreter = null;

    // Bloc static pour charger la police une seule fois
    static {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, PanCommands_south.class.getResourceAsStream("/font/Eracake.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
	
	public PanCommands_south(int xPanSize, int yPanSize, Control ctrl_) {
		System.out.println("PanCommands_south(int xPanSize, int yPanSize, Control ctrl_)");
		this.ctrl = ctrl_;
		ctrl.setPanCommands(this);
		
		this.setLayout(new FlowLayout(1, xPanSize / 8, 0));	//FlowLayout​(int align, int hgap, int vgap)

		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		//Colorisation du background de PanCommands_south
		this.setBackground(coulBackPanel);
		
		//calculs des tailles pour les boutons
		int heightBout = (int) Math.round(yPanSize * BUTTON_HEIGHT_RATIO);
		int widhtBout = (int) Math.round(xPanSize * BUTTON_WIDTH_RATIO);
		
		//calcul des tailles de fonts
		int sizeFont = (int) Math.round(xPanSize * FONT_SIZE_RATIO);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		 
		JPanel panLancer = new JPanel();
		JPanel panArret = new JPanel();
		
		panLancer.setBackground(coulBackPanel);
		panArret.setBackground(coulBackPanel);
		
		panLancer.setPreferredSize(new Dimension(xPanSize / 3, yPanSize));
		panArret.setPreferredSize(new Dimension(xPanSize / 3, yPanSize));
		
		boutLancer = new JButton(); 
		boutArreter = new JButton();
		
		boutLancer.setPreferredSize(new Dimension(widhtBout, heightBout));
		boutArreter.setPreferredSize(new Dimension(widhtBout, heightBout));
		
		boutArreter.setFont(new Font("Eracake", Font.ITALIC, sizeFont));
		boutLancer.setFont(new Font("Eracake", Font.ITALIC, sizeFont));
		
		this.enableBoutons(false);
		
		panLancer.add(boutLancer);
		panArret.add(boutArreter);
		
		this.add(panLancer);
		this.add(panArret);
	}
	
	public void enableBoutons(boolean enabled) {
		System.out.println("PanCommands_south - void enableBoutons(boolean " + enabled + " )");
		boutArreter.setEnabled(enabled);
		boutLancer.setEnabled(enabled);
	}
	
	public void updateButtons(String textLancer, Runnable actionLancer, String textArreter, Runnable actionArreter) {
	    boutLancer.setText(textLancer);
	    for (var al : boutLancer.getActionListeners()) {
	        boutLancer.removeActionListener(al);
	    }
	    boutLancer.addActionListener(e -> actionLancer.run());

	    boutArreter.setText(textArreter);
	    for (var al : boutArreter.getActionListeners()) {
	        boutArreter.removeActionListener(al);
	    }
	    boutArreter.addActionListener(e -> actionArreter.run());
	}
}
