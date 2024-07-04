import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		long[][] arr = new long[100][100];
		for (int t = 1; t <= T; ++t) {
			long n = in.nextLong();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = in.nextLong();
				}
			}

			int noOfColumns = 0;
			int noOfRows = 0;
			long trace = 0;
			for (int i = 0; i < n; i++) {
				trace += arr[i][i];
				Set<Long> rowSet = new HashSet<>();
				Set<Long> colSet = new HashSet<>();
				for (int j = 0; j < n; j++) {
					if (rowSet.contains(arr[i][j])) {
						noOfRows++;
						break;
					} else
						rowSet.add(arr[i][j]);
				}
				for (int j = 0; j < n; j++) {
					if (colSet.contains(arr[j][i])) {
						noOfColumns++;
						break;
					} else
						colSet.add(arr[j][i]);
				}
				
				

			}
			System.out.println("Case #" + t + ": " + trace + " " + noOfRows + " " + noOfColumns);
				

		}
	}
}