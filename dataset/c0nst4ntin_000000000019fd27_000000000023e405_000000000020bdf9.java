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
			ArrayList<int[]> j = new ArrayList<int[]>();
			ArrayList<int[]> c = new ArrayList<int[]>();
			for (int[] a : activites) {
				if (fits(j,a)) {
					j.add(a);
					result += 'J';
				} else if (fits(c,a)) {
					c.add(a);
					result += 'C';
				} else {
					result = "IMPOSSIBLE";
					break;
				}
			}

			System.out.println("Case #" + _t + ": " + result);
		}
	}

	private static boolean fits(ArrayList<int[]> s, int[] b) {
		for (int[] a : s) {
			if (collides(a, b)) {
				return false;
			}
		}
		return true;
	}

	private static boolean collides(int[] a, int[] b) {
		if (a[0] < b[0]) {
			if (a[1] > b[0])
				return true;
		} else {
			if (a[0] < b[1])
				return true;
		}
		return false;
	}

}