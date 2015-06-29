import elektrika.Elektron;
import elektrika.Crta;
import elektrika.MagnetnoPolje;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Platno extends JPanel implements ActionListener {
	private Vector<Elektron> elektroni;
	private Vector<Elektron> vig;
	private Vector<Crta> crte;
	//to so crte ki bodo stalno na platnu
	private Vector<Crta> stalnecrte;
	private MagnetnoPolje b;
	public Timer cajt = new Timer(10, this);	
	public int premor=0;
	public JButton konec;
	public JButton magnet;
	public JTextField magnetnopolje;
	public JTextField xkord;
	public JTextField ykord;
	public JTextField xsmer;
	public JTextField ysmer;
	public JTextField el;

	//e je naboj m je masa
	public JTextField m;
	//public Crta crta;
	public JButton proton;
	public JButton zbris;
	public JButton sled;
	public int sledi;
	public Platno(){
		super();
		this.elektroni= new Vector<Elektron>();
		//vig je pomzen vektor za izvajanje operacije
		this.vig= new Vector<Elektron>();
		this.crte=new Vector<Crta>();
		this.b=new MagnetnoPolje(0);
		setBackground(Color.WHITE);	
		this.konec=new JButton("play/pause");
		this.magnet=new JButton("spremeni magnetnopolje polje");
		this.magnetnopolje=new JTextField();

		this.xkord=new JTextField();
		this.ykord=new JTextField();
		this.xsmer=new JTextField();
		this.ysmer=new JTextField();
		this.el=new JTextField();
		this.m=new JTextField();
		this.proton=new JButton("novdelec");
		this.zbris=new JButton("zbrisi vse");
		this.sled=new JButton("vklopi sled");
		this.sledi=1;
		//stalne crte so crne crte na ekranu
		this.stalnecrte=new Vector<Crta>();
		Crta t1=new Crta(100,0,100,700,0);
		stalnecrte.add(t1);
		Crta t2=new Crta(200,0,200,700,0);
		stalnecrte.add(t2);
		Crta t3=new Crta(300,0,300,700,0);
		stalnecrte.add(t3);
		Crta t4=new Crta(400,0,400,700,0);
		stalnecrte.add(t4);
		Crta t5=new Crta(500,0,500,700,0);
		stalnecrte.add(t5);
		Crta t6=new Crta(600,0,600,700,0);
		stalnecrte.add(t6);
		Crta t7=new Crta(700,0,700,700,0);
		stalnecrte.add(t7);
		Crta t8=new Crta(800,0,800,700,0);
		stalnecrte.add(t8);
		Crta t9=new Crta(900,0,900,700,0);
		stalnecrte.add(t9);
		Crta t10=new Crta(1000,0,1000,700,0);
		stalnecrte.add(t10);
		Crta t11=new Crta(1100,0,1100,700,0);
		stalnecrte.add(t11);
		Crta w1=new Crta(0,100,1200,100,0);
		stalnecrte.add(w1);
		Crta w2=new Crta(0,200,1200,200,0);
		stalnecrte.add(w2);
		Crta w3 =new Crta(0,300,1200,300,0);
		stalnecrte.add(w3);
		Crta w4 =new Crta(0,400,1200,400,0);
		stalnecrte.add(w4);
		Crta w5 =new Crta(0,500,1200,500,0);
		stalnecrte.add(w5);
		Crta w6 =new Crta(0,600,1200,600,0);
		stalnecrte.add(w6);

	}
	
	
	
	public void dodajelektron(Elektron elektron) {
		this.elektroni.add(elektron);
	}
	public void dodajcrto(Crta crta) {
		this.crte.add(crta);
	}
	public void povecajpolje(double h){
		this.b.B=h*0.001;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Elektron elektron : this.elektroni) {
			if(elektron.naboj>0){
			g.setColor(Color.BLUE);}
			else{
				if(elektron.naboj==0){
					g.setColor(Color.BLACK);
					
				}
				else{
					g.setColor(Color.RED);
				}
			}
			elektron.narisi(g);
			for (Crta crta : this.crte) {
				if(crta.naboj>0){
				g.setColor(Color.BLUE);
				}
				else{
					if(crta.naboj==0){
						g.setColor(Color.BLACK);
					}
					else{
						g.setColor(Color.RED);
					}
				}
				
				crta.narisi(g);
			}
			
		}
		for (Crta rta : this.stalnecrte) {
			if(rta.naboj>0){
			g.setColor(Color.BLUE);
			}
			else{
				if(rta.naboj==0){
					g.setColor(Color.BLACK);
				}
				else{
					g.setColor(Color.RED);
				}
			}
			
		rta.narisi(g);
		
		
	}
	g.setColor(Color.BLACK);
	b.narisi(g);

}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1200, 700);}
//	public void sprememba()


	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==cajt){
			vig.removeAllElements();
			for(Elektron elektron:this.elektroni){
				vig.add(elektron);
			}
			for(Elektron elektron:this.elektroni){
				double x=elektron.x;
				double y=elektron.y;
				for(Elektron u:vig){
					if(vig.indexOf(u)!=elektroni.indexOf(elektron)){
						double r=Math.sqrt(Math.pow(x-u.x,2)+Math.pow(y-u.y,2));
						if(r<=20+Math.log((10+elektron.masa)*(10+u.masa))){
							elektron.naboj=(elektron.naboj+u.naboj)/2;
							elektroni.elementAt(vig.indexOf(u)).naboj=elektron.naboj;
							u.naboj=(elektron.naboj+u.naboj)/2;
													
							//ne pozabim na gibalno kolicino
							elektron.vx=(elektron.vx*elektron.masa+u.vx*u.masa)/(elektron.masa);
							elektron.vy=(elektron.vy*elektron.masa+u.vy*u.masa)/(elektron.masa);
							elektroni.elementAt(vig.indexOf(u)).vx=(elektron.vx*elektron.masa+u.vx*u.masa)/(u.masa);
							elektroni.elementAt(vig.indexOf(u)).vy=(elektron.vy*elektron.masa+u.vy*u.masa)/(u.masa);
						}
						double es=elektron.naboj*u.naboj;
						//0,03sje cas v=f*t/m enota je cm na sekundo masa je v gramih
						elektron.vx+=(3000/elektron.masa)*((es*(elektron.x-u.x))/(8.85*4*3.14*r*r*r));
						elektron.vy+=(3000/elektron.masa)*((es*(elektron.y-u.y))/(8.85*4*3.14*r*r*r));
					}	
				elektron.vx=elektron.vx+elektron.vy*b.B*elektron.naboj*(1/elektron.masa);
				elektron.vy=elektron.vy-elektron.vx*b.B*elektron.naboj*(1/elektron.masa);				
				elektron.x=elektron.x+elektron.vx;
				elektron.y=elektron.y+elektron.vy;
				if(sledi==1){
				Crta c =new Crta(x,y,elektron.x,elektron.y,elektron.naboj);
				dodajcrto(c);
				
				
				}

				
				//System.out.println(elektron.vx);
				//System.out.println(elektron.vy);
				}
				
		
				
			
			if (elektron.x>1200-10-Math.log(1+elektron.masa)){
				elektron.vx=-elektron.vx;
			}
			if(elektron.x<10+Math.log(1+elektron.masa)){
				elektron.vx=-elektron.vx;
			}
			if (elektron.y>700-10-Math.log(1+elektron.masa)){
				elektron.vy=-elektron.vy;
			}
			if(elektron.y<10+Math.log(1+elektron.masa)){
				elektron.vy=-elektron.vy;
			}
			
		}
			
		repaint();
		}
		else{
			if(e.getSource()==konec)
			pavza();
			else{
				if(e.getSource()==magnet){
					try{
					povecajpolje(Double.parseDouble(magnetnopolje.getText()));
					} catch(NumberFormatException exception){
						povecajpolje(0);
					}
					
				}
				else{
					if (e.getSource()==proton){
						try{
						novdelec(Double.parseDouble(xkord.getText()),Double.parseDouble(ykord.getText()),Double.parseDouble(xsmer.getText()),Double.parseDouble(ysmer.getText()),Double.parseDouble(el.getText()),Math.abs(Double.parseDouble(m.getText())));
						} catch(NumberFormatException exception){
							povecajpolje(b.B);
						}
						}
					else{
						if(e.getSource()==zbris){
							elektroni.removeAllElements();
							crte.removeAllElements();
						}
						else{
							if(e.getSource()==sled){
								if(sledi==1){
									sledi=0;
									crte.removeAllElements();
									
								}
								else{
									sledi=1;
									
								}
							}
						}
					}
				}
			}
		}

		
}
	public void novdelec(double a1,double a2,double a3,double a4, double a5, double a6){
		Elektron r =new Elektron(a1,a2,a3*0.03,a4*0.03,a5,a6);
		dodajelektron(r);
		
	}
	public void pavza(){
		if (premor==0){
			cajt.start();
			premor=1;
		}
		else{
			cajt.stop();
			premor=0;
		}
	}

}


