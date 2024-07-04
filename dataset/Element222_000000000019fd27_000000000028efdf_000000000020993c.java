import java.util.LinkedList;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> numeroFila = new LinkedList<>();
		LinkedList<Integer> numeroColumna = new LinkedList<>();
		int cases = sc.nextInt();
		int n;
		int[][] matriz;
		int trace = 0;
		int filas;
		int columnas;
		boolean pasarFila=true;
		boolean pasarColumna=true;
		for (int p = 0; p < cases; p++) {
			trace = 0;
			filas = 0;
			columnas = 0;
			n = sc.nextInt();
			matriz = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matriz[i][j] = sc.nextInt();
					if (i == j) {
						trace=trace+matriz[i][j];
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (numeroFila.contains(matriz[i][j])&&pasarFila) {
						pasarFila=false;
						filas++;						
					} else {
						numeroFila.add(matriz[i][j]);
					}
					if (numeroColumna.contains(matriz[j][i])&&pasarColumna) {
						pasarColumna=false;
						columnas++;						
					} else {
						numeroColumna.add(matriz[j][i]);
					}
				}
				pasarFila=true;
				pasarColumna=true;
				numeroFila.clear();
				numeroColumna.clear();
			}
			System.out.println("Case #" + (p + 1) + ": " + trace + " " + filas + " " + columnas);
		}
	}
}