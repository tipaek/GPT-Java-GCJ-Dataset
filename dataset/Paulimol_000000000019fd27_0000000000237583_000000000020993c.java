import java.io.*;
import java.util.*;

public class Solution {

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
		System.out.println(n);
		
		//Fill Matrix
        for(int j = 0; j < matrix.length; ++j)
        {
            //Read all rows
            for(int k = 0; k < matrix.length && input.hasNext(); ++k)
            {
                //Read row
                int l = input.nextInt();
                matrix[j][k] = l;
                
                System.out.println(matrix[j][k]);

            }
        }

			int trace = 0;
			int repetedRows = 0;
			int repetedColumns = 0;

			// sum of main diagonal
			int k = trace;
			// number of rows repeated elements
			int r = repetedRows;
			// number of columns repeated elements
			int c = repetedColumns;

			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);

		}

	}
}