 import java.util.*;
import java.io.*;
    public class Solution {
      	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int trace = 0;
			int row = 0;
			int col = 0;
			Set<Integer>[] colsets = new Set[n];
			for (int p = 0; p < n; p++) {

				Set<Integer> set = new HashSet<>();
				for (int q = 0; q < n; q++) {
					if (colsets[q] == null) {
						colsets[q] = new HashSet<>();
					}
					int cell = in.nextInt();
					if (p == q) {
						trace += cell;
					}
					set.add(cell);
					colsets[q].add(cell);
				}
				if (set.size() != n) {
					row++;
				}
			}


			for (int p = 0; p < n; p++) {
				if (colsets[p].size() != n)
					col++;
			}

			System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
		}
	}
    }