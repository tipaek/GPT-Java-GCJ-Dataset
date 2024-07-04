import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
//import java.util.TreeSet;
public class Solution {
	
	public static HashSet<Integer>[] hr, hc;
	public static int[][] map, sol;
	public static int n, k;
	//public static TreeSet<Integer> t = new TreeSet<Integer>();
	//public static int count = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = in.nextInt();
			k = in.nextInt();
			hr = new HashSet[n];
			hc = new HashSet[n];
			for (int i = 0; i < n; i++) {
				hr[i] = new HashSet<Integer>();
				hc[i] = new HashSet<Integer>();
				for (int j = 1; j <= n; j++) {
					hr[i].add(j);
					hc[i].add(j);
				}
			}
			map = new int[n][n];
			sol = null;
			for (int i = 0; i < n; i++) Arrays.fill(map[i], -1);
			dfs(0, 0);
			
			if (sol != null) {
				System.out.println("Case #" + t + ": POSSIBLE");
				for (int i = 0; i < n; i++) {
					String rres = "";
					for (int j = 0; j < n; j++) {
						rres += sol[i][j] + " ";
					}
					System.out.println(rres.trim());
				}
			} else {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}
		}
	}
	
	public static void dfs(int r, int c) {
		if (sol != null) return;
		if (r == n && c == 0) {
			int trace = 0;
			for (int i = 0; i < n; i++) trace += map[i][i];
			if (trace == k) {
				//for (int i = 0; i < n; i++) System.out.println(Arrays.toString(map[i]));
				sol = new int[n][n];
				for (int i = 0; i < n; i++)
					sol[i] = map[i].clone();
			}
			return;
		}
		Iterator it = ((HashSet<Integer>)hr[r].clone()).iterator();
		while (it.hasNext()) {
			int x = (int)it.next();
			if (hc[c].contains(x)) {
				hr[r].remove(x);
				hc[c].remove(x);
				map[r][c] = x;
				if (c+1 == n) { dfs(r+1, 0); }
				else dfs(r, c+1);
				hr[r].add(x);
				hc[c].add(x);
				map[r][c] = -1;
			}
		}
	}
}
