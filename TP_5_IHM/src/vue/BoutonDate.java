package vue;

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
}