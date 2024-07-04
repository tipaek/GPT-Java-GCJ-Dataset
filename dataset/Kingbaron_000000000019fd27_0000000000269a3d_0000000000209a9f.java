import java.util.*;
import java.io.*;	

public class Solution {

	 public static void main(String[] args) {

		
		Scanner entrada = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int casos = entrada.nextInt();
		 for (int caso = 1; caso <= casos; caso++) {
	    	 String resultado = "Case #"+caso+":";
	    	 String nuevaCadena = "";
	    	 String cadenaCaso = entrada.next();
	    	 int i = 0;
	    	 int parentesisCerrar = Character.getNumericValue(cadenaCaso.charAt(0));
	    	 int digitoAnterior = Character.getNumericValue(cadenaCaso.charAt(0));
	    	 int tamCadena = cadenaCaso.length();
	    	 while(i < tamCadena) {
	    		 int digito = Character.getNumericValue(cadenaCaso.charAt(i));
    			 if(nuevaCadena == "") {
    				 for(int j = 0; j< digito;j++) {
    					 nuevaCadena +="(";
    				 }
    			 }
	    		 
	    		 
	    		 if(digito != digitoAnterior ) {
	    			 if(digito > parentesisCerrar) {
	    				 
	    				 for(int j = 0; j< digito -parentesisCerrar;j++) {
	    					 nuevaCadena +="(";
	    				 }
	    				 nuevaCadena +=digito;
	    				 digitoAnterior = digito;
	    				 parentesisCerrar = digito;
	    			 }else {
	    				 for(int j = 0; j< digitoAnterior -digito;j++) {
	    					 nuevaCadena +=")";
	    					 parentesisCerrar--;
	    				 }
	    				 nuevaCadena +=digito;
	    				 digitoAnterior = digito;
	    			 }
	    			
    			 }else {
    				 nuevaCadena +=digito;
    			 }
	    		 
	    		 if(i == tamCadena -1) {
    				 for(int j = 0; j< parentesisCerrar;j++) {
    					 nuevaCadena +=")";
    				 }
    			 }
    			 
	    		 i++;
	    	 }
	 
	    	 resultado += nuevaCadena;
	    	 
	    	 System.out.println(resultado);
		 }
		 
	}
}
