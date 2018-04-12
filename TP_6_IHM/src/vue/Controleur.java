package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;

import Modele.Agenda;
import Modele.ExceptDate;

public class Controleur implements ActionListener {
	Agenda agenda;
	PanelFormulaire panelFormulaire;
	PanelCalendrier panelCalendrier;
	File Save;
	
	public Controleur(Agenda parAgenda,PanelFormulaire parPanelF,PanelCalendrier parPanelC,File _Save)
	{
		agenda=parAgenda;
		panelFormulaire=parPanelF;
		panelCalendrier=parPanelC;
		panelCalendrier.enregistreEcouteur(this);
		panelFormulaire.enregistreEcouteur(this);
		File Save= new File("Save"+ File.separator + "agenda2.ser");;
		 
	}

	public void actionPerformed(ActionEvent parEvent) {
		
		
		
		if(parEvent.getSource().getClass()==new BoutonDate("").getClass())
		{
			BoutonDate tmp = (BoutonDate) parEvent.getSource();
			System.out.println("test detection");
			panelCalendrier.panelMois.currentDay= Integer.parseInt(tmp.getText()); 
		}
		if(parEvent.getSource()==panelFormulaire.finish)
		{
			try {
				agenda.ajout(panelFormulaire.create());
				System.out.println(agenda);
			} catch (ExceptDate e) {
				e.printStackTrace();
			}
			panelCalendrier.updateCal();
		}
		
		panelCalendrier.agenda=agenda;
		panelFormulaire.parAn=panelCalendrier.nbYear;
		panelFormulaire.parMois=panelCalendrier.nbMois;
		panelFormulaire.parJour=panelCalendrier.panelMois.currentDay;
		
		System.out.println("controler :" + Integer.toString(panelCalendrier.panelMois.currentDay));
		panelFormulaire.updateTitle();
		System.out.println(panelFormulaire.titre.getText());
		
		if(parEvent.getSource().getClass()==new JButton("").getClass() ) {
			JButton tmp = (JButton) parEvent.getSource();
			if(tmp.getText()=="+") {
				System.out.println("sauvegarde!");
				LectureEcriture.ecriture(Save, agenda);
			}
		}
		
		
		 
		
	}
}
