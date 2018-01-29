import javax.swing.JFrame ;
import javax.swing.JPanel ;
import java.awt.Color ;
import java.awt.Insets;

public class FenetreMereTestCouleurs extends JFrame {

	public FenetreMereTestCouleurs (String parTitre) {
		super(parTitre);
		PanelFilsTestCouleurs contentPane = new PanelFilsTestCouleurs();
		setContentPane(contentPane);
		setBackground(new Color(150,67,98));
		contentPane.setBackground(new Color(150,67,98));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,200);
		setVisible(true);
		setLocation(200,300);
	}
	
	public Insets getInsets () {
		return new Insets (60,60,60,60) ;
	}
	
	public static void main (String []args) {
		new FenetreMereTestCouleurs("test couleur");
	}
}
