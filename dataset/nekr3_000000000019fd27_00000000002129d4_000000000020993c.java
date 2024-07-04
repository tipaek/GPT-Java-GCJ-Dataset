import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int x = 1; x <= t; x++) {
			int n = in.nextInt();
			boolean[][] dups = new boolean[2][n];
			boolean[][][] vals = new boolean[n][2][n];
			int trace = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cur = in.nextInt()-1;
					if (vals[i][0][cur]) dups[0][i] = true;
					else vals[i][0][cur] = true;
					if (vals[j][1][cur]) dups[1][j] = true;
					else vals [j][1][cur] = true;
					if (i == j) trace += cur + 1;
				}
			}
			System.out.print("Case #" + x + ": " + trace + " ");
			int r = 0;
			int c = 0;
			for (int i = 0; i < n; i++) {
				if (dups[0][i]) r++;
				if (dups[1][i]) c++;
			}
			System.out.println(r + " " + c);
		}
	}
}