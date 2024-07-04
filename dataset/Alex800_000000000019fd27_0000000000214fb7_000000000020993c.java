import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(
				new BufferedReader(new InputStreamReader(System.in)));
		int r = 0;
		int c = 0;
		int trace = 0;

		int T = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int i = 1; i <= T; ++i) {
			int N = in.nextInt();
			int[][] arr = new int[N][N];

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int add = in.nextInt();
					arr[j][k] = add;
					if (j == k)
						trace += add;
				}
			}
			HashSet<Integer> s = new HashSet<Integer>();
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					s.add(arr[j][k]);
				}
				if (s.size() != N)
					r++;
				s.clear();
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					s.add(arr[k][j]);
				}
				if (s.size() != N)
					c++;
				s.clear();
			}
			System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
			r = 0;
			c = 0;
			trace = 0;
		}
		in.close();

	}
}