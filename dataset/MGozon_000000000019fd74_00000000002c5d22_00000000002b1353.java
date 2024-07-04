import java.util.*;
public class Solution {
	
	public static int n;
	public static ArrayList<loc> path;
	public static ArrayList<loc> pathf;
	public static boolean[][] vis = new boolean[32][32];
	public static int[] dr = { -1, -1, 0, 0, 1, 1 };
	public static int[] dk = { -1, 0, -1, 1, 0, 1 };
	public static int sum;
	public static int[][] pas;
	public static boolean fin;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			vis = new boolean[32][32];
			int n = in.nextInt();
			pas = new int[32][32];
			for (int i = 0; i < 32; i++) { pas[i][0] = 1; pas[i][i] = 1; }
			for (int i = 1; i < 32; i++) {
				for (int j = 1; j < i; j++) {
					pas[i][j]  = pas[i-1][j-1] + pas[i-1][j];
				}
			}
			//for (int i = 0; i < 32; i++) System.out.println(Arrays.toString(pas[i]));
			/*sum = 0;
			path = new ArrayList<loc>();
			pathf = new ArrayList<loc>();
			path.add(new loc(0, 0));
			fin = false;
			dfs(0, 0);*/
			pathf = new ArrayList<loc>();
			pathf.add(new loc(0, 0));
			if (n == 1) {
				System.out.println("Case #" + t + ":");
				System.out.println(pathf);
				for (int i = 0; i < pathf.size(); i++) {
					System.out.println(1 + " " + 1);
				}
			} else {
				pathf.add(new loc(1, 0));
				int sum = 2;
				int temp = 1;
				while (sum <= n) {
					temp++;
					sum += temp;
					pathf.add(new loc(temp, temp-1));
				}
				//System.out.println(pathf);
				pathf.remove(pathf.size()-1);
				//System.out.println(temp);
				sum -= temp;
				temp--;
				while (sum < n) {
					sum++;
					pathf.add(new loc(temp, temp));
					temp++;
				}
				
				
				
				System.out.println("Case #" + t + ":");
				//System.out.println(pathf);
				for (int i = 0; i < pathf.size(); i++) {
					System.out.println((pathf.get(i).r+1) + " " + (pathf.get(i).k+1));
				}
			}
			
			
		}
	}
	
	public static void dfs(int r, int k) {
		System.out.println(path);
		if (fin == true) return;
		if (vis[r][k]) return;
		sum += pas[r][k];
		if (sum == n) { fin = true; pathf = (ArrayList<loc>)path.clone(); System.out.println("Path: "); System.out.println(path); }
		int x = Math.random() > 0.5 ? 5 : 4;
		for (int i = x; i >= 0; i--) {
			if (r + dr[i] >= 0 && r + dr[i] < 32 && k + dk[i] >= 0 && k + dk[i] < 32) {
				int nr = r + dr[i];
				int nk = k + dk[i];
				vis[nr][nk] = true;
				path.add(new loc(nr, nk));
				dfs(nr, nk);
				path.remove(path.size()-1);
				vis[nr][nk] = false;
			}
		}
		sum -= pas[r][k];
	}
}

class loc {
	int r, k;
	public loc(int a, int b) { r = a; k = b; }
	public String toString() { return String.format("(%d, %d)", r, k); }
}