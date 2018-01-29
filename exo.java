import javax.swing.JFrame ;
import javax.swing.JPanel ;
import java.awt.Color ;

public class FenetreMere extends JFrame
{
	public FenetreMere (String parTitre)
	{
		super(parTitre);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(230,67,98));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,200);
		setVisible(true);
		setLocation(200,300);
	}

	public static void main (String []args)
	{
		new FenetreMere("La fenetre et son contenu");
	}
}

