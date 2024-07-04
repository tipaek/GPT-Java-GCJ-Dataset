import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int _t = 1; _t <= t; ++_t) {
			int n = in.nextInt();
			ArrayList<int[]> activites = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int[] a = new int[2];
				a[0] = in.nextInt();
				a[1] = in.nextInt();
				activites.add(a);
			}
			String result = "";
			boolean[] j = new boolean[1440];
			boolean[] c = new boolean[1440];
			for (int[] a : activites) {
				if (fits(j,a)) {
					block(j, a);
					result += 'J';
				} else if (fits(c,a)) {
					block(c, a);
					result += 'C';
				} else {
					result = "IMPOSSIBLE";
				}
			}

			System.out.println("Case #" + _t + ": " + result);
		}
	}

	private static boolean fits(boolean[] s, int[] a) {
		for(int i = a[0]; i< a[1]; i++) {
			if (s[i] == true)
				return false;
		}
		return true;
	}

	private static void block(boolean[] s, int[] a) {
		for(int i = a[0]; i< a[1]; i++) {
			s[i] = true;
		}
	}

	private static void logArr(int[] a) {
		System.out.println("[" + a[0] + "," + a[1] + "]");
	}

}
