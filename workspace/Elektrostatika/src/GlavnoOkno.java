import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class GlavnoOkno extends JFrame {
	
	public Platno platno;
	private JButton konec;
	private JButton magnet;
	private JButton zbris;
	private JTextField magnetnopolje;
//    GridLayout mreza = new GridLayout(0,2);
	private JTextField xkord;
	private JTextField ykord;
	private JTextField xsmer;
	private JTextField ysmer;
	private JTextField el;
	//e je naboj m je masa
	private JButton proton;
	private JTextField m; 
	private JButton sled;	
	public Platno getPlatno() {
		return platno;
	}

	public GlavnoOkno() {
		super("Nabiti Delci");
//		this.setLayout(mreza);
		
		this.platno = new Platno();
		this.add(this.platno);
		setLayout(new GridBagLayout());
		
		setTitle("naboj v mikrokolonih, masa v g magnetno polje je v mikro teslah polje je veliko 1200cm*700cm x se veca na desno y se veca na dol hitrost je v cm na sekundo ");
		
		konec=this.platno.konec;
		this.add(konec);
		konec.addActionListener(platno);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		c.gridx = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.CENTER;
		add(this.platno, c);
		c = new GridBagConstraints();
		c.gridy = 1;
		c.gridx = 2;
		add(konec, c);
		c = new GridBagConstraints();
		magnet=this.platno.magnet;
		magnet.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 2;
		c.gridx = 4;
		add(magnet, c);
		magnetnopolje=platno.magnetnopolje;
		magnetnopolje.addActionListener(platno);
		
		c = new GridBagConstraints();
		c.gridy = 2;
		c.gridx = 3;
		c.weightx = 0.1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(magnetnopolje, c);
		
		xkord=platno.xkord;
		xkord.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 3;
		c.gridx = 3;
		c.weightx = 0.1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(xkord, c);	
		
		ykord=platno.ykord;
		ykord.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 4;
		c.gridx = 3;
		c.weightx = 0.1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(ykord, c);
		
		xsmer=platno.xsmer;
		xsmer.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 5;
		c.gridx = 3;
		c.weightx = 0.1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(xsmer, c);

		ysmer=platno.ysmer;
		ysmer.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 6;
		c.gridx = 3;
		c.weightx = 0.1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(ysmer, c);
		
		el=platno.el;
		ysmer.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 7;
		c.gridx = 3;
		c.weightx = 0.1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(el, c);
		
		m=platno.m;
		ysmer.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 8;
		c.gridx = 3;
		c.weightx = 0.1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(m, c);
		c = new GridBagConstraints();
		c.gridy = 1;
		c.gridx = 3;
		add(konec, c);
		
		c = new GridBagConstraints();
		proton=this.platno.proton;
		proton.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 3;
		c.gridx = 4;
		add(proton, c);

		c = new GridBagConstraints();
		zbris=this.platno.zbris;
		zbris.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 4;
		c.gridx = 4;
		add(zbris, c);

		c = new GridBagConstraints();
		sled=this.platno.sled;
		sled.addActionListener(platno);
		c = new GridBagConstraints();
		c.gridy = 5;
		c.gridx = 4;
		add(sled, c);	

		
		c = new GridBagConstraints();
		c.gridy = 6;
		c.gridx = 4;
		add(new JLabel("polja za vpis, 2,3=koedinate.4,5=kitrost.6,7=naboj,masa"));


		

		
	}

	}

	



