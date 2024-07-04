

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int key = in.nextInt();
			int[][] matrix = new int[n][n];
			Random random = new Random();
			boolean found = false;
			List<Set<Integer>> rowsNumbers = new ArrayList<Set<Integer>>();
			List<Set<Integer>> columnsNumbers = new ArrayList<Set<Integer>>();
			for (int j = 0; j < n; j++)
				rowsNumbers.add(new HashSet<Integer>());
			for (int j = 0; j < n; j++)
				columnsNumbers.add(new HashSet<Integer>());

			for (int trySol = 0; trySol < 200000; trySol++) {
				for (int j = 0; j < n; j++)
					rowsNumbers.get(j).clear();
				for (int j = 0; j < n; j++)
					columnsNumbers.get(j).clear();
				
				
				int sum = 0;
				for (int j = 0; j < n; j++)
					for (int k = 0; k < n; k++) {

						matrix[j][k] = random.nextInt(n)+1;
						rowsNumbers.get(j).add(matrix[j][k]);
						columnsNumbers.get(k).add(matrix[j][k]);
						if (k == j)
							sum += matrix[j][k];
					}
				int nRows = 0;
				int nColumns = 0;
				for (int j = 0; j < n; j++) {
					if (rowsNumbers.get(j).size() != n)
						nRows++;
					if (columnsNumbers.get(j).size() != n)
						nColumns++;

				}
				if(sum==key&&nRows==0&&nColumns==0) {
				System.out.println("Case #" + i + ": POSSIBLE");
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						System.out.print(matrix[j][k]+" ");
					}
					System.out.println();}
				found = true;
				break;
				}
				
						
			}
			if(found==false)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
		}
	}

}
