package vues.panneaux;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanCommands_south extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanCommands_south(int xPanSize, int yPanSize) {
		this.setLayout(new FlowLayout(1, xPanSize / 8, 0));	//FlowLayout​(int align, int hgap, int vgap)

		this.setPreferredSize(new Dimension(xPanSize, yPanSize));
		
		//calculs des tailles pour les boutons
		int heightBout = (int) Math.round(yPanSize * 0.8);
		int widhtBout = (int) Math.round(xPanSize * 0.45);
		
		//calcul des tailles de fonts
		int sizeFont = (int) Math.round(xPanSize * 0.02);
		
		//Load font from file
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/Eracake.ttf"));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		 
		JPanel panLancer = new JPanel();
		JPanel panArret = new JPanel();
		
		panLancer.setPreferredSize(new Dimension(xPanSize / 3, yPanSize));
		panArret.setPreferredSize(new Dimension(xPanSize / 3, yPanSize));
		
		JButton boutLancer = new JButton("Lancer les des"); 
		JButton boutArreter = new JButton("Arreter le tour");
		
		boutLancer.setPreferredSize(new Dimension(widhtBout, heightBout));
		boutArreter.setPreferredSize(new Dimension(widhtBout, heightBout));
		
		boutArreter.setFont(new Font("Eracake", Font.ITALIC, sizeFont));
		boutLancer.setFont(new Font("Eracake", Font.ITALIC, sizeFont));
		
		
		panLancer.add(boutLancer);
		panArret.add(boutArreter);
		
		this.add(panLancer);
		this.add(panArret);
	}
}
