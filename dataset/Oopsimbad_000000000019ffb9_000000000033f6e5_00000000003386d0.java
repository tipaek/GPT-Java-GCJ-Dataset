import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
	int[] x, y;
	int[][] dx, dy;
	int[] link;
	int[] vis;
	public void run() throws Exception {
		FastScanner f = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int times = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			out.printf("Case #%d: ", asdf);
			int n = f.nextInt();
			x = new int[n]; y = new int[n];
			dx = new int[n][n]; dy = new int[n][n];
			for(int i = 0; i < n; i++) {
				x[i] = f.nextInt(); y[i] = f.nextInt();
				for(int j = 0; j < i; j++) {
					int ddx = x[i]-x[j];
					int ddy = y[i]-y[j];
					int g = Math.abs(gcd(ddx,ddy));
					ddx /= g;
					ddy /= g;
					dx[j][i] = dx[i][j] = ddx;
					dy[j][i] = dy[i][j] = ddy;
				}
			}
			int best = 1;
			link = new int[n];
			vis = new int[n];
			Arrays.fill(link,-1);
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					for(int k = 0; k < n; k++)
						best = Math.max(best,Math.max(recur(k,false,dx[i][j],dy[i][j]),recur(k, true, dx[i][j], dy[i][j])));
			out.println(best);
		}
///
		out.flush(); 
	}
	public int recur(int i, boolean skip, int ddx, int ddy) {
		int best = 0;
		vis[i]++;
		for(int b : vis) if(b > 0) best++;
		if(vis[i] >= 3) {
			vis[i]--;
			return best;
		}
		if(skip) {
			if(link[i] != -1) best = Math.max(best,recur(link[i], false, ddx, ddy));
			else for(int j = 0; j < link.length; j++) {
				if(link[j] != -1) continue;
				link[i] = j;
				link[j] = i;
				best = Math.max(best, recur(j, false, ddx, ddy));
				link[j] = -1;
				link[i] = -1;
			}
		} else {
			int nx = -1;
			double dist = Double.POSITIVE_INFINITY;
			for(int j = 0; j < link.length; j++) {
				if(ddx != dx[i][j] || ddy != dy[i][j]) continue;
				if(dist > Math.hypot(x[i]-x[j],y[i]-y[j])) {
					dist = Math.hypot(x[i]-x[j],y[i]-y[j]);
					nx = j;
				}
			}
			if(nx != -1) best = Math.max(best, recur(nx, true, ddx, ddy));
		}
		vis[i]--;
		return best;
	}
	public int gcd(int x, int y) {
		if(x == 0) return y;
		return gcd(y%x,x);
	}
///
    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }
}
