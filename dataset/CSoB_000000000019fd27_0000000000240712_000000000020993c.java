import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		
		for (int x = 1; x <= t; ++x) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			in.nextLine();
			for (int i = 0; i<n; i++) {
				String matrixRow = in.nextLine();
				String[] matrixRowS = matrixRow.split(" ");
				for (int j=0; j<n; j++) {
					matrix[i][j] = Integer.parseInt(matrixRowS[j]);
				}
			}

			int k=0, r = 0, c = 0;
			for (int i =0; i<n; i++) {
				k += matrix[i][i];
			}
			
			for (int i = 0; i <n; i++) {
				Set<Integer> rowElement = new HashSet<>();
				for (int j = 0; j <n; j++) {
					if (rowElement.contains(matrix[i][j])) {
						r++;
						break;
					}
					rowElement.add(matrix[i][j]);
				}
			}
			
			for (int j = 0; j <n; j++) {
				Set<Integer> columnElement = new HashSet<>();
				for (int i = 0; i <n; i++) {
					if (columnElement.contains(matrix[i][j])) {
						c++;
						break;
					}
					columnElement.add(matrix[i][j]);
				}
			}

			System.out.println("Case #" + x + ": " + k + " " + r + " " + c );
		}
	}
}