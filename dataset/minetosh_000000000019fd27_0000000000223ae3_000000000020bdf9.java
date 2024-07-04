import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + resolv(sc));
		}
	}

	private static String resolv(Scanner sc) {
		int N = sc.nextInt();

		long jobs[] = new long[N];
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			jobs[i] = ((long)S * 10000 + (long)E) * 10000 + i;
		}
		Arrays.sort(jobs);

		int JE = 0;
		int CE = 0;
		StringBuffer sb = new StringBuffer();
		char asigns[] = new char[N];
		for (int i = 0; i < N; i++) {
			int SE = (int)(jobs[i] / 10000);
			int n = (int)(jobs[i] % 10000);
			int S = SE / 10000;
			int E = SE % 10000;
			if (S >= CE) {
				asigns[n] = 'C';
				CE = E;
			} else if (S >= JE) {
				asigns[n] = 'J';
				JE = E;
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(asigns);
	}
}