import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static String resultTest;

	static final String POSSIBLE = "POSSIBLE";
	static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// one line with a number of test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		// boucle for testCases #x = i
		for (int itc = 1; itc <= t; ++itc) {
			int n = in.nextInt(); // N size de la matriz
			int k = in.nextInt(); // K sum de la traza

			// Init matrix
			int[][] matrix = new int[n][n];
			
			// Control
			if (k < n || k > n * n) {
				setResultTest(IMPOSSIBLE);
			} else if (k % n != 0) {
				// Empiric
				setResultTest(IMPOSSIBLE);
			} else {
				setResultTest(POSSIBLE);
				
				// Relleno matriz por columnas
				rellenarMatriz(n, matrix);

				// Tenemos una "latin square". A partir de ahora tenemos que hacer cambios de
				// filas y columnas para obtener los valores que queramos en la diagonal

				int resto = k - sumTraza(matrix);

				/*if (resto % n != 0) {
					System.out.println("Debe haber un problema: resto % n = " + resto % n);
				}
				*/
				// Reordenamos columnas de la matriz
				matrix = cambiaColumnas(matrix, resto);

				//Recalculamos traza
				//int post = k - sumTraza(matrix);
				
				/*if(post != 0) {
					System.out.println("Debe haber un problema:post != 0 -> " + post);
				}*/
			}
			System.out.println("Case #" + itc + ": " + getResultTest());
			if(getResultTest().equals(POSSIBLE)) {
				System.out.println(pintarMatrix(n, matrix));
			}
			
		}
	}

	static String pintarMatrix(int n, int[][] matrix) {
		//pintamos la matriz
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=0;i<n;i++) {
			for(int j=0; j<n; j++) {
				sb.append(matrix[i][j]);
				sb.append(" ");
			}
			if(i!=(n-1)) {
				sb.append("\r\n");
			}
		}
		return sb.toString();
	}

	static int[][] cambiaColumnas(int[][] matrix, int resto) {
		int[][] newMatrix = matrix.clone();
		int n = matrix.length;
		int nCambios = Math.abs(resto / n);

		if (resto < 0) {
			// Cambios asimetricos
			for (int iCambios = 0; iCambios < nCambios; iCambios++) {
				for (int i = 0; i < n; i++) {
					int temp = matrix[i][iCambios + 1];
					newMatrix[i][iCambios + 1] = matrix[i][(n-1) - iCambios];
					newMatrix[i][(n-1) - iCambios] = temp;
				}
			}

		} else if (resto > 0) {
			// Cambios simetricos
			for (int iCambios = 0; iCambios < nCambios; iCambios++) {
				for (int i = 0; i < n; i++) {
					int temp = matrix[i][iCambios];
					newMatrix[i][iCambios] = matrix[i][(n-1) - iCambios];
					newMatrix[i][(n-1) - iCambios] = temp;
					
				}
			}
		}
		return newMatrix;
	}

	private static int sumTraza(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum = sum + matrix[i][i];
		}
		return sum;
	}

	/**
	 * 
	 * @param n
	 * @param matrix
	 */
	static void rellenarMatriz(int n, int[][] matrix) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				int value = i + j - 2 + 1;
				if (value > n) {
					value = value - n;
				}
				matrix[i - 1][j - 1] = value;

			}
			/*
			 * matrix[0][0] = 1; matrix[0][1] = 2; matrix[0][2] = 3;
			 * 
			 * matrix[1][0] = 2; matrix[1][1] = 3; matrix[1][2] = 1;
			 * 
			 * matrix[2][0] = 3; matrix[2][1] = 1; matrix[2][2] = 2;
			 * 
			 * 0-> i+1 1 -> i+2 if>n then i+2-n 2 -> i+3 if>n then i+3-n
			 */

		}
	}

	public static String concatenate(String... s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length; i++)
			sb = sb.append(s[i]);

		return sb.toString();
	}

	public static String getResultTest() {
		return resultTest;
	}

	public static void setResultTest(String result) {
		resultTest = result;
	}

}
