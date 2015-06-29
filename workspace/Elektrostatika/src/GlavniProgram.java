//import elektrika.Elektron;
public class GlavniProgram {
	public static void main(String[] args){
		GlavnoOkno okno=new GlavnoOkno();
		okno.getPlatno().povecajpolje(0);
		okno.pack();
		okno.setVisible(true);		
	}

}

