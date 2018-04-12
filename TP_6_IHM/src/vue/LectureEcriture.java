package vue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LectureEcriture {
	public static Object lecture (File parFichier) {
		ObjectInputStream flux ;
		Object objetLu = null;
		// Ouverture du fichier en mode lecture
		try {
			flux = new ObjectInputStream(new FileInputStream (parFichier));
			objetLu = (Object)flux.readObject ();
			flux.close ();
		}
		catch (ClassNotFoundException parException) {
			System.err.println (parException.toString ());
			System.exit (1);
		}
		catch (IOException parException) {
			System.err.println ("Erreur lecture du fichier " + parException.toString ());
			System.exit (1);
		}
		return objetLu ;
	} // lecture ()

	public static void ecriture (File parFichier, Object parObjet) {
		ObjectOutputStream flux = null;
		// Ouverture du fichier en mode écriture
		try {
			flux = new ObjectOutputStream (new FileOutputStream (parFichier));
			System.out.println("write step 1");
			flux.writeObject (parObjet);
			System.out.println("write step 2");
			flux.flush ();
			System.out.println("write step 3");
			flux.close ();
		}
		catch (IOException parException) {
			System.err.println ("Probleme a l’ecriture\n" + parException.toString ());
			System.exit (1);
		}
	} // ecriture ()
}
