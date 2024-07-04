import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		for (int i = 0; i < x; i++) {
			
			int a = sc.nextInt();
			
			int Ji = 0, Jf = 0, Ci = 0, Cf = 0, Ai, Af;
			
			String cadena = "";
			boolean posible = true;
			
			char[] asigna = new char[a];
			
			ArrayList<Horario> Actividades = new ArrayList<Horario>();
			
				
				for (int j2 = 0; j2 < a; j2++) {
					Horario a1 = new Horario( sc.nextInt(), sc.nextInt(), j2);
					Actividades.add(a1);
				}
				
				Collections.sort(Actividades);
				
				//System.out.println(Actividades);
				for (int k = 0; k < a; k++) {
					
					Ai = Actividades.get(k).ini;
					Af = Actividades.get(k).fin;
					
					if (Ai >= Jf ) {
						Ji = Ai;
						Jf = Af;
						
						asigna[Actividades.get(k).pos] = 'C';
						
					} else if ( Ai >= Cf ) {
						Ci = Ai;
						Cf = Af;
						
						asigna[Actividades.get(k).pos] = 'J';
					} else {
						posible = false;
					}
				}
				
				
			//	System.out.println(asigna);
			
			
			if (posible) {
				System.out.printf("Case #"+(i+1)+": ");
				for (int j = 0; j < a; j++) {
					System.out.printf(asigna[j] + "");
				}
				System.out.println();
			} else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			
			
		}


	}
	
	public static class Horario implements Comparable<Horario> {

		int ini;
		int fin;
		int pos;

		Horario(int i, int v, int p) {
			this.ini = i;
			this.fin = v;
			this.pos = p;
		}

		@Override
		public int compareTo(Horario a) {
			
			return this.ini - a.ini;

		}
		
		@Override
		public String toString() {
			return "[" + ini + " " + fin + "]";
		}
	}

}
