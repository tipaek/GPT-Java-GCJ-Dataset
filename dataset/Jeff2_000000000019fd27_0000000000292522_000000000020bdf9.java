import java.util.*;
import java.io.*;

public class Solution {
		public static class Persona{
		public boolean ocupado;
		public int horaMen, horaMay;
		public Persona(boolean ocupado, int horaMen, int horaMay) {
			super();
			this.ocupado = ocupado;
			this.horaMen = horaMen;
			this.horaMay = horaMay;
		}
		
		public boolean isBussy (String i,String f) {
			int inicio = Integer.parseInt(i);
			int fin = Integer.parseInt(f);		
			if(inicio>this.horaMen&&inicio<this.horaMay||fin>this.horaMen&&fin<this.horaMay)return true;
			else {
				this.horaMay=fin;
				this.horaMen=inicio;
				return false;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer linea;
		int casos = Integer.parseInt(entrada.readLine());
		int tareas=0;
		String salida="";
		Persona cameron ;
		Persona jaime ;
		String in="";
		String fi="";
		boolean salir=false;
		for (int i = 0; i < casos; i++) {
			cameron=new Persona(false, 0, 0);
			jaime=new Persona(false, 0, 0);
			tareas = Integer.parseInt(entrada.readLine());
			for (int j = 0; j < tareas; j++) {
				linea= new StringTokenizer(entrada.readLine());
				in=linea.nextToken();
				fi=linea.nextToken();
				if (!salir) {
				if(cameron.isBussy(in,fi)) {
					if (jaime.isBussy(in, fi)) {
						salida="IMPOSSIBLE";
						salir = true;
						
					}else {
						jaime=new Persona(true,Integer.parseInt(in),Integer.parseInt(fi));
						salida+="J";
					}
				}else {
					salida+="C";
				}
			}
			}
			System.out.println("Case #"+(i+1)+": "+ salida);
			salida="";
			salir=false;
		}

	}

}
