package vue;

import java.awt.Color;

import javax.swing.JButton;

import Modele.Date;

public class BoutonDate extends JButton {
	private Date date;
	public BoutonDate(String string) {
		super (string);
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setColor(Date date2) {
		//System.out.println("DateBouton :" + date.toString());
		//System.out.println("DateEvent :" + date2.toString());
		if(date.getAnne()==date2.getAnne() && date.getMois()==date2.getMois() && date.getJour()==date2.getJour()) {
			setBackground(new Color(250,200,200));
		}
	}
}