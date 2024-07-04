import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			class A {
				int s, e, i;
			}
			A[] as = new A[N];
			for (int i = 0; i < N; i++) {
				A a = new A();
				as[i] = a;
				a.s = in.nextInt();
				a.e = in.nextInt();
				a.i = i;
			}
			StringBuilder solution = new StringBuilder(N);
			solution.setLength(N);
			Arrays.sort(as, (a, b) -> {
				int d = a.s - b.s;
				return 0 != d ? d : a.e - b.e;
			});
			int ae = 0, be = 0;
			for (int i = 0; i < N; i++) {
				A a = as[i];
				System.out.println(a.s + " " + a.e + " " + a.i);
				if (ae <= a.s) {
					solution.setCharAt(a.i, 'C');
					ae = a.e;
				} else if (be <= a.s) {
					solution.setCharAt(a.i, 'J');
					be = a.e;
				} else {
					solution.setLength(0);
					solution.append("IMPOSSIBLE");
					break;
				}
			}
			System.out.println("CASE #" + (t + 1) + ": " + solution);
		}
	}
}
