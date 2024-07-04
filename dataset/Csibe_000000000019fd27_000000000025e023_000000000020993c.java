import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int numOfRowsWithDuplicate = 0;
			int trace = 0;
			List<Set<Integer>> columns = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				Set<Integer> set = new HashSet<>();
				columns.add(set);
			}
			int c = 0;
			Set<Integer> row = new HashSet<>();
			for (int j = 0; j < n * n; j++) {
				int number = in.nextInt();
				row.add(number);
				columns.get(j % n).add(number);
				if (j == c * n + c) {
					trace = trace + number;
					c ++;
				}
				if (j % n == n - 1) {
					if (row.size() < n) {
						numOfRowsWithDuplicate ++;
					}
					row.clear();
				}
			}
			int numColsWithDuplicate = 0;
			for (Set<Integer> column : columns) {
				if (column.size() < n) {
					numColsWithDuplicate++;
				}
			}
			
			System.out.println("Case #" + t + ": " + trace + " " + numOfRowsWithDuplicate + " " + numColsWithDuplicate);
		}
		in.close();
	}
}