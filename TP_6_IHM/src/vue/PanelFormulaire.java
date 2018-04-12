package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Modele.*;
public class PanelFormulaire extends JPanel implements ActionListener{
	//declaration des ob00et
	final static Font FONT_14 =new Font("VERDANA",Font.BOLD,14);
	final static Font FONT_12 =new Font("VERDANA",Font.BOLD,12);
	int parJour=new java.util.Date().getDate();
	int parMois=new java.util.Date().getMonth();
	int parAn = new java.util.Date().getYear() +2000-100;
	
	
	GregorianCalendar d = new GregorianCalendar(parAn,parMois,parJour);
	String [] NomMois = {" janvier"," février"," mars"," avril"," mai"," juin"," juillet"," aout"," septembre"," octobre"," novembre"," decembre"};
	String [] NomJours = {" Dimanche"," Lundi"," Mardi"," Mercredi"," Jeudi"," Vendredi"," Samedi"};
	int NJour = d.get(Calendar.DAY_OF_WEEK)-1;
	int NMois = d.get(Calendar.MONTH);
	
	
	JLabel titre =new JLabel(NomJours[NJour]+" " +Integer.toString(parJour)+" "+NomMois[NMois]+" "+Integer.toString(parAn));
	
	JButton finish=new JButton("+");
	JLabel nom =new JLabel("Titre :");
	JLabel lieu = new JLabel("Lieu :");
	JLabel debut = new JLabel("Debut :");
	JLabel fin = new JLabel("Fin :");
	JLabel desc = new JLabel("Description :");
	JLabel replaceme = new JLabel(" : ");
	JLabel replaceme2 = new JLabel(" : ");
	JLabel empty = new JLabel("");
	JLabel empty2 = new JLabel("");
		
	JTextField zoneNom= new JTextField(20);
	JTextField zoneLieu = new JTextField(20);
	JTextField zoneDesc =new JTextField(100);
	Agenda resultat=new Agenda(5);
	
	String Jour[] = new String[24];
	String Mois[] = new String[60];
	public void initCombobox(String[] Jour,String Mois[])
	{
		for (int i=0; i<24;i++) {
			if(i<10)
				Jour[i]="0" + Integer.toString(i) ;
			else
				Jour[i]=Integer.toString(i);
		}
		for (int j=0; j<60;j++) {
			if(j<10)
				Mois[j]= "0" + Integer.toString(j);
			else
				Mois[j]=Integer.toString(j);
		}
	}
	
	JComboBox Jour1=new JComboBox(Jour);
	JComboBox Jour2=new JComboBox(Jour);
	JComboBox Mois1=new JComboBox(Mois);
	JComboBox Mois2=new JComboBox(Mois);
	
			
	public PanelFormulaire() {
		
		
		initCombobox(Jour,Mois);
		JComboBox Jour1=new JComboBox(Jour);
		JComboBox Jour2=new JComboBox(Jour);
		JComboBox Mois1=new JComboBox(Mois);
		JComboBox Mois2=new JComboBox(Mois);
				
		
				

		
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints constraint =new GridBagConstraints() ;
		
		int coeff=1;
		constraint.insets=new Insets(0,0,10,10);
		//mise en place de l'interface
		constraint.weightx=1;
		constraint.weighty=0.1;
		constraint.gridx =0*coeff;
		constraint.gridy=0*coeff;
		constraint.gridheight=1*coeff;
		constraint.gridwidth=2*coeff;
		add(titre,constraint);
		
		constraint.anchor=GridBagConstraints.LINE_END;
		constraint.gridx=4*coeff;
		constraint.gridy=0*coeff;
		constraint.gridheight=1*coeff;
		
		add(finish,constraint);
		
		//ligne nom
		
		constraint.anchor=GridBagConstraints.LINE_END;
		constraint.ipady=5;
		constraint.gridy=1*coeff;
		constraint.gridx=0*coeff;
		constraint.gridwidth=1*coeff;
		constraint.gridheight=1*coeff;
		add(nom,constraint);
		
		
		constraint.fill=GridBagConstraints.HORIZONTAL;
		constraint.gridx=1*coeff;
		constraint.gridwidth= 4*coeff;
		
		add(zoneNom,constraint);
		
		//ligne lieu
		constraint.gridx=0*coeff;
		constraint.gridy=2*coeff;
		constraint.fill=0;
		constraint.gridwidth=1*coeff;
		add(lieu,constraint);
		
		constraint.fill=GridBagConstraints.HORIZONTAL;
		constraint.gridx=1*coeff;
		constraint.gridwidth= 4*coeff;
		
		add(zoneLieu,constraint);
		
		//ligne Debut
		constraint.fill=0;
		constraint.gridx=0*coeff;
		constraint.gridy=3*coeff;
		
		
		
		//constraint.fill=GridBagConstraints.HORIZONTAL;
		constraint.gridwidth = 1*coeff;
		add(debut,constraint);
		
		constraint.gridx=1*coeff;
		add(Jour1,constraint);
		constraint.gridx=2*coeff;
		add(replaceme,constraint);
		constraint.gridx=3*coeff;
		add(Mois1,constraint);
		constraint.gridx=4*coeff;
		add(empty,constraint);
		
		
		//ligne fin
		
		constraint.gridx=0*coeff;
		constraint.gridy=4*coeff;
		//constraint.fill=GridBagConstraints.HORIZONTAL;
		constraint.gridwidth = 1*coeff;
		add(fin,constraint);
		
		constraint.gridx=1*coeff;
		add(Jour2,constraint);
		constraint.gridx=2*coeff;
		add(replaceme2,constraint);
		constraint.gridx=3*coeff;
		add(Mois2,constraint);
		constraint.gridx=4*coeff;
		add(empty2,constraint);
		
		//ligne desc
		constraint.anchor=GridBagConstraints.NORTHEAST;
		constraint.weightx=1;
		constraint.weighty=1;
		constraint.gridx=0*coeff;
		constraint.gridy=5*coeff;
		//constraint.fill=GridBagConstraints.HORIZONTAL;
		constraint.gridwidth = 1*coeff;
		add(desc,constraint);
		
		
		constraint.gridheight= 5*coeff;
		constraint.gridwidth=4*coeff;
		constraint.fill=GridBagConstraints.BOTH;
		constraint.gridx=1*coeff;
		
		add(zoneDesc,constraint);
		
		finish.addActionListener(this);
		
		titre.setFont(FONT_14);
		lieu.setFont(FONT_12);
		nom.setFont(FONT_12);
		debut.setFont(FONT_12);
		fin.setFont(FONT_12);
		desc.setFont(FONT_12);
		replaceme.setFont(FONT_12);
		replaceme2.setFont(FONT_12);
		
		
	}

	public void actionPerformed(ActionEvent parEvent) {
		
		
	}
	public Evenement create() throws ExceptDate {
		
		Date date = new Date(parJour,parMois+1,parAn);
		Evenement evt= new Evenement(date,zoneNom.getText(),zoneLieu.getText(),Jour1.getSelectedIndex(), Mois1.getSelectedIndex(),Jour2.getSelectedIndex(),Mois2.getSelectedIndex());
		return evt;
	}
	public void enregistreEcouteur(Controleur parControleur) {
		finish.addActionListener(parControleur);
	}
	public void updateTitle () {
		d = new GregorianCalendar(parAn,parMois,parJour);
		int NJour = d.get(Calendar.DAY_OF_WEEK)-1;
		titre.setText(NomJours[NJour]+" " +Integer.toString(parJour)+" "+NomMois[parMois]+" "+Integer.toString(parAn));
	}

}
