import java.util.*;
import java.io.*;

public class Solution {
	// Try to program this with my daughter jumping over my head!! :D
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int test = 1; test <= t; ++test) {
			int N = in.nextInt();
			int trace = in.nextInt();
			if (trace % N == 0) {
				System.out.println(String.format("Case #%d: POSSIBLE", test));
				printMatrix(N, trace / N);
			} else {
				System.out.println(String.format("Case #%d: IMPOSSIBLE", test));
			}
		}
			
		in.close();
	}

	private static void printMatrix(int n, int initial) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != 0) {
					System.out.print(" ");
				}
				if (j == i) {
					System.out.print(initial);
				} else {
					int next = (initial + j - i) % n;
					if (next <= 0) next += n;
					System.out.print(next);
				}
			}
			System.out.println();
		}
		
	}

}
