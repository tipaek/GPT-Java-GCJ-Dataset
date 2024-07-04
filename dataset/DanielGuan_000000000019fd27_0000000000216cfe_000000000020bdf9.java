import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int a = 1; a <= T; a++) {
			System.out.print("Case #" + a + ": ");
			int N = Integer.parseInt(in.readLine());
			int[][] act = new int[N][3];
			char[] sol = new char[N];
			for (int b = 0; b < N; b++) {
				StringTokenizer token = new StringTokenizer(in.readLine());
				act[b][0] = Integer.parseInt(token.nextToken());
				act[b][1] = Integer.parseInt(token.nextToken());
				act[b][2] = b;
			}
			Arrays.sort(act, (x, y) -> x[0] - y[0]);
			int Cend = 0;
			int Jend = 0;
			boolean poss = true;
			for (int b = 0; b < N; b++) {
				if (act[b][0] >= Cend) {
					Cend = act[b][1];
					sol[act[b][2]] = 'C';
				} else if (act[b][0] >= Jend) {
					Jend = act[b][1];
					sol[act[b][2]] = 'J';
				} else {
					poss = false;
					break;
				}
			}
			if (poss) {
				for (int b = 0; b < N; b++)
					System.out.print("" + sol[b]);
				System.out.println();
			} else
				System.out.println("IMPOSSIBLE");
		}
	}
}