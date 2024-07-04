import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		boolean[][] ch = new boolean[100][100];
		boolean[] rh = new boolean[100];

		for (int tc = 1; tc <= t; ++tc) {
			int n = in.nextInt();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					ch[i][j] = false;
				}
			}
			int k = 0;
			int r = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					rh[j] = false;
				}
				for (int j = 0; j < n; ++j) {
					int v = in.nextInt();
					ch[j][v - 1] = true;
					rh[v - 1] = true;
					if (i == j)
						k += v;
				}
				boolean all = true;
				for (int j = 0; j < n; ++j) {
					all &= rh[j];
				}
				if (!all) {
					++r;
				}
			}
			int c = 0;
			for (int j = 0; j < n; ++j) {
				boolean all = true;
				for (int v = 0; v < n; ++v) {
					all &= ch[j][v];
				}
				if (!all) {
					++c;
				}
			}

			System.out.println("Case #" + tc + ": " + k + " " + r + " " + c);
		}
	}

}
