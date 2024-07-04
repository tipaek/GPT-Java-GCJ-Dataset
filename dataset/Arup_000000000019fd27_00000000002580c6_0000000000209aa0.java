import java.util.*;

public class Solution {

	public static int n;
	public static int trace;
	public static int[][] g;
	
	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		for (int loop=1; loop<=nC; loop++) {
		
			n = stdin.nextInt();
			trace = stdin.nextInt();
			g = new int[n][n];
			boolean res = go(0);
			
			if (res) {
				System.out.println("Case #"+loop+": POSSIBLE");
				for (int i=0; i<n; i++) {
					System.out.print(g[i][0]+1);
					for (int j=1; j<n; j++)
						System.out.print(" "+(g[i][j]+1));
					System.out.println();
				}
			}
			else {
				System.out.println("Case #"+loop+": IMPOSSIBLE");
			}
		}
	}
	
	public static boolean go(int k) {
	
		if (k == n*n) return valid();
		
		boolean[] used = new boolean[n];
		int r = k/n;
		int c = k%n;
		
		for (int i=0; i<r; i++) used[g[i][c]] = true;
		for (int i=0; i<c; i++) used[g[r][i]] = true;
		
		for (int i=0; i<n; i++) {
			if (used[i]) continue;
			g[r][c] = i;
			boolean tmp = go(k+1);
			if (tmp) return true;
		}
	
		return false;
	}
	
	public static boolean valid() {
		int s = 0;
		for (int i=0; i<n; i++) s += g[i][i];
		return s+n == trace;
	}
}