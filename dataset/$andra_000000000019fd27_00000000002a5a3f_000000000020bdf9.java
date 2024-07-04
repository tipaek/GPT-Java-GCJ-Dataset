import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String horario;
	static String cameron;
	static String jamie;
	static int s=0;
	static int e=0;
	static int inicio=0;
	static int termina=0;
	static int cantidadjamie;
	static int cantidadcameron;
	static String minutos[];
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String linea;
			linea=br.readLine();
			int limite=Integer.parseInt(linea);
			for(int n=1;n<=limite;n++) {
				linea=br.readLine();
				cameron="f";
				jamie="f";
			    cantidadjamie=0;
			    cantidadcameron=0;
			    horario="";
			    int actividades=Integer.parseInt(linea);
				for(int i=0;i<actividades;i++) {
					linea=br.readLine();
					minutos = linea.split(" ");
					s=Integer.parseInt(minutos[0]);
					e=Integer.parseInt(minutos[1]);
					if(jamie=="f") {
						jamie=minutos[0]+" "+minutos[1]+" ";
						horario=horario+"J";
						cantidadjamie++;
					}else if(evaluarJamie()==false) {
						if (cameron=="f") {
							cameron=minutos[0]+" "+minutos[1]+" ";
							horario=horario+"C";
							cantidadcameron++;
						}else if(evaluarCameron()==false) {
							horario="IMPOSSIBLE";
						}else if(evaluarCameron()==true){
							 cameron=cameron+minutos[0]+" "+minutos[1]+" ";
							 cantidadcameron++;
							 horario=horario+"C";
						}
					}else if(evaluarJamie()==true){
						jamie=jamie+minutos[0]+" "+minutos[1]+" ";
						cantidadjamie++;
						horario=horario+"J";
						
					}
								
								
							}
				System.out.println("Case #"+n+": "+horario);
						}	
					
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static  boolean evaluarCameron() {
		int m=0;
				String vercameron[]=cameron.split(" ");
				for(int j=0;j<cantidadcameron*2;j=j+2) {
					m=j+1;
					inicio=Integer.parseInt(vercameron[j]);
					termina=Integer.parseInt(vercameron[m]);
					if((s<inicio&&e>inicio)||(s>inicio&&s<termina)) {
							return false;				
				             } 
		             }
		   return true;
			}
   public static boolean evaluarJamie() {
	   boolean dato=true;
			String verjamie[]=jamie.split(" ");
			int m=0;
			for(int j=0;j<cantidadjamie*2;j=j+2) {
				m=j+1;
				inicio=Integer.parseInt(verjamie[j]);
				termina=Integer.parseInt(verjamie[m]);
				if((s<inicio&&e>inicio)||(s>inicio&&s<termina)) {
					dato= false;
					}
					 
	             }
	             
	   return dato;
		}
   
}
   