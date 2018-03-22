package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
import Modele.*;
public class PanelAgenda extends JPanel{
	public PanelAgenda() throws ExceptDate {
		Agenda agenda1 =new Agenda(100);
		Evenement evt1 = new Evenement(new Date(21,1,1997), "TP1","IUT");
		Evenement evt2 = new Evenement(new Date(21,1,1997), "TP2","IUT");
		Evenement evt3 = new Evenement(new Date(21,1,1997), "TP3","IUT");
		agenda1.ajout(evt1);
		agenda1.ajout(evt2);
		agenda1.ajout(evt3);
		
		PanelCalendrier cal= new PanelCalendrier();
		PanelFormulaire form=new PanelFormulaire();
		
		
		Controleur controleur= new Controleur(agenda1,form,cal);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints constraint =new GridBagConstraints() ;
		
		constraint.gridx=0;
		constraint.gridy=0;
		constraint.gridheight=1;
		constraint.gridwidth=1;
		
		cal.setPreferredSize((new Dimension(390,460)));
		cal.setBackground(new Color(200,200,150));
		add(cal,constraint);
		
		constraint.gridx=1;
		
		form.setBackground(new Color(200,200,150));
		form.setPreferredSize(new Dimension(390,460));
		
		add(form,constraint);
		
		
		
		
	}

}
