package Modele;


public class Evenement {

	private Date date;
	private String nom;
	private String lieu;
	private int debuth;
	private int debutm;
	private int finh;
	private int finm;
	private static int nbEvt;
	
	public Evenement(Date parDate,String parNom,String parLieu){

		date = parDate;
		nom = parNom;
		lieu = parLieu;
	
		nbEvt++;
	}
	public Evenement(Date parDate,String parNom,String parLieu,int parDebuth,int parDebutm, int parFinh, int parFinm){

		date = parDate;
		nom = parNom;
		lieu = parLieu;
		debuth=parDebuth;
		debutm=parDebutm;
		finh=parFinh;
		finm=parFinm;
	
		nbEvt++;
	}
	
	public String toString(){
		return date.toString()+" , "+nom+" , "+lieu+", Debut:"+Integer.toString(debuth)+"h"+Integer.toString(debutm)+", Fin:"+Integer.toString(finh)+"h"+Integer.toBinaryString(finm);
	}

	public String getNom(){
		return this.nom;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setNom(String parNom){
		this.nom = parNom;
	}

	public static Evenement lireEvenement() throws ExceptDate{
		
				
		System.out.println("Entrez une date: ");	
		Date parDate = Date.lireDate();
		System.out.println("Nom de l'event: ");	
		String parNom = Clavier.lireString();
		System.out.println("Lieu de l'event: ");	
		String parLieu = Clavier.lireString();

		return new Evenement(parDate,parNom,parLieu); 
	}

	public int compareTo(Evenement parEvt){
		
		 if(date.compareTo(parEvt.date) != 0 )
	            return date.compareTo(parEvt.date);
	     else
	            return (nom.compareTo(parEvt.nom));
	}	
}
