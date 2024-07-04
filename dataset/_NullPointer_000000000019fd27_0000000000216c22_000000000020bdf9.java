

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for (int tt = 1; tt <= t; tt++) {
			Solution bundling = new Solution();
			bundling.solve(in, tt);
		}

		in.close();
	}

	private void solve(Scanner in, int tt) {
		int n = in.nextInt();
		int start[] = new int[n];
		int end[] = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = in.nextInt();
			end[i] = in.nextInt();
		}
		String ans = solve(n, start, end);

		printLine("Case #" + tt + ": " + ans);

	}

	private String solve(int n, int[] start, int[] end) {
		int ans = 0;

		Arrays.sort(start);
		Arrays.sort(end);
		int e = 0;
		ArrayList<Character> free = new ArrayList<>();
		free.add('J');
		free.add('C');
		ArrayList<Character> busy = new ArrayList<>();
		StringBuilder res = new StringBuilder(end.length);
		for (int i = 0; i < start.length; i++) {

			if (start[i] >= end[e]) {
				e++;
				ans--;
				if (busy.size() != 0) {
					free.add(busy.remove(busy.size() - 1));
				}
			}
			ans++;
			if (ans > 2) {
				return "IMPOSSIBLE";
			}
			res.append(free.get(free.size() - 1));
			busy.add(free.remove(free.size() - 1));
		}
		return res.toString();
	}

	private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

}
