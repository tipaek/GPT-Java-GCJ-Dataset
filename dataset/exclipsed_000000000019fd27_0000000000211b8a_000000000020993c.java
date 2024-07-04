import java.util.*;
import java.io.*;

public class Solution {
	final static int MOD = 1000000007;
	final static int intMax = 1000000000;
	final static int intMin = -1000000000;
	final static int[] DX = { 0, 0, -1, 1 };
	final static int[] DY = { -1, 1, 0, 0 };

	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; ++t) {
			System.out.print("Case #" + t + ": ");
			int N = Integer.parseInt(br.readLine());
			int k = 0; int r = 0; int c = 0;
			int[][] grid = new int[N][N];
			for(int i = 0; i != N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j != N; ++j) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i != N; ++i) {
				k += grid[i][i];
			}
			loop: for(int i = 0; i != N; ++i) {
				HashSet<Integer> vis = new HashSet<Integer>();
				for(int j = 0; j != N; ++j) {
					if(vis.contains(grid[i][j])) {
						r++;
						continue loop;
					}
					vis.add(grid[i][j]);
				}
			}
			loop: for(int i = 0; i != N; ++i) {
				HashSet<Integer> vis = new HashSet<Integer>();
				for(int j = 0; j != N; ++j) {
					if(vis.contains(grid[j][i])) {
						c++;
						continue loop;
					}
					vis.add(grid[j][i]);
				}
			}
			System.out.print(k + " " + r + " " + c);
			if(t != T) System.out.println();
		}
		br.close();	
	}
}