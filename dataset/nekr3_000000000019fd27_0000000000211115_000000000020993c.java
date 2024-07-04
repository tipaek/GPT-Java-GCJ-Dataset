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
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cur = in.nextInt()-1;
					if (vals[i][0][cur]) dups[0][i] = true;
					else vals[i][0][cur] = true;
					if (vals[j][1][cur]) dups[1][j] = true;
					else vals [j][1][cur] = false;
				}
			}
		}
	}
}
