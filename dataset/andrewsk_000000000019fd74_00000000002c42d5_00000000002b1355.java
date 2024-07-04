import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int r = in.nextInt();
			int c = in.nextInt();
			long[][] a = new long[r][c];
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					a[j][k] = in.nextLong();
				}
			}
			long res = process(a);
			System.out.println("Case #" + i + ": " + res);
		}
	}

	private static long process(long[][] a) {
		List<Long> interests = new ArrayList<>();
		long interest = sum(a);
		while (interests.isEmpty() || interest != interests.get(interests.size() - 1)) {
			interests.add(interest);
			eliminate(a);
			interest = sum(a);
		}
		long s = 0;
		for (long i : interests) {
			s += i;
		}
		return s;
	}

	private static void eliminate(long[][] a) {
		List<List<Integer>> neibs = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				neibs.add(new ArrayList<>());
			}
		}

		int c = a[0].length;

		int left = -1;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] > 0) {
					if (left == -1) {
						left = j;
					} else {
						neibs.get(i*c + left).add(i*c + j);
						neibs.get(i*c + j).add(i*c + left);
						left = j;
					}
				}
			}
		}
		int up = -1;
		for (int j = 0; j < a[0].length; j++) {
			for (int i = 0; i < a.length; i++) {
				if (a[i][j] > 0) {
					if (up == -1) {
						up = i;
					} else {
						neibs.get(up*c + j).add(i*c + j);
						neibs.get(i*c + j).add(up*c + j);
						up = i;
					}
				}
			}
		}

		List<Integer> rem = new ArrayList<>();
		for(int i = 0; i < neibs.size(); i++) {
			int x = i / c;
			int y = i % c;
			if (a[x][y] > 0) {
				double avg = 0;
				for (Integer nb : neibs.get(i)) {
					int ni = nb / c;
					int nj = nb % c;
					avg += a[ni][nj];
				}
				avg = avg / (double)neibs.get(i).size();
				if (avg > a[x][y]) {
					rem.add(i);
				}
			}
		}

		for (int i : rem) {
			int x = i / c;
			int y = i % c;
			a[x][y] = 0;
		}
	}

	private static long sum(long[][] a) {
		long s = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				s += a[i][j];
			}
		}
		return s;
	}
}
