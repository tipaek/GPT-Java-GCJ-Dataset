import java.io.*;
import java.util.*;

public class Solution {

	public static boolean repeatRow(String integers[]) {
		boolean repetido = false;

		for (int i = 0; i <= integers.length; i++) {
			String number = integers[i];
			int value = Integer.parseInt(number);

			for (int j = 1; i <= integers.length && repetido == false; i++) {
				String number2 = integers[j];
				int value2 = Integer.parseInt(number2);

				if (value == value2) {
					repetido = true;
				}
			}
		}

		return repetido;
	}

	public static boolean repeatColumn(int number1, int number2) {
		boolean repetido = false;
		if (number1 == number2) {
			repetido = true;
		}

		return repetido;
	}

	public static void main(String[] args) {

		// Input
		Scanner input = new Scanner(System.in);

		// Number of test cases
		int t = input.nextInt();

		for (int i = 1; i <= t; ++i) {
			// Size of the matrix
			int n = input.nextInt();

			// Matriz nxn
			int[][] matrix = new int[n][n];

			int trace = 0;
			int repetedRows = 0;
			int repetedColumns = 0;

			// Fill the matrix
			for (int j = 0; j < matrix.length; j++) {

            while(input.hasNext()){
                
				String rows = input.nextLine();
				String integers[] = rows.split(" ");
				int contador = 0;

				if (repeatRow(integers) == true) {
					repetedRows += 1;
				}

				// columna
				for (int k = 0; k < matrix[j].length; k++) {
					matrix[j][k] = Integer.parseInt(integers[j]);

					if (j == k) {
						int value = matrix[j][k];
						trace += value;
					}
					// System.out.printf("%4d", matrix[j][k]);
					for (int m = 1; k < matrix[j].length; k++) {
						
						int number1 = matrix[j][k];
						int number2 = matrix[m][k];

						if (number1 == number2) {
							contador += 1;
						}
					}
					
				}

				if (contador > 0) {
					repetedColumns += 1;
				}
				// System.out.println();

			}

			// Suma de los valores en la diagonal principal
			int k = trace;

			// number of rows with repeated elements
			int r = repetedRows;

			// number of columns repeated elements
			int c = repetedColumns;

			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
		
			}
		}
	}
}