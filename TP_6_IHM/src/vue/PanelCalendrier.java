package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.ExceptDate;

public class PanelCalendrier extends JPanel implements ActionListener {
	
	String [] Mois = {" Janvier"," Février"," Mars"," Avril"," Mai"," Juin"," Juillet"," Aout"," Septembre"," Octobre"," Novembre"," Decembre"};
	final static Font FONT_AN =new Font("VERDANA",Font.BOLD,20);
	JButton up = new JButton(">");
	JButton up2 = new JButton(">>");
	JButton down = new JButton("<");
	JButton down2 = new JButton("<<");
	int nbYear= new java.util.Date().getYear()+2000-100;
	int  nbMois = new java.util.Date().getMonth();
	int currentDay;
	PanelMois panelMois= new PanelMois(nbMois+1,nbYear);
	Controleur c;
	JLabel labelMois= new JLabel(Mois[nbMois],JLabel.LEFT);
	JLabel annee = new JLabel("An : " + (nbYear),JLabel.CENTER);
	
	public PanelCalendrier() throws ExceptDate {
		BorderLayout layout =new BorderLayout();
		JPanel button = new JPanel();
		button.setLayout(layout);
		button.setBackground(new Color(200,200,150));
		JPanel buttonDown=new JPanel();
		JPanel buttonUp=new JPanel();
		buttonDown.setBackground(new Color(200,200,150));
		buttonUp.setBackground(new Color(200,200,150));
		buttonDown.add(down2,layout.WEST);
		buttonDown.add(down,layout.EAST);
		buttonUp.add(up,layout.WEST);
		buttonUp.add(up2,layout.EAST);
		button.add(buttonDown,layout.WEST);
		button.add(buttonUp,layout.EAST);
		
		panelMois.setBackground(new Color(200,200,150));
		
		
		annee.setPreferredSize(new Dimension(100,100));;
		
		
		
		//conteneur principal
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(200,200,150));
		BorderLayout layout2 =new BorderLayout();
		setLayout(layout2);
		
		
		add(panelMois,layout2.CENTER);
		add(annee,layout2.NORTH);
		
		bottom.add(labelMois,layout2.WEST);
		bottom.add(button,layout2.EAST);
		add(bottom,layout2.SOUTH);
		
		
		annee.setFont(FONT_AN);
		down.addActionListener(this);
		down2.addActionListener(this);
		up.addActionListener(this);
		up2.addActionListener(this);
		
		
	}

	
	public void actionPerformed(ActionEvent parEvent) {
		
		if(parEvent.getSource()==down)
		{
			if(nbMois==0)
			{
				nbMois=11;
				nbYear-=1;
			}
			else
				nbMois-=1;
		}
		else if(parEvent.getSource()==up)
		{
			if(nbMois==11)
			{
				nbMois=0;
				nbYear+=1;
			}	
			else
				nbMois+=1;
		}
		else if(parEvent.getSource()==down2)
			nbYear-=1;
		else if(parEvent.getSource()==up2)
			nbYear+=1;
		remove(panelMois);
		System.out.println(nbMois);
		annee.setText("An : " + nbYear);
		labelMois.setText(Mois[nbMois]);
		try {
			panelMois= new PanelMois(nbMois+1,nbYear);
		} catch (ExceptDate e) {
			e.printStackTrace();
		}
		BorderLayout layout2= new BorderLayout();
		panelMois.setBackground(new Color(200,200,150));
		add(panelMois,layout2.CENTER);
		enregistreEcouteur(c);
		
	}
public void enregistreEcouteur(Controleur parControleur) {
		c=parControleur;
		for (int i=0;i<panelMois.nb_row-1;i++) {
			for (int j=0;j<panelMois.nb_col;j++) {
				
				panelMois.Jours[i][j].addActionListener(parControleur);
			}
		}
	}
}
