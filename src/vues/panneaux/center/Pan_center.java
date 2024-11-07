package vues.panneaux.center;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ctrl.Control;
import modeles.Joueur;

public class Pan_center extends JPanel {

	private static final long serialVersionUID = 1L;

	Control ctrl = null;
	
	int xPanSize, yPanSize;
	
	JLabel l1;
	JTextField jtf;
	JButton button;
	
	PanneauMessages_Center panMessages = null;
	PanneauDes_Center panDes = null;

	//*********CONSTRUCTEUR*********
	public Pan_center(Control ctrl_) {
		this.ctrl = ctrl_;
		ctrl.setPan_center(this);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panMessages = new PanneauMessages_Center();
		panDes = new PanneauDes_Center();
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(panMessages);
		this.add(panDes);
	}

	//*********METHODES*********

    @Override
    public Dimension getPreferredSize() {
        // Retourner la taille préférée du panneau centre
        Dimension dim = super.getPreferredSize();
        dim.height = getParent().getHeight();  // La hauteur sera déterminée par la fenêtre principale
        return dim;
    }

	public void setScorePanScores(Joueur joueur) {
		panMessages.setMessage("" + joueur.getNbrePts());
	}
}
