package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.Serializable;

import javax.swing.*;
import Modele.*;
public class PanelAgenda extends JPanel {
	public PanelAgenda() throws ExceptDate {
		
		Agenda agenda1 =new Agenda(100);
		Evenement evt = new Evenement(new Date(),"TP","IUT");
		agenda1.ajout(evt);
		File Save= new File("Save"+ File.separator + "agenda.ser");
		
		if(Save.length()==0) {
			LectureEcriture.ecriture(Save, agenda1);
		}
		else {
			agenda1=(Agenda) LectureEcriture.lecture(Save);
		}
		
		
		PanelCalendrier cal= new PanelCalendrier(agenda1);
		PanelFormulaire form=new PanelFormulaire();
		
		
		Controleur controleur= new Controleur(agenda1,form,cal,Save);
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
