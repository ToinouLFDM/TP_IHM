package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Agenda;
import Modele.CalendrierDuMois;
import Modele.Date;
import Modele.Evenement;
import Modele.ExceptDate;

public class PanelMois extends JPanel implements ActionListener {
	Color baseColor =new Color(255,255,255);
	BoutonDate[][] Jours  =new BoutonDate[6][7];
	int nb_row;
	int nb_col;
	int currentDay= new java.util.Date().getDay();
	 Agenda agenda;
	public PanelMois(int nbMonth,int nbYear, Agenda parAgenda) throws ExceptDate {
		String [] dictJours = {" Lu"," Ma"," Me"," Je"," Ve"," Sa","Di"};
		JLabel [] labelJours = new JLabel[7];
		agenda=parAgenda;
		GregorianCalendar d = new GregorianCalendar(nbYear,nbMonth-1,1);
		
		int day= (d.get (Calendar.DAY_OF_WEEK)==1)?7:d.get (Calendar.DAY_OF_WEEK)-1;
		System.out.println("day:" +day + nbMonth);
		nb_row=0;
		nb_col=7;
		if(day>=5)
			nb_row=6;
		else
			nb_row=5;
		Jours  =new BoutonDate[nb_row][nb_col];
		
		
		CalendrierDuMois cal =new CalendrierDuMois(nbMonth,nbYear);
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints constraint =new GridBagConstraints() ;
		
		Collection tsDate = cal.getDates();
		Iterator it=tsDate.iterator();
		int i=0;
		int j=0;
		constraint.gridheight=1;
		constraint.gridwidth=1;
		constraint.gridx=1;
		constraint.gridy=0;
		constraint.fill=GridBagConstraints.HORIZONTAL;
		for (int k=0;k<nb_col;k++)
		{
			labelJours[k]=new JLabel(dictJours[k],JLabel.CENTER);
			add(labelJours[k],constraint);
			constraint.gridx++;
			
		}
		constraint.gridx=0;
		constraint.gridy=1;
		while(it.hasNext())
		{
				Date tmp= (Date) it.next() ;
				Jours[i][j]= new BoutonDate(Integer.toString(tmp.getJour()));
				Jours[i][j].setDate(tmp) ;
				constraint.gridx++;
				add(Jours[i][j],constraint);
				Jours[i][j].addActionListener(this);
				
				baseColor=Jours[i][j].getBackground();
				
				
				if(tmp.getMois()!=nbMonth)
					Jours[i][j].setEnabled(false);
				j++;
				if(j%nb_col==0)
				{
					i++;
					j=0;
					constraint.gridx=0;
					constraint.gridy++;
				}
				
				
				
		}
		
		updateButton();
		
	}

	
	public void actionPerformed(ActionEvent parEvent) {
		BoutonDate bt = (BoutonDate) parEvent.getSource();
		
		resetColor();
		bt.setBackground(new Color(200,200,250));
		
		currentDay =Integer.parseInt( bt.getText());
		System.out.println("real :" + Integer.toString(currentDay));
	}
	public void updateButton() {
		int n=agenda.getTaille();
		Evenement [] tabEvt = agenda.getTabEvt();
		for(int i=0;i<nb_row;i++)
		{
			for(int j=0;j<nb_col;j++)
			{
				int k=0;
				//System.out.println("BoutonDate : " + Jours[i][j].getDate().toString());
				while(k<n && tabEvt[k]!=null) {
					//System.out.println("EVT :" + tabEvt[k].getDate().toString() );
					Jours[i][j].setColor(tabEvt[k].getDate());
					k++;
					}
				}
			}
	}
	private void resetColor()
	{
		
		for(int i=0;i<nb_row;i++)
		{
			for(int j=0;j<nb_col;j++)
			{
				
				Jours[i][j].setBackground(baseColor);
				updateButton();
			}
		}
	}
}
