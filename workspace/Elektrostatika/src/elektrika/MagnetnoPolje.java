package elektrika;

import java.awt.Graphics;

public class MagnetnoPolje {
	public double B;
	public MagnetnoPolje(double B){
		this.B=B;
	}
	public void narisi(Graphics g) {
		if(B!=0){
		g.drawOval(100,100,15,15);
		g.drawOval(1100,100,15,15);
		g.drawOval(100,600,15,15);
		
		g.drawOval(1100,600,15,15);
		
		g.drawOval(100,350,15,15);
		g.drawOval(1100,350,15,15);
		if(B>0){
			g.fillOval(105,105,5,5);
			g.fillOval(1105,105,5,5);
			g.fillOval(105,605,5,5);
			g.fillOval(1105,605,5,5);
			g.fillOval(105,355,5,5);
			g.fillOval(1105,355,5,5);
		}
		else{
			g.drawLine(100,100,115,115);
			g.drawLine(100,115,115,100);
			
			g.drawLine(1100,100,1115,115);
			g.drawLine(1100,115,1115,100);
			
			g.drawLine(100,600,115,615);
			g.drawLine(100,615,115,600);

			g.drawLine(1100,600,1115,615);
			g.drawLine(1100,615,1115,600);

			g.drawLine(100,350,115,365);
			g.drawLine(100,365,115,350);

			g.drawLine(1100,350,1115,365);
			g.drawLine(1100,365,1115,350);

		}
		}
		
		}

}


