import javax.swing.JPanel ;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class PanelFils extends JPanel implements ActionListener {
	//declaration des elements graphique
	JTextField zoneDeSaisie = new JTextField(10);
	JButton bouton = new JButton ("Envoi");
	JTextField zoneDeMessage = new JTextField(10);
	JLabel label = new JLabel ("Entrez votre nom") ;
	JTextArea zoneDeTexte = new JTextArea (10,30) ;
	JRadioButton radioBouton = new JRadioButton ("bouton radio") ;
	CardLayout position1 = new position1(100,100);
	

	public PanelFils() {
		add(label);
		//add(zoneDeSaisie);
		
		//add(bouton);
		
		//bouton.addActionListener(this);
		//add(zoneDeMessage);
		//add(zoneDeTexte);
		//add(radioBouton);
	}
	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getSource()==bouton)
			zoneDeMessage.setText("Bonjour " + zoneDeSaisie.getText());
	}
	
}

