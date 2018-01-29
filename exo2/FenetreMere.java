import javax.swing.JFrame ;
import javax.swing.JPanel ;
import java.awt.Color ;
import java.awt.Insets;

public class FenetreMere extends JFrame {

	public FenetreMere (String parTitre) {
		super(parTitre);
		PanelFilsTreizeLabels contentPane = new PanelFilsTreizeLabels();
		setContentPane(contentPane);
		setBackground(new Color(150,67,98));
		contentPane.setBackground(new Color(150,67,98));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,400);
		setVisible(true);
		setLocation(200,300);
	}
	
	public static void main (String []args) {
		new FenetreMere("test");
	}
}
