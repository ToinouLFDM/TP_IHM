package vue;

import javax.swing.*;

import Modele.Agenda;
import Modele.ExceptDate;

import java.awt.*;

public class FenetreAgenda extends JFrame {
	public FenetreAgenda (String parTitre ) throws ExceptDate {
		super(parTitre);
		PanelAgenda contentPane = new PanelAgenda();
		
		this.setContentPane(contentPane);
		setBackground(new Color(150,150,150));
		contentPane.setBackground(new Color(200,200,150));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,500);
		setVisible(true);
		setLocation(400,300);
		
	}
	
	public static void main (String []args) throws ExceptDate {
		new FenetreAgenda("test");
	}
}
