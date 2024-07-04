import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Book {

	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String linea;
			String columnas[];
			String filas="";
			int k=0;
			int r=0;
			int c=0;
			linea=br.readLine();
			int limite=Integer.parseInt(linea);
			for(int n=1;n<=limite;n++) {
			    linea=br.readLine();
				String datos[] = linea.split(" ");
				int n1 = Integer.parseInt(datos[0]);
				int n2 = Integer.parseInt(datos[1]);
				columnas=new String[n2];
				k=0;
				r=0;
				c=0;
				for(int i=0; i<n1; i++) {
					linea=br.readLine();
					String dato[] = linea.split(" ");
					filas="";
					for(int j=0; j<n2; j++) {
						if(filas.equals("f")==false&&filas.contains(dato[j])==true) {
							r++;
					        filas="f";
					       }else  if(filas.equals("f")==false&&filas.contains(dato[j])==false){
					    	   filas=filas+dato[j];
					       }
						if( columnas[j]!=null&&columnas[j].equals("f")==false&&columnas[j].contains(dato[j])==true) {
							c++;
					        columnas[j]="f";
					       }else if(columnas[j]==null|| columnas[j].equals("f")==false&&columnas[j].contains(dato[j])==false) {
					    	   columnas[j]=columnas[j]+dato[j];
					       }
						if(j==i) {
							k=k+Integer.parseInt(dato[j]);
						}
						
						
					}	
				}
				System.out.println("Case # "+n+": "+k+" "+r+" "+c);
				
				
				

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
}
