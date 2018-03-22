package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Agenda;

public class Controleur implements ActionListener {
	Agenda agenda;
	PanelFormulaire panelFormulaire;
	PanelCalendrier panelCalendrier;
	
	public Controleur(Agenda parAgenda,PanelFormulaire parPanelF,PanelCalendrier parPanelC)
	{
		agenda=parAgenda;
		panelFormulaire=parPanelF;
		panelCalendrier=parPanelC;
		panelCalendrier.enregistreEcouteur(this);
		panelFormulaire.enregistreEcouteur(this);
		
		 
	}

	public void actionPerformed(ActionEvent parEvent) {
		System.out.println("test");
		agenda=panelFormulaire.resultat;
		panelFormulaire.parAn=panelCalendrier.nbYear;
		panelFormulaire.parMois=panelCalendrier.nbMois;
		panelFormulaire.parJour=panelCalendrier.panelMois.currentDay;
		panelFormulaire.updateTitle();
		System.out.println(panelFormulaire.titre.getText());
		 
		
	}
}
