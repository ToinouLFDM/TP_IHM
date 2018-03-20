package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMois extends JPanel {
	public PanelMois(int nbMonth) {
		
		GregorianCalendar d = new GregorianCalendar(1,nbMonth,2018);
		int day= d.get(Calendar.DAY_OF_WEEK);
		int nb_row=0;
		int nb_col=7;
		if(day>=5)
			nb_row=6;
		else
			nb_row=7;
		
		JButton[][] Jours  =new JButton[nb_row][nb_col];
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints constraint =new GridBagConstraints() ;
		
		for(int i=0;i<nb_row;i++)
		{
			for(int j=0;j<nb_col;j++)
			{
				
			}
		}
		
	}
}
