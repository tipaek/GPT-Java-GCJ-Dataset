import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //one line with a number of test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
		//boucle for testCases #x = i
		for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          
          //Map<fila,Set>
    	  Map<Integer,Set> mapFilas = new HashMap<>();
    	  
    	  //Map<columnas,Set>
    	  Map<Integer,Set> mapColumnas = new HashMap<>();

          int traza = 0;
          for(int j = 1; j<=n; j++) {
        	  //Leo las 4 lineas
  
        	  Set<Integer> fila = new HashSet<>();
        	  
        	  for(int kk = 1; kk<=n; kk++) {
        		  //Aqui leo los n numeros de una linea (elemento de columna)
        		  int value = in.nextInt();
        		  fila.add(value);
        		  
        		  Set columna = null;
        		  if(mapColumnas.get(kk)!=null) {
        			  columna = mapColumnas.get(kk);
        			  columna.add(value);
        		  }else {
        			  columna = new HashSet<>();
        			  columna.add(value);
        		  }
        		  mapColumnas.put(kk, columna);
        		  
        		  
        		  //Calculo de traza
        		  if(j==kk) {
        			  traza = traza+value;
        		  }
        		  
        	  }
        	  mapFilas.put(j, fila);
          }
          
        //Calculo final
    	  int r=0;
    	  int c=0;
    	  for(int item=1; item<=n; item++) {
    		  
    		  if(mapFilas.get(item).size()!=n) {
    			  r=r+1;
    		  }
    		  if(mapColumnas.get(item).size()!=n) {
    			  c=c+1;
    		  }
   		  
    	  }
    	  //r = numero de lineas de la matriz que contienen elementos repetidos
    	  //c = numero de columnas que contienen elementos repetidos	  
    	  //k = traza de la matriz

          System.out.println("Case #" + i + ": " + traza + " " + r + " " + c);
        }
		
	}
	
}
