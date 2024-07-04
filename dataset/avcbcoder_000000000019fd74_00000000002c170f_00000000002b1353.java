import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author avcbcoder last modified @11-Apr-2020 @6:12:41 AM codejam 2020 - TODO
 */

public class Solution {
	public static int LEN = 600;
	public static long[][] pascal;

	public static void main(String[] args) throws Exception {
//		pascal = new long[LEN][];
//		for (int r = 0; r < pascal.length; r++) {
//			pascal[r] = new long[r + 1];
//			for (int i = 0; i < r + 1; i++) {
//				if (i == 0 || i == r) {
//					pascal[r][i] = 1;
//				} else {
//					pascal[r][i] = pascal[r - 1][i - 1] + pascal[r - 1][i];
//				}
//			}
//		}

		int t = new Integer(br.readLine());
		for (int i = 1; i <= t; i++) {
			System.out.println("Case #" + i + ": ");
			solve();
		}
	}

	public static int N;
	public static boolean done;

	// **SOLUTION**
	public static void solve() throws Exception {
		int n = new Integer(br.readLine());

		if (n == 501) {
			System.out.println("1 1");
			System.out.println("2 1");
			System.out.println("3 2");
			System.out.println("3 1");
			int t = n - 5;
			for (int i = 4; t >= 0; i++, t--) {
				System.out.println(i + " 1");
			}
		} else {
			for (int i = 1; i <= n; i++) {
				System.out.println(i + " 1");
			}
		}

//		done = false;
//		N = n;
//		HashSet<Integer> hs = new HashSet<>();
//		ArrayList<Integer> al = new ArrayList<>();
//		rec(0, 0, 0, hs, al, 0);
	}

	private static void rec(int r, int c, long sum, HashSet<Integer> hs, ArrayList<Integer> al, int step) {
		int len = LEN + 10;
		if (step > 500)
			return;
		if (sum == N) {
			if (done)
				return;
			done = true;
			for (int x : al) {
				System.out.println((x / len + 1) + " " + ((x - len * (x / len)) + 1));
			}
			return;
		}
		if (r < 0 || r >= pascal.length || c < 0 || c >= pascal[r].length)
			return;
		if (done)
			return;
		int key = (len) * r + c;
		if (hs.contains(key))
			return;
		hs.add(key);
		al.add(key);

		sum = sum + pascal[r][c];
		step++;
		// next
		rec(r + 1, c, sum, hs, al, step);
		if (done)
			return;
		rec(r + 1, c + 1, sum, hs, al, step);
		// self
		rec(r, c - 1, sum, hs, al, step);
		if (done)
			return;
		rec(r, c + 1, sum, hs, al, step);
		// last
		if (done)
			return;
		rec(r - 1, c - 1, sum, hs, al, step);
		if (done)
			return;
		rec(r - 1, c, sum, hs, al, step);

		hs.remove(key);
		al.remove(al.size() - 1);

	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}
