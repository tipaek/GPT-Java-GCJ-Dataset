import java.util.*;
import java.io.*;	

public class Solution {

	
	 static int minutosRestantesCameron = 1440;
	 static int minutosRestantesJamie = 1440;
	 
	 static int numeroActividadesCameron = 0;
	 static int numeroActividadesJamie = 0;
	 static String asignaciones = "";
	 
	 static boolean[] actividadesCameron;
	 static boolean[] actividadesJamie;
	
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
	    	 int numeroActividades = entrada.nextInt();
	    	
	    	 asignaciones = "";
	    	 
	    	 actividadesCameron = new boolean[1441];
	    	 actividadesJamie = new boolean[1441];
	    	 
	    	 minutosRestantesCameron = 1440;
	    	 minutosRestantesJamie = 1440;
	    	 
	    	 numeroActividadesCameron = 0;
	    	 numeroActividadesJamie = 0;
	    	 
	    	 int actividad = 0;
	    	 for(actividad = 0;actividad < numeroActividades;actividad++) {
	    		 int tiempoInicio = entrada.nextInt();
	    		 int tiempoFin = entrada.nextInt();
	    		 int tiempoActividad = tiempoFin - tiempoInicio;
	    		 boolean incluido = false;
	    		 
	    		 if(numeroActividadesCameron <= numeroActividadesJamie) {
	    			 if(!incluido && tiempoActividad <= minutosRestantesCameron) {
		    			 incluido = comprobarActividad(
		    					 		tiempoInicio, 
		    					 		tiempoFin, 
		    					 		tiempoActividad, 'C');
		    		 }
		    		 if(!incluido && tiempoActividad <= minutosRestantesJamie) {
		    			 incluido = comprobarActividad(
	 					 		tiempoInicio, 
	 					 		tiempoFin, 
	 					 		tiempoActividad, 'J');
		    		 }
	    		 }else {
	    			 if(!incluido && tiempoActividad <= minutosRestantesJamie) {
		    			 incluido = comprobarActividad(
	 					 		tiempoInicio, 
	 					 		tiempoFin, 
	 					 		tiempoActividad, 'J');
		    		 }
	    			 
	    			 if(!incluido && tiempoActividad <=	 minutosRestantesCameron) {
		    			 incluido = comprobarActividad(
		    					 		tiempoInicio, 
		    					 		tiempoFin, 
		    					 		tiempoActividad, 'C');
		    		 }
	    		 }
	    		 
	    		 if(!incluido) {
	    			 asignaciones = "IMPOSSIBLE";
	    			 break;
	    		 }
	    			
	    	 }
	    	 
	    	 for(int i = 0;i < (numeroActividades - actividad);i++) {
	    		 if(entrada.hasNextLine()) {
	    			 entrada.nextLine();
	    		 }
	    	 }
	    	 
	    	 resultado += " "+asignaciones;
	    	 
	    	 System.out.println(resultado);
		 }
		 
	}
	 
	 public static boolean comprobarActividad(
			 int tiempoInicio,
			 int tiempoFin,
			 int tiempoActividad,
			 char persona
			 ) {
		 boolean incluido = false;
		 boolean huecoOcupado = true;
		 if(persona == 'C') {
			 if(!actividadesCameron[tiempoInicio] && !actividadesCameron[tiempoFin] ) {
				 huecoOcupado = false;
			 }
		 }else {
			 if(!actividadesJamie[tiempoInicio] && !actividadesJamie[tiempoFin] ) {
				 huecoOcupado = false;
			 }
		 }
		
		 
		 if(!huecoOcupado) {
			 incluido = true;
			 if(persona == 'C') {
				 minutosRestantesCameron -= tiempoActividad;
				 numeroActividadesCameron++;
				 for(int i = tiempoInicio +1;i < tiempoFin-1;i++) {
					 actividadesCameron[i] = true;
				 }
			 }else {
				 minutosRestantesJamie -= tiempoActividad;
				 numeroActividadesJamie++;
				 for(int i = tiempoInicio +1;i <= tiempoFin-1;i++) {
					 actividadesJamie[i] = true;
				 }
			 }
			 asignaciones += persona; 
		 }
		 return incluido;
	 }
}
