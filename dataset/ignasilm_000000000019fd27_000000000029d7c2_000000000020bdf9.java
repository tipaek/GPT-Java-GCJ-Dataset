import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution  {

	public static void main(String args[]) throws Exception {
		
		int testCases = 0;
		String linea = null;
		String IMPOSIBLE = "IMPOSSIBLE";
		int tamany=0;
		ArrayList<List<String>> datosCasos = null;
		int[] agendaC = new int[1440];
		int[] agendaJ = new int[1440];
		
		String resultado = "";
		int empezar = 0;
		int terminar = 0;
		boolean cPuede = true;
		boolean jPuede = true;
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			
			linea = reader.readLine();
			testCases = Integer.parseInt(linea);
			
			for (int testCase=1; testCase <= testCases; testCase++) {
				
				linea = reader.readLine();
				tamany = Integer.parseInt(linea);
				datosCasos = new ArrayList<>();
				
				for (int i=0; i < tamany; i++) {
					linea = reader.readLine();
					datosCasos.add(Arrays.asList(linea.split(" ")));
				}
				
				resultado = "";
				agendaC = new int[1440];
				agendaJ = new int[1440];
				
				for (int i=0; i < tamany; i++) {
					empezar = Integer.parseInt(datosCasos.get(i).get(0));
					terminar = Integer.parseInt(datosCasos.get(i).get(1));
					
					cPuede = true;
					for (int j=empezar; j < terminar; j++) {
						cPuede = cPuede && agendaC[j] == 0;	
					}
					if (cPuede) {
						for (int j=empezar; j < terminar; j++) {
							agendaC[j] = 1;	
						}
						resultado = resultado + "C";
					} else {
						jPuede = true;
						for (int j=empezar; j < terminar; j++) {
							jPuede = jPuede && agendaJ[j] == 0;	
						}
						if (jPuede) {
							for (int j=empezar; j < terminar; j++) {
								agendaJ[j] = 1;	
							}
							resultado = resultado + "J";
						} else {
							resultado = IMPOSIBLE;
						}
					}
					
					
				}
				
				
				if (!resultado.equals(IMPOSIBLE)) {
					boolean esPrimeroC = false;
					boolean esPrimeroJ = false;
					int k=0;
					while (k<1440 && !esPrimeroC && !esPrimeroJ) {
						
						if (agendaC[k] == 1) {
							esPrimeroC = true;
						} else if (agendaJ[k] == 1) {
							esPrimeroJ = true;
						}
						
						k++;
					}
					
					if (esPrimeroJ) {
						resultado = resultado.replaceAll("C", "X");
						resultado = resultado.replaceAll("J", "C");
						resultado = resultado.replaceAll("X", "J");
					}
				}
				
				
				System.out.println("Case #" + testCase + ": " + resultado);
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
