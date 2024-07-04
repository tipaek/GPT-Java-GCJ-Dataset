import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int D = in.nextInt();
			long[] slices = new long[N];
			for (int i=0; i<N; i++) {
				slices[i] = in.nextLong();
			}
			//Arrays.sort(slices);

			int res = solve(N,D,slices);
			out.println(String.format("Case #%d: %d", t+1, res));
		}

		in.close();
	}

	public static int solve (int N, int D, long[] slices) {

		int min = D-1;

		for (int i=0; i<N; i++) {
			long base = slices[i];
			int eq = 0;
			for (int j=0; j<N; j++) {
				long tmp = slices[j];
				if (tmp == base)
					eq++;
			}
			if (eq >= D)
				return 0;
		}

		if (D == 3) {
			for (int i=0; i<N; i++) {
				long base = slices[i];
				for (int j=0; j<N; j++) {
					if (i==j) continue;
					long tmp = slices[j];
					if (tmp == 2*base)
						min = 1;
				}
			}
		}

		return min;
	}

}
