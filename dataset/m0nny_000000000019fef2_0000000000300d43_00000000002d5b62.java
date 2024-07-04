import java.util.*;
import java.io.*;
public class Solution {
	static boolean completed;
	static String ans;
	static int limit;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			limit = (int)Math.sqrt(Math.abs(x) + Math.abs(y)) + 1;
			if(Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}
			if(Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}
			ans = "";
			completed = false;
			dfs(0, 0, x, y, "", 1);
			if(ans == "") System.out.println("Case #" + i + ": IMPOSSIBLE");
			else System.out.println("Case #" + i + ": " + ans);
		}
	}
	static void dfs(int x, int y, int a, int b, String seq, int step) {
		if(completed) return;
		if(x > (int)Math.pow(10, 9) || x < -1*(int)Math.pow(10, 9) || y > (int)Math.pow(10, 9) || y < -1*(int)Math.pow(10, 9)) return;
		if(seq.length() > limit) return;
		if(x == a && y == b) {
			ans = seq;
			completed = true;
			return;
		}
		dfs(x, y+step, a, b, seq+"N", step*2);
		dfs(x, y-step, a, b, seq+"S", step*2);
		dfs(x+step, y, a, b, seq+"E", step*2);
		dfs(x-step, y, a, b, seq+"W", step*2);
	}
}