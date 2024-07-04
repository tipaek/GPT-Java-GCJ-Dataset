import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	//////////////////////////////////////////////////
	private static String solve(int acts[][]) {
		Arrays.sort(acts, (act1, act2) -> act1[0] > act2[0] ? 1
				: act1[0] < act2[0] ? -1 : act1[1] > act2[1] ? 1 : act1[1] < act2[1] ? -1 : 0);
		int ce = -1;
		int je = -1;
		char[] res = new char[acts.length];
		for (int[] act : acts) {
			if (act[0] >= ce) {
				res[act[2]] = 'C';
				ce = act[1];
				continue;
			}
			if (act[0] >= je) {
				res[act[2]] = 'J';
				je = act[1];
				continue;
			}
			return "IMPOSSIBLE";
		}
		return new String(res);
	}

	//////////////////////////////////////////////////
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int t = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int acts[][] = new int[n][3];
			for (int j = 0; j < n; j++) {
				acts[j][0] = in.nextInt();
				acts[j][1] = in.nextInt();
				acts[j][2] = j;
			}
			out.println("Case #" + i + ": " + solve(acts));
		}
		in.close();
	}
}