import java.util.ArrayList;
import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numCasosPrueba = sc.nextInt(); sc.nextLine();
	
		
		for (int x = 0; x < numCasosPrueba; x++) {
			int sumaDiagonal = 0;
			int numFilasRepetidas = 0;
			int numColumnasRepetidas = 0;
			int tamanyoMatriz = sc.nextInt(); sc.nextLine();
			
			int [][] matriz = new int [tamanyoMatriz][tamanyoMatriz];
			
			for (int i = 0; i < tamanyoMatriz; i++) {
				for (int j = 0; j < tamanyoMatriz; j++) {
					 matriz[i][j] = sc.nextInt();
					 if (i == j) {
							sumaDiagonal = sumaDiagonal + matriz[i][j];
						}
				}
			}
			
			boolean contiene;
			for (int i = 0; i < tamanyoMatriz; i++) {
				contiene = false;
				for (int j = 0; j < tamanyoMatriz-1 && !contiene; j++) {
					for (int k = j+1; k < tamanyoMatriz; k++) {
						if (matriz[i][j] == matriz[i][k]) {
							numFilasRepetidas++;
							contiene = true;
							break;
						}
					}
					
				}
			}
			
			for (int i = 0; i < tamanyoMatriz; i++) {
				contiene = false;
				for (int j = 0; j < tamanyoMatriz-1 && !contiene; j++) {
					for (int k = j+1; k < tamanyoMatriz; k++) {
						if (matriz[j][i] == matriz[k][i]) {
							numColumnasRepetidas++;
							contiene = true;
							break;
						}
					}
					
				}
			}
			
			System.out.println("Case #" + (x+1) + ": " + sumaDiagonal + " " + numFilasRepetidas + " " + numColumnasRepetidas );
			
		}

	}

}
