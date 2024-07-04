import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
		
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println("Case #" + i2 + ": " + solution(x, y));
		}

		sc.close();
	}

	private static String solution(int x, int y) {
		//System.out.println(x+ " " +y);
		rx = x;
		ry = y;
		rs = "";
		sr(0, 0, "", 1, 0);
		
		if (rs.equals("")) {
			return "IMPOSSIBLE";
		}
		return rs;
	}
	
	static HashSet<Integer> xx = new HashSet<Integer>();
	static int rx = 0;
	static int ry = 0;
	static String rs = null;
	
	private static void sr(int x, int y, String s, int n, int t) {
		//System.out.println(s + " " +x + " " + y);
		if ((rx == x) && (ry == y)) {
			//System.out.println("found: " + s);
			rs = s;
			return;
		}
		if (!rs.equals("")) {
			//System.out.println("fast quit");
			return;
		}
		if (t == 8) {
			//System.out.println("max limit");
			return;
		} else {
			int nn = n*2;
			int tt = t+1;
			sr(x+n, y, s+"E", nn, tt);
			sr(x-n, y, s+"W", nn, tt);
			sr(x, y+n, s+"N", nn, tt);
			sr(x, y-n, s+"S", nn, tt);
		}
	}

	private static void cacl(int n, int d) {

		int sum = 0;
		int e = 1;
		for (int i = 0; i < d; i++) {
			
			if ((n & e) == 0) {  
				sum += e;
			} else {
				sum -= e;
			}
			e=2*e;
		}
		System.out.println(n + " " + sum);
	}


}
