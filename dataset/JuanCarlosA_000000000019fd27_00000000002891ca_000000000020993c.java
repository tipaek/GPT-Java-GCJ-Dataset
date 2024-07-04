import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> lista;
		int trace, filas, col, x;
		int y = sc.nextInt();
		int[][] matriz;		
		
		for (int i = 0; i < y; i++) {
			
			x = sc.nextInt();
			
			trace = 0;
			filas = 0;
			col = 0;
			matriz = new int[x][x];
			
			for (int j = 0; j < x; j++) {

				lista = new HashSet<Integer>();
				
				for (int j2 = 0; j2 < x; j2++) {
					
					matriz[j][j2] = sc.nextInt();
					lista.add(matriz[j][j2]);
					
					if (j == j2) trace += matriz[j][j2];
				}
				
				if (lista.size() != x) filas++;
				
			}
			
			for (int j = 0; j < matriz.length; j++) {

				lista = new HashSet<Integer>();
				
				for (int j2 = 0; j2 < matriz.length; j2++) {
					
					lista.add(matriz[j2][j]);
				}
				
				if(lista.size() != matriz.length) col++;
			}
			
			
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + filas + " " + col);
			
			
		}

	}

}
