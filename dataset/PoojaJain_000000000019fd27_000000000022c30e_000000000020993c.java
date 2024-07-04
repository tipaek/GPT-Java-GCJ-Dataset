

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int noOfTestCases = in.nextInt();
		StringBuilder ans = new StringBuilder();
		
		for (int i = 0; i < noOfTestCases; i++) {

			int sizeOfMatrix = in.nextInt();
			int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
			int trace = 0, repeatedRows = 0, repeatedColumns = 0;

			for (int j = 0; j < sizeOfMatrix; j++) {
				for (int k = 0; k < sizeOfMatrix; k++) {
					matrix[j][k] = in.nextInt();
					if (j == k) {
						trace = trace + matrix[j][k];
					}

				}
			}

			for (int j = 0; j < sizeOfMatrix; j++) {

				Set rows = new HashSet<Integer>();
				Set columns = new HashSet<Integer>();

				for (int k = 0; k < sizeOfMatrix; k++) {
					rows.add(matrix[j][k]);
					columns.add(matrix[k][j]);
					
				}
				if (rows.size() != sizeOfMatrix) {
					repeatedRows++;
				}
				if (columns.size() != sizeOfMatrix) {
					repeatedColumns++;
				}
			}
			
			ans.append("Case #" + (i+1) + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
			ans.append('\n');
		}
		
		System.out.println(ans.toString().trim());
		in.close();
	}

}
