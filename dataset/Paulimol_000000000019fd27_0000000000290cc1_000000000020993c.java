import java.io.*;
import java.util.*;

public class Solution {
	
	static int findDuplicatesColumn(int[][] matrix) {

		int total = 0;
		
		for (int col = 0; col < matrix.length; col++) {
		    HashSet<Integer> uniqInp = new HashSet<>();
		    HashSet<Integer> allDup = new HashSet<>();
		    int contador = 0;
		
			for (int row = 0; row < matrix[0].length; row++) {
				if (uniqInp.add(matrix[row][col]))
					// If not duplicate it will add
					continue;
				else {
					// If Duplicate element found, it will come here
					allDup.add(matrix[row][col]);
					contador += 1;
				}
			}
			
			if(contador>=1)
			{
			    total +=1;
			}
			
		}
		
		return total;
	}
	
	static int findDuplicatesRow(int[][] matrix) {

		int total = 0;
		
		for (int row = 0; row < matrix.length; row++) {
		    HashSet<Integer> uniqInp = new HashSet<>();
		    HashSet<Integer> allDup = new HashSet<>();
		    int contador = 0;
		
			for (int col = 0; col < matrix[0].length; col++) {
				if (uniqInp.add(matrix[row][col]))
					// If not duplicate it will add
					continue;
				else {
					// If Duplicate element found, it will come here
					allDup.add(matrix[row][col]);
					contador += 1;
				}
			}
			
			if(contador>=1)
			{
			    total +=1;
			}
			
		}
		
		return total;
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

			// Variables
			int trace = 0;

			// Fill Matrix
			for (int j = 0; j < matrix.length; ++j) {
				// Read all rows
				for (int k = 0; k < matrix.length && input.hasNext(); ++k) {
					// Read row
					int l = input.nextInt();
					matrix[j][k] = l;

					// System.out.println(matrix[j][k]);

					// Sum diagonal
					if (j == k) {
						trace += l;
					}

				}
			}
			
			// sum of main diagonal
			int k = trace;
			// number of rows repeated elements
			int r = findDuplicatesRow(matrix);
			// number of columns repeated elements
			int c = findDuplicatesColumn(matrix);

			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);

		}
	}
}