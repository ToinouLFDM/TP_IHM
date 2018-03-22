package Modele;

import java.util.Collection;
import java.util.TreeSet;

public class CalendrierDuMois {
	private Collection <Date> dates;
	
	public CalendrierDuMois (int mois, int annee) throws ExceptDate {
		dates = new TreeSet <Date> ();
		Date date = new Date (1, mois, annee);
		int indiceJour = date.getJourSemaine();
		System.out.println(indiceJour);
		for (int indice = indiceJour ; indice>=1 ; indice--) {
			dates.add(date);
			date = date.dateDeLaVeille();
		}
		date = new Date (2,mois,annee);
		indiceJour = indiceJour+1 % 7 ;
		
		while (date.getMois () == mois) {
			while(indiceJour<=7) {
				dates.add(date);
				date = date.dateDuLendemain();
				indiceJour++ ;
			}
			indiceJour=1;
		}
		}
		public Collection <Date> getDates() {
			return dates;
	}
}
