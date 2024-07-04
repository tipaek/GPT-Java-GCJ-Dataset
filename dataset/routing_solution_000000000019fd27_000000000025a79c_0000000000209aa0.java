import java.util.*;
import java.io.*;

public class Solution {

	static int[][] printLatin(int n) {

		// A variable to control the
		// rotation point.
		int k = n + 1;
		int matrix[][] = new int[n][n];
		int counter = 0;

		// Loop to store rows
		for (int i = 1; i <= n; i++) {

			// This loops runs only after
			// first iteration of outer
			// loop. It stored
			// numbers from n to k
			int temp = k;

			while (temp <= n) {
				matrix[counter / n][counter % n] = temp;
				counter++;

				temp++;
			}

			// This loop store numbers from
			// 1 to k-1.
			for (int j = 1; j < k; j++) {
				matrix[counter / n][counter % n] = j;
				counter++;
			}

			k--;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		return matrix;
	}

	public static int[][] swapRows(int array[][], int rowA, int rowB) {
		int tmpRow[] = array[rowA];
		array[rowA] = array[rowB];
		array[rowB] = tmpRow;
		return array;
	}

	public static void main(String[] args) {

		int testCase, testCounter = 1;

		Scanner inputScanner = new Scanner(System.in);

		testCase = inputScanner.nextInt();

		while (testCounter <= testCase) {
			int N, K;

			N = inputScanner.nextInt();
			K = inputScanner.nextInt();

			System.out.println();
			int result[][] = printLatin(N);
			System.out.println();

			boolean isFound = false;
			int swappedResult[][] = new int[N][N];
			for (int i = 0; i < (result.length - 1); i++) {
				for (int j = i + 1; j < result.length; j++) {
					swappedResult = swapRows(result, i, j);
					int total = 0;
					for (int l = 0; l < swappedResult.length; l++) {
						total += swappedResult[l][l];
						if(total == K) {
							isFound = true;
							break;
						}
					}
				}
			}
			
			if (isFound == true) {
				System.out.println("Case #"+testCounter+": POSSIBLE");
				for (int i = 0; i < swappedResult.length; i++) {
					for (int j = i + 1; j < swappedResult.length; j++) {
						System.out.print(swappedResult[i][j] +" ");
					}
					System.out.println();
				}
					
			}else {
				System.out.println("Case #"+testCounter+": IMPOSSIBLE");
			}
			
			testCounter++;
		}
	}
}
