import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfcases = s.nextInt();
		for (int i = 0; i < noOfcases; i++) {
			int size = s.nextInt();
			int[][] input = new int[size][size];
			int trace = 0;
			int rows = 0;
			int cols = 0;

			Set<Integer> row = new HashSet<Integer>();

			for (int j = 0; j < size; j++) {
				row.clear();
				boolean found = false;
				for (int k = 0; k < size; k++) {
					int ele = s.nextInt();
					input[j][k] = ele;
					if (j == k) {
						trace += ele;
					}
					if (row.contains(ele) && !found) {
						rows++;
						found = true;
					} else {
						row.add(ele);
					}

				}
			}

			for (int j = 0; j < size; j++) {
				row.clear();
				boolean found = false;
				for (int k = 0; k < size; k++) {
					int ele = input[k][j];

					if (row.contains(ele) && !found) {
						cols++;
						found = true;
					} else {
						row.add(ele);
					}

				}
			}

			System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + cols);

		}
		s.close();

	}
}
