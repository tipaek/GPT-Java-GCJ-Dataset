import java.util.*;
import java.io.*;


public class Solution {

	 public static void main(String[] args) {

		/*Scanner entrada = null;
		try {
			entrada = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Scanner entrada = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int casos = entrada.nextInt();
	    for (int caso = 1; caso <= casos; caso++) {
	    	 String resultado = "Case #"+caso+":";
	    	 int tam = entrada.nextInt();
	    	 
	    	 int repetidosFila = 0;
			 int repetidosColumna = 0;
			 int sumaDiagonal = 0;
			 
			 String[] cadenasNumerosColumna = new String[tam];
			 Boolean[] encontradosNumerosColumna = new Boolean[tam];
	    	 
			 for(int fila = 0;fila < tam;fila++) {
				 String cadenaNumerosFila = "-";
				 boolean encontradoFila = false;
				 for(int columna = 0;columna < tam ; columna++) {
					 if(cadenasNumerosColumna[columna] == null){
						 encontradosNumerosColumna[columna] = false;
						 cadenasNumerosColumna[columna] = "-";
					 }
					 int valor = entrada.nextInt();
					 
					 if(fila == columna){
						 sumaDiagonal += valor; 
					 }
					 
					 if(!encontradoFila){
						 if(cadenaNumerosFila.contains("-"+valor+"-")) {
							 encontradoFila = true;
							 repetidosFila++;
						 }else{
							 cadenaNumerosFila += valor+"-";
						 } 
					 }
					 
					 if(!encontradosNumerosColumna[columna]){
						 if(cadenasNumerosColumna[columna].contains("-"+valor+"-")){
							 encontradosNumerosColumna[columna] = true;
							 repetidosColumna++;
						 }else {
							 cadenasNumerosColumna[columna]+= valor+"-";
						 } 
					 }
					 
				 }
			 }
			
	    	 resultado +=  " "+sumaDiagonal+" "+repetidosFila+" "+repetidosColumna;
	    	 
	    	 System.out.println(resultado);
	    }
	    entrada.close();
	 }
}
