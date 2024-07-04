import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solve();
	}

	int T = 0;
	int N = 0;
	int C = 0;
	public void solve() {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		T = sc.nextInt();
		N = sc.nextInt();
		C = sc.nextInt();
		StringBuilder out = new StringBuilder();
		for ( int i = 0 ; i < T ; i++ ) {
			out.append(1);
			out.append(" ");
		}

		System.out.println(out.toString());
		System.out.flush();

		int[] ret = new int[T];
		out = new StringBuilder();
		for ( int i = 0 ; i < T ; i++ ) {
			ret[i] = sc.nextInt();
		}

		for ( int i = 0 ; i < T ; i++ ) {
			out.append(0);
			out.append(" ");
		}
		System.out.println(out.toString());
		System.out.flush();

		for ( int i = 0 ; i < T ; i++ ) {
			out.append(2);
			out.append(" ");
			out.append(3);
			out.append(" ");
		}
		System.out.println(out.toString());
		System.out.flush();
		sc.close();
	}
}
