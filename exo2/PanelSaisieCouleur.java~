import javax.swing.* ;

import java.awt.*;
import java.awt.event.*;


public class PanelSaisieCouleur  extends JPanel implements ActionListener{
		JLabel labelRouge = new JLabel ("rouge") ;
		JTextField zoneDeSaisieRouge = new JTextField(10);
		JLabel labelVert = new JLabel ("vert") ;
		JTextField zoneDeSaisieVert = new JTextField(10);
		JLabel labelBleu = new JLabel ("bleu") ;
		JTextField zoneDeSaisieBleu = new JTextField(10);
		JButton bouton = new JButton ("Envoi");
		JTextField zoneDeMessage = new JTextField(10);
		int entierValeurRouge=0;
		int entierValeurVert=0;
		int entierValeurBleu=0;
		Color test;
		JLabel res;
		JLabel res2;
		
	public  PanelSaisieCouleur  (JLabel parlabel,JLabel parlabel2 ) {
		
		
		add(labelRouge);
		add(zoneDeSaisieRouge);
		add(labelVert);
		add(zoneDeSaisieVert);
		add(labelBleu);
		add(zoneDeSaisieBleu);
		add(bouton);

		bouton.addActionListener(this);
		res=parlabel;
		res2=parlabel2;
		
	}
	public Color getColor() {
		return test;
	}
	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getSource()==bouton)
		{
			entierValeurRouge= Integer.parseInt(zoneDeSaisieRouge.getText() );
			entierValeurVert= Integer.parseInt(zoneDeSaisieVert.getText() );
			entierValeurBleu= Integer.parseInt(zoneDeSaisieBleu.getText() );
			test = new Color(entierValeurRouge,entierValeurVert,entierValeurBleu);
			res.setForeground(test);
			res2.setForeground(test);
			res2.setText(test.toString() );
			
			
		}
			
	}
}
