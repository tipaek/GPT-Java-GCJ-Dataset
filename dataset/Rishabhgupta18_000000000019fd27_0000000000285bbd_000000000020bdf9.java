import java.util.*;
import java.io.*;
public class Solution {
 public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt("" + in.nextLine());

		for (int i = 0; i < t; i++) {

			int n = in.nextInt();

			int[][] ar = new int[n][2];

			for (int j = 0; j < n; j++) {
				ar[j][0] = in.nextInt();
				ar[j][1] = in.nextInt();
			}

			System.out.println("Case #" + (i + 1) + ": " + find(ar));

		}

	}

	public static String find(int[][] ar) {

		boolean[] J = new boolean[100000000];
		boolean[] C = new boolean[100000000];

		StringBuilder result = new StringBuilder();
		for (int[] a : ar) {

			if (isFree(J, a[0], a[1])) {
				book(J, a[0], a[1]);
				result.append("J");
			} else {

				if (isFree(C, a[0], a[1])) {
					book(C, a[0], a[1]);
					result.append("C");
				} else {
					return "IMPOSSIBLE";
				}

			}
		}
		return result.toString();
	}

	private static void book(boolean[] b, int start, int end) {
		for (int i = start; i <= end; i++) {
			// b[i] == true; means booked
			b[i] = true;
		}
	}

	private static boolean isFree(boolean[] b, int start, int end) {

		for (int i = start + 1; i <= end; i++) {
			// b[i] == true; means booked
			if (b[i]) {
				return false;
			}
		}
		return true;

	}
}