import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int j=0; j<n; j++) {
            		for(int k=0; k<n; k++) {
            			matrix[j][k] = in.nextInt();
            		}            		
            }
            int[] sol = getSol(matrix);
            sb.append("Case #" + i + ": " + sol[0] + " " + sol[1] + " " + sol[2] +"\r\n");
        }
        System.out.println(sb);
    }

	public static int[] getSol(int[][] matrix) {
		int[] sol = new int[3];
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			Set<Integer> row = new HashSet<>();
			Set<Integer> column = new HashSet<>();
			boolean r = false;
			boolean c = false;
			for (int j = 0; j < n; j++) {
				if (i == j)
					sol[0] += matrix[i][j];
				if (row.contains(matrix[i][j]))
					r = true;
				row.add(matrix[i][j]);
				if (column.contains(matrix[j][i]))
					c = true;
				column.add(matrix[j][i]);
			}

			if (r)
				sol[1]++;
			if (c)
				sol[2]++;
		}

		return sol;
	}

}
