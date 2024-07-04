package codejam;

import java.util.Arrays;
import java.util.Scanner;

class Vestigium{

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		String[] output = new String[testCases];
//		System.out.println(testCases);
		for (int a = 1; a <= testCases; a++) {
			int matrixSize = Integer.parseInt(in.nextLine());
			int[][] matrix = new int[matrixSize][matrixSize];
			for (int i = 0; i < matrixSize; i++) {
				String[] inputLine = (in.nextLine()).split(" ");
				for (int j = 0; j < matrixSize; j++) {
					matrix[i][j] = Integer.parseInt(inputLine[j]);
				}

			}
			// Trace
			int trace = 0;
			for (int k = 0; k < matrixSize; k++) {
				trace = trace + matrix[k][k];
			}
			// rows of the matrix that contain repeated elements
			int r = 0;
			for (int[] row : matrix) {
				boolean flag=false;
				for (int i = 0; i < matrixSize; i++) {
					if(flag==false) {
						for (int j = i + 1; j < matrixSize; j++) {
							if (row[i] == row[j]) {
								r = r + 1;
								flag=true;
								break;
							}
						}
					}
				}
			}

			// columns of the matrix that contain repeated elements
			int c = 0;
			int[][] matrixT = new int[matrixSize][matrixSize];
			for (int i = 0; i < matrixSize; i++) {
				for (int j = 0; j < matrixSize; j++) {
					matrixT[i][j] = matrix[j][i];
				}
			}

			for (int[] col : matrixT) {
				boolean flag=false;
					for (int i = 0; i < matrixSize; i++) {
						if(flag==false) {
							for (int j = i + 1; j < matrixSize; j++) {
								if (col[i] == col[j]) {
									c = c + 1;
									flag=true;
									break;
								}
							}
						}
						
					}				
			}

			// Output

			output[a-1]="Case #" + a + ": " + trace + " " + r + " " + c;

		}
		for(String out : output) {
			System.out.println(out);
		}

	}

}
