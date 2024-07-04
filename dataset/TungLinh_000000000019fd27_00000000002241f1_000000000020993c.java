import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			solve(i, n, in);
		}
		in.close();
		return;
	}

	private static void solve(int _case, int n, Scanner in) {

		int repeatedValueRows = 0;
		int repeatedValueColumns = 0;
		int mainDiagonalSum = 0;

		boolean[] columnDuplication = new boolean[n];
		Arrays.fill(columnDuplication, false);

		Set<Integer>[] columnValues = new Set[n];
		for (int i = 0; i < n; i++)
			columnValues[i] = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			Set<Integer> rowValues = new HashSet<Integer>();
			boolean rowduplication = false;

			for (int j = 0; j < n; j++) {
				int value = in.nextInt();

				if (rowduplication == false) {
					if (!rowValues.contains(value))
						rowValues.add(value);
					else {
						rowduplication = true;
						repeatedValueRows++;
					}
				}

				if (columnDuplication[j] == false) {
					if (!columnValues[j].contains(value))
						columnValues[j].add(value);
					else {
						columnDuplication[j] = true;
						repeatedValueColumns++;
					}
				}

				if (i == j) {
					mainDiagonalSum += value;
				}
			}
		}

		System.out.println(
				"Case #" + _case + ": " + mainDiagonalSum + " " + repeatedValueRows + " " + repeatedValueColumns);
	}

}