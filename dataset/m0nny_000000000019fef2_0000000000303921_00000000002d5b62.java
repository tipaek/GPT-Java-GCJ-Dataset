import java.util.*;
import java.io.*;
public class Solution {
	static String ans;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}
			if(Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}
			ans = "";
			dfs(0, 0, x, y, "", 1);
			System.out.println("Case #" + i + ": " + ans);
		}
	}
	static void dfs(int x, int y, int a, int b, String seq, int step) {
		if(x > Math.abs(a) || x < -1*Math.abs(a) || y > Math.abs(b) || y < -1*Math.abs(b)) return;
		if(x == a && y == b) {
			if(ans == "") {
				ans = seq;
				return;
			}
			if(ans.length() > seq.length()) {
				ans = seq;
				return;
			}
		}
		dfs(x, y+step, a, b, seq+"N", step*2);
		dfs(x, y-step, a, b, seq+"S", step*2);
		dfs(x+step, y, a, b, seq+"E", step*2);
		dfs(x-step, y, a, b, seq+"W", step*2);
	}
}

