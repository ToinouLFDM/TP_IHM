package Modele;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable <Date>{

	private int chJour;
	private int chMois;
	private int chAn;
	private int chJourNom;
	private int jourSemaine ;  

	
	
	public Date(int parJour,int parMois,int parAn)throws ExceptDate{
		
		
	
		
		if(parAn < 1583)
			throw new ExceptDate("Année invalide");
		if(parMois <1 || parMois>12)
			throw new ExceptDate("Mois invalide");
		if(parJour <1 || parJour > dernierJourDuMois())
			throw new ExceptDate("Jour invalide");
		
		GregorianCalendar d = new GregorianCalendar(parAn,parMois,parJour);
		
		chAn=parAn;
		chMois=parMois;
		chJour=parJour;
		chJourNom=d.get(Calendar.DAY_OF_WEEK);
		jourSemaine = d.get (Calendar.DAY_OF_WEEK);	
		
		
	}
	public int getJourSemaine () {
		return jourSemaine;
	}
	public Date()throws ExceptDate{
		
		GregorianCalendar aujourdhui = new GregorianCalendar();
		
		chAn=aujourdhui.get(Calendar.YEAR);
		chMois=aujourdhui.get(Calendar.MONTH)+1;
		chJour=aujourdhui.get(Calendar.DAY_OF_MONTH);
		chJourNom=aujourdhui.get(Calendar.DAY_OF_WEEK);
		jourSemaine = aujourdhui.get (Calendar.DAY_OF_WEEK);
		
		if(chAn < 1583)
			throw new ExceptDate("Année invalide");
		if(chMois <1 || chMois>12)
			throw new ExceptDate("Mois invalide");
		if(chJour <1 || chJour > dernierJourDuMois())
			throw new ExceptDate("Jour invalide");
		
	}

	public Date(Date parDate){
		chJour = parDate.chJour;
		chMois = parDate.chMois;
		chAn = parDate.chAn;
	}

	public int dernierJourDuMois(){
		switch(chMois)
		{
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if((chAn%4==0&&chAn%100!=0)||chAn%400==0)
					return 29;
				else
					return 28;
			default:
				return 31;
		}		
	}

	public boolean estValide(){
		
		if(chAn < 1583)
			return false;
		if(chMois <1 || chMois>12)
			return false;
		if(chJour <1 || chJour > dernierJourDuMois())
			return false;
		
		return true;	
	}

	public static Date lireDate() throws ExceptDate{
		
		System.out.println("Jour: ");	
		int jour = Clavier.lireInt();	
		System.out.println("Mois: ");	
		int mois = Clavier.lireInt();
		System.out.println("Ans: ");	
		int an = Clavier.lireInt();

		return new Date(jour,mois,an);
	}

	 public int compareTo(Date parDate){
	        if(chAn < parDate.chAn)
	            return -1;
	        else if(chAn == parDate.chAn)
	            if(chMois < parDate.chMois)
	                return -1;
	            else if(chMois == parDate.chMois)
	                if(chJour  < parDate.chJour)
	                    return -1;
	                else if(chJour == parDate.chJour)
	                    return 0;
	                else
	                    return 1;
	            else
	                return 1;
	        else
	            return 1;
	    }      

	    public Date dateDuLendemain()
	    {
	        Date nouvelleDate = new Date(this);
	        if(nouvelleDate.chJour == nouvelleDate.dernierJourDuMois())
	        {
	            nouvelleDate.chJour = 1;
	            if(nouvelleDate.chMois == 12)
	            {
	                nouvelleDate.chMois = 1;
	                nouvelleDate.chAn += 1;
	            }
	            else
	                nouvelleDate.chMois += 1;
	        }
	        else
	            nouvelleDate.chJour += 1;
	        return nouvelleDate;
	    }
	    
	    public Date dateDeLaVeille()
	    {
	        Date nouvelleDate = new Date(this);
	        if(nouvelleDate.chJour == 1)
	        {
	            if(nouvelleDate.chMois == 1)
	            {
	                nouvelleDate.chMois = 12;
	                nouvelleDate.chAn -= 1;
	            }
	            else
	                nouvelleDate.chMois -= 1;
	            nouvelleDate.chJour = nouvelleDate.dernierJourDuMois();
	        }
	        else
	            nouvelleDate.chJour -= 1;
	        return nouvelleDate;
	    }
	
	
	public int getAnne(){
		
		return chAn;
	}
	
	public int getMois(){
			
			return chMois;
		}

	public int getJour(){
		
		return chJour;
	}

	public String toString(){
		String [] Mois = {""," janvier"," février"," mars"," avril"," mai"," juin"," juillet"," aout"," septembre"," octobre"," novembre"," decembre"};
		String [] Jours = {""," Dimanche"," Lundi"," Mardi"," Mercredi"," Jeudi"," Vendredi"," Samedi"};
		
		String resultat;
		resultat = Jours[chJourNom] +" "+chJour + Mois[chMois] +" "+chAn;
		
		return resultat;
		
	}
}


