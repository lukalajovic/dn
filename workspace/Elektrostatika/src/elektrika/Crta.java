package elektrika;

import java.awt.Graphics;

public class Crta {
	public double zacx;
	public double zacy;
	public double konecx;
	public double konecy;
	public double naboj;
	
	public Crta(double x, double y, double x2, double y2,double naboj) {
		super();
		this.konecx = x2;
		this.konecy = y2;
		this.zacx=x;
		this.zacy=y;
		this.naboj=naboj;
	}





	public void narisi(Graphics g) {
		g.drawLine((int)(zacx), (int)(zacy), (int)(konecx), (int)(konecy));
	}

}

