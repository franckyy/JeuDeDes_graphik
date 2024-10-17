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

	public PanCommands_south(int x, int y) {
		this.setLayout(new FlowLayout(1, x / 8, 0));	//FlowLayout​(int align, int hgap, int vgap)
		//transformation de y double en entier avec calcul de pourcentage
		int heightPan = (int) Math.round(y * 0.1);
		this.setPreferredSize(new Dimension(x, heightPan));
		
		//calculs des tailles pour les boutons
		int heightBout = (int) Math.round(heightPan * 0.8);
		int widhtBout = (int) Math.round(x * 0.45);
		
		//calcul des tailles de fonts
		int sizeFont = (int) Math.round(x * 0.02);
		
		//Load font from file
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/Eracake.ttf"));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		 
		JPanel panLancer = new JPanel();
		JPanel panArret = new JPanel();
		
		panLancer.setPreferredSize(new Dimension(x / 3, heightPan));
		panArret.setPreferredSize(new Dimension(x / 3, heightPan));
		
		JButton boutLancer = new JButton("Lancer les des"); 
		JButton boutArreter = new JButton("Arreter le tour");
		
		boutLancer.setPreferredSize(new Dimension(widhtBout, heightBout));
		boutArreter.setPreferredSize(new Dimension(widhtBout, heightBout));
		
		boutArreter.setFont(new Font("Eracake", font.ITALIC, sizeFont));
		boutLancer.setFont(new Font("Eracake", font.ITALIC, sizeFont));
		
		
		panLancer.add(boutLancer);
		panArret.add(boutArreter);
		
		this.add(panLancer);
		this.add(panArret);
	}
}
