package elektrika;

import java.awt.Graphics;

public class Elektron {
	
	public double x;
	public double y;
	public double vx;
	public double vy;
	public double naboj;
	public double masa;
	//tole je konstruktor telesa
	public Elektron(double x,double y, double vx,double vy, double naboj, double masa){
		super();
		this.x=x;
		this.y=y;
		this.vx=vx;
		this.vy=vy;
		this.naboj=naboj;
		this.masa=masa;
	}
	public void narisi(Graphics g) {
		g.fillOval((int) (x)-(int)(10+Math.log(masa+1)), (int) (y)-(int)(10+Math.log(masa+1)), 2*(int)(10+Math.log(masa+1)),2*(int)(10+Math.log(masa+1)));}

}
