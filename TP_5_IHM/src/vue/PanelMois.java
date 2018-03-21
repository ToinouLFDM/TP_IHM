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

import Modele.CalendrierDuMois;
import Modele.Date;
import Modele.ExceptDate;

public class PanelMois extends JPanel implements ActionListener {
	Color baseColor =new Color(255,255,255);
	BoutonDate[][] Jours  =new BoutonDate[7][7];
	public PanelMois(int nbMonth,int nbYear) throws ExceptDate {
		String [] dictJours = {" Lu"," Ma"," Me"," Je"," Ve"," Sa","Di"};
		JLabel [] labelJours = new JLabel[7];
		
		GregorianCalendar d = new GregorianCalendar(1,nbMonth,nbYear);
		int day= d.get(Calendar.DAY_OF_WEEK);
		int nb_row=0;
		int nb_col=7;
		if(day>=5)
			nb_row=6;
		else
			nb_row=7;
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
			
		
	}

	
	public void actionPerformed(ActionEvent parEvent) {
		BoutonDate bt = (BoutonDate) parEvent.getSource();
		
		resetColor(Jours,bt.getDate().getMois(),bt.getDate().getAnne());
		bt.setBackground(new Color(150,150,200));
		System.out.print(bt.getDate().toString());
		
	}
	private void resetColor(BoutonDate [][] bt, int nbMonth, int nbYear)
	{
		GregorianCalendar d = new GregorianCalendar(1,nbMonth,nbYear);
		int day= d.get(Calendar.DAY_OF_WEEK);
		int nb_row=0;
		int nb_col=7;
		if(day>=5)
			nb_row=6;
		else
			nb_row=7;
		for(int i=0;i<nb_row;i++)
		{
			for(int j=0;j<nb_col;j++)
			{
				bt[i][j].setBackground(baseColor);
			}
		}
	}
}
