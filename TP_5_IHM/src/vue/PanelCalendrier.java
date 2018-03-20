package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCalendrier extends JPanel {
	
	String [] Mois = {" Janvier"," Février"," Mars"," Avril"," Mai"," Juin"," Juillet"," Aout"," Septembre"," Octobre"," Novembre"," Decembre"};
	String [] Jours = {" Di"," Lu"," Ma"," Me"," Je"," Ve"," Sa"};
	JButton up = new JButton(">");
	JButton up2 = new JButton(">>");
	JButton down = new JButton("<");
	JButton down2 = new JButton("<<");
	
	
	
	JLabel labelMois= new JLabel(Mois[new java.util.Date().getMonth()],JLabel.LEFT);
	
	public PanelCalendrier() {
		BorderLayout layout =new BorderLayout();
		JPanel button = new JPanel();
		button.setLayout(layout);
		button.setBackground(new Color(200,200,150));
		JPanel buttonDown=new JPanel();
		JPanel buttonUp=new JPanel();
		buttonDown.setBackground(new Color(200,200,150));
		buttonUp.setBackground(new Color(200,200,150));
		buttonDown.add(down2,layout.WEST);
		buttonDown.add(down,layout.EAST);
		buttonUp.add(up,layout.WEST);
		buttonUp.add(up2,layout.EAST);
		button.add(buttonDown,layout.WEST);
		button.add(buttonUp,layout.EAST);
		
		
		
		//conteneur principal
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(200,200,150));
		BorderLayout layout2 =new BorderLayout();
		setLayout(layout2);
		
		
		add(new JLabel("Replace Me !",JLabel.CENTER),layout2.CENTER);
		
		
		bottom.add(labelMois,layout2.WEST);
		bottom.add(button,layout2.EAST);
		add(bottom,layout2.SOUTH);
		
		
		
	}
}
