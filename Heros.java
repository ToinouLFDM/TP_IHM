import java.util.Scanner; 

public class Heros {
	
	String chNom;
	String chClasse;
	char chGenre;
	int chPointsDeVie;
	int chAttaque;
	int chDefense;
	int chDommage;
	int chPVMax;
	
	public Heros(String parNom, String parClasse, char parGenre) {
		chNom = parNom;
		chClasse= parClasse;
		chGenre=parGenre;
		chPointsDeVie=100;
		chAttaque=10;
		chDefense=10;
		chDommage=10;
		chPVMax=chPointsDeVie;
		
	}
		public Heros(String parNom, String parClasse, char parGenre, int parPointsDeVie, int parAttaque, int parDefense, int parDommage) {
		chNom = parNom;
		chClasse= parClasse;
		chGenre=parGenre;
		chPointsDeVie=parPointsDeVie;
		chAttaque=parAttaque;
		chDefense=parDefense;
		chDommage=parDommage;
		chPVMax=chPointsDeVie;
		
	}
	
	public boolean estVivant(){
		return chPointsDeVie>=0 ;
	}
	public String toString() {
		if(chGenre=='M')
			return chNom + " le " + chClasse;
		else
			return chNom + " la " + chClasse;
	}

	public void soigner (){
		if(this.chPointsDeVie<this.chPVMax)
			this.chPointsDeVie=this.chPVMax;
		
	}
	public void attaquer(Heros defenseur) {
		float p=(float)this.chAttaque/((float)(this.chAttaque+defenseur.chDefense));
		if(p<Math.random())
			defenseur.chPointsDeVie-=this.chAttaque;
				

	}
	public static int Menu() {
		System.out.println("1 _ Attaque");
		System.out.println("2 _ Soin");
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		return i;
		
	}
	public static void game(Heros joueur1, Heros joueur2) {
		int tour=0;;
		while(joueur1.estVivant() && joueur2.estVivant() ) {
			if(tour==0) {
				
				System.out.println("c'est au joueur 1 de jouer");
				
				
				tour+=1;
				switch(Menu()) {
					case 1:
						System.out.println(joueur1.toString() +" attaque " + joueur2.toString());
						joueur1.attaquer(joueur2);
						System.out.println(" il reste "+  joueur2.chPointsDeVie+" a " +  joueur2.toString());
						break;
					case 2: 
						joueur1.soigner();
						System.out.println(joueur1.toString() +" c'est soigné !");
						break;
				}
			}
			else if (tour==1) {
				System.out.println("c'est au joueur 2 de jouer");
				tour=0;
				switch(Menu()) {
					case 1:
						System.out.println(joueur2.toString() +" attaque " + joueur1.toString());
						joueur2.attaquer(joueur1);
						System.out.println(" il reste "+  joueur1.chPointsDeVie+" a " +  joueur1.toString());
						break;
					case 2: 
						joueur1.soigner();
						System.out.println(joueur2.toString() +" c'est soigné !");
						break;
						
				}
			}
			
		}
	}
	public static void main (String []args)
	{
		Heros bob = new Heros("Bob","Magicien",'M');
		Heros zoe = new Heros("Zoe","Barbare",'F');
		
		System.out.println(bob.toString());
		System.out.println(zoe.toString());
		
		game(bob,zoe);
		
	}
	
	
}
