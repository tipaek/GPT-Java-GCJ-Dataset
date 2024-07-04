import java.util.*;
import java.io.*;	

public class Solution {

	
	 static int minutosRestantesCameron = 1440;
	 static int minutosRestantesJamie = 1440;
	 
	 static int numeroActividadesCameron = 0;
	 static int numeroActividadesJamie = 0;
	 static String asignaciones = "";
	
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
	    	 
	    	 String[] actividadesCameron = new String[numeroActividades];
	    	 String[] actividadesJamie = new String[numeroActividades];
	    	 
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
		    			 incluido = comprobarActividad(actividadesCameron, 
		    					 		tiempoInicio, 
		    					 		tiempoFin, 
		    					 		tiempoActividad, 'C');
		    		 }
		    		 if(!incluido && tiempoActividad <= minutosRestantesJamie) {
		    			 incluido = comprobarActividad(actividadesJamie, 
	 					 		tiempoInicio, 
	 					 		tiempoFin, 
	 					 		tiempoActividad, 'J');
		    		 }
	    		 }else {
	    			 if(!incluido && tiempoActividad <= minutosRestantesJamie) {
		    			 incluido = comprobarActividad(actividadesJamie, 
	 					 		tiempoInicio, 
	 					 		tiempoFin, 
	 					 		tiempoActividad, 'J');
		    		 }
	    			 
	    			 if(!incluido && tiempoActividad <=	 minutosRestantesCameron) {
		    			 incluido = comprobarActividad(actividadesCameron, 
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
	    	 
	    	 for(int i = 0;i < numeroActividades - actividad;i++) {
	    		 entrada.nextLine();
	    	 }
	    	 
	    	 resultado += " "+asignaciones;
	    	 
	    	 System.out.println(resultado);
		 }
		 
	}
	 
	 public static boolean comprobarActividad(
			 String[] actividadesPersona,
			 int tiempoInicio,
			 int tiempoFin,
			 int tiempoActividad,
			 char persona
			 ) {
		 boolean incluido = false;
		 boolean huecoOcupado = false;
		 int numeroActividades = persona == 'C'?numeroActividadesCameron:numeroActividadesJamie;
		 
		 for(int i = 0;i < numeroActividades;i++){
			 String rango = actividadesPersona[i];
			 String[] valores = rango.split("_");
			 int rangoInferior = Integer.parseInt(valores[0]);
			 int rangoSuperior = Integer.parseInt(valores[1]);
			 if(
					 !(tiempoFin <= rangoInferior
					 || tiempoInicio >= rangoSuperior)
					 
			) {
				 huecoOcupado = true;
				 break;
			 }
		 }
		 
		 if(!huecoOcupado) {
			 incluido = true;
			 if(persona == 'C') {
				 minutosRestantesCameron -= tiempoActividad;
				 actividadesPersona[numeroActividadesCameron] = tiempoInicio+"_"+tiempoFin;
				 numeroActividadesCameron++;
			 }else {
				 minutosRestantesJamie -= tiempoActividad;
				 actividadesPersona[numeroActividadesJamie] = tiempoInicio+"_"+tiempoFin;
				 numeroActividadesJamie++;
			 }
			 asignaciones += persona; 
		 }
		 return incluido;
	 }
}
