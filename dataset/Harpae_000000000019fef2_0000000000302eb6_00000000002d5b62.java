import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);

	
	static int GX, GY;
	static int OFFSET = 105;
	static int dp[][][];
	static int INF = 1_000_000;
	static String s;
	
	static String addX, addY, subX, subY;
	
	static long ax,ay;
	static int numBits;
	static int dp2[][][];
	
	public static void main(String[] args) {
		FS in = new FS();
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			GX = in.nextInt();
			GY = in.nextInt();
			if(GX > 100 || GX < -100 || GY > 100 || GY < -100) {
				ax = Math.abs(GX);
				ay = Math.abs(GY);
				numBits = 0;
				for(int k = 40; k >= 0; k--) {
					if((ax & (1L<<k)) > 0 || (ay & (1L<<k)) > 0) { numBits = k+1; break;}
				}
				
				if(GX < 0) {
					addX = "E";
					subX = "W";
				}
				else {
					addX = "W";
					subX = "E";
				}
				
				if(GY < 0) {
					addY = "N";
					subY = "S";
				}
				else {
					addY = "S";
					subY = "N";
				}
				
				dp2 = new int[2*numBits + 5][10][10];
				for(int a[][]:dp2)
					for(int b[]:a)
						Arrays.fill(b, -1);
				
				int res = go2(0, 0, 0);
				if(res >= INF) out.println("Case #"+runs+": IMPOSSIBLE");
				else {
					s = "";
					bb2(0, 0, 0);
					out.println("Case #"+runs+": "+s);
				}
				
			}
			else {
				dp = new int[20][2*OFFSET][2*OFFSET];
				for(int a[][]:dp)
					for(int b[]:a)
						Arrays.fill(b, -1);
				int res = go(0, 0, 0);
				if(res >= INF) out.println("Case #"+runs+": IMPOSSIBLE");
				else {
					s = "";
					bb(0,0,0);
					out.println("Case #"+runs+": "+s);
				}
			}
		}
	
		out.close();
	}
	
	static int go2(int bit, int c1, int c2) {
		if(bit >= numBits && c1 == 0 && c2 == 0) return 0;
		if(bit >= 2*numBits + 5) return INF;
	
		if(dp2[bit][c1][c2] != -1) return dp2[bit][c1][c2];
		
		boolean b1 = (ax & (1L<<bit)) > 0;
		boolean b2 = (ay & (1L<<bit)) > 0;
		
		int n1 = c1 + (b1 ? 1 : 0);
		int n2 = c2 + (b2 ? 1 : 0);
	
		int res = INF;
		
		// add to 1
		if(n2%2 == 0 && n1%2 == 1) res = min(res, 1 + go2(bit+1, (n1+1)/2, n2/2));
		
		// sub to 1
		if(n2%2 == 0 && n1%2 == 1) res = min(res, 1 + go2(bit+1, (n1-1)/2, n2/2));
		
		// add to 2
		if(n1%2 == 0 && n2%2 == 1) res = min(res, 1 + go2(bit+1, n1/2, (n2+1)/2));
	
		// sub to 2
		if(n1%2 == 0 && n2%2 == 1) res = min(res, 1 + go2(bit+1, n1/2, (n2-1)/2));

		
		return dp2[bit][c1][c2] = res;
	}
	
	
	static void bb2(int bit, int c1, int c2) {
		if(bit >= numBits && c1 == 0 && c2 == 0) return;
		if(bit >= 2*numBits + 5) return;
		
		int goal = go2(bit, c1, c2);
		
		boolean b1 = (ax & (1L<<bit)) > 0;
		boolean b2 = (ay & (1L<<bit)) > 0;
		
		int n1 = c1 + (b1 ? 1 : 0);
		int n2 = c2 + (b2 ? 1 : 0);
	
		int res = INF;
		
		// add to 1
		if(n2%2 == 0 && n1%2 == 1) res = min(res, 1 + go2(bit+1, (n1+1)/2, n2/2));
		if(res == goal) {
			s += addX;
			bb2(bit+1, (n1+1)/2, n2/2);
			return;
		}
		
		// sub to 1
		if(n2%2 == 0 && n1%2 == 1) res = min(res, 1 + go2(bit+1, (n1-1)/2, n2/2));
		if(res == goal) {
			s += subX;
			bb2(bit+1, (n1-1)/2, n2/2);
			return;
		}
		
		// add to 2
		if(n1%2 == 0 && n2%2 == 1) res = min(res, 1 + go2(bit+1, n1/2, (n2+1)/2));
		if(res == goal) {
			s += addY;
			bb2(bit+1, n1/2, (n2+1)/2);
			return;
		}
		
		// sub to 2
		if(n1%2 == 0 && n2%2 == 1) res = min(res, 1 + go2(bit+1, n1/2, (n2-1)/2));
		if(res == goal) {
			s += subY;
			bb2(bit+1, n1/2, (n2-1)/2);
			return;
		}
	}
	
	
	
	
	static int go(int id, int x, int y) {
		if(x == GX && y == GY) return 0;
		if(x < -101 || x > 101 || y < -101 || y > 101) return INF;
		if(dp[id][x+OFFSET][y+OFFSET] != -1) return dp[id][x+OFFSET][y+OFFSET];
		int a = 1+ go(id+1, x + (1<<id), y);
		int b = 1+ go(id+1, x - (1<<id), y);
		int c = 1+ go(id+1, x, y + (1<<id));
		int d = 1+ go(id+1, x, y - (1<<id));
		int res = min(min(a,b), min(c,d));
		return dp[id][x+OFFSET][y+OFFSET] = res;
	}
	
	static void bb(int id, int x, int y) {
		if(x == GX && y == GY) return;
		if(x < -101 || x > 101 || y < -101 || y > 101) return;
		int a = 1+ go(id+1, x + (1<<id), y);
		int b = 1+ go(id+1, x - (1<<id), y);
		int c = 1+ go(id+1, x, y + (1<<id));
		int d = 1+ go(id+1, x, y - (1<<id));
		int res = min(min(a,b), min(c,d));
		if(res == a) {
			s += "E";
			bb(id+1, x+(1<<id), y);
		}
		else if(res == b) {
			s += "W";
			bb(id+1, x-(1<<id), y);
		}
		else if(res == c) {
			s += "N";
			bb(id+1, x, y + (1<<id));
		}
		else if(res == d) {
			s += "S";
			bb(id+1, x, y - (1<<id));
		}
	}
	
	static int min(int a, int b) { return a < b ? a : b;}
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
		int[] NIA(int n) {
			int r[] = new int[n];
			for(int i = 0; i < n; i++) r[i] = nextInt();
			return r;
		}
		long[] NLA(int n) {
			long r[] = new long[n];
			for(int i = 0; i < n; i++) r[i] = nextLong();
			return r;
		}
		char[][] grid(int r, int c){
			char res[][] = new char[r][c];
			for(int i = 0; i < r; i++) {
				char l[] = next().toCharArray();
				for(int j = 0; j < c; j++) {
					res[i][j] = l[j];
				}
			}
			return res;
		}
	}
	
}
