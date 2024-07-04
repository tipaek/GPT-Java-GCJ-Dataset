import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
	public void run() throws Exception {
		FastScanner f = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int times = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			out.printf("Case #%d: ", asdf);
			int n = f.nextInt();
			int[] x = new int[n], y = new int[n];
			int[][] dx = new int[n][n], dy = new int[n][n];
			boolean[][] used = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				x[i] = f.nextInt(); y[i] = f.nextInt();
				for(int j = 0; j < i; j++) {
					int ddx = x[i]-x[j];
					int ddy = y[i]-y[j];
					int g = Math.abs(gcd(ddx,ddy));
					ddx /= g;
					ddy /= g;
					if(ddx < 0) {
						ddx *= -1;
						ddy *= -1;
					}
					dx[j][i] = dx[i][j] = ddx;
					dy[j][i] = dy[i][j] = ddy;
				}
				used[i][i] = true;
			}
			int ans = 0;
			for(int ai = 0; ai < n; ai++) {
				for(int aj = 0; aj < n; aj++) {
					if(!used[ai][aj]) {
						boolean[][] adj = new boolean[2*n+2][2*n+2];
						int ddx = dx[ai][aj];
						int ddy = dy[ai][aj];
						for(int i = 0; i < n; i++) {
							for(int j = 0; j < n; j++) {
								if(dx[i][j] == ddx && dy[i][j] == ddy) {
									adj[i][n+j] = true;
									used[i][j] = true;
								}
							}
							adj[2*n][i] = adj[n+i][2*n+1] = true;
						}
						int curans = 0;
						while(true) {
							LinkedList<Integer> q = new LinkedList<>();
							int[] par = new int[2*n+2];
							Arrays.fill(par,-1);
							par[2*n] = -2;
							q.add(2*n);
							while(!q.isEmpty()) {
								int i = q.poll();
								for(int j = 0; j < 2*n+2; j++)
									if(adj[i][j] && par[j] == -1) {
										par[j] = i;
										q.add(j);
									}
							}
							if(par[2*n+1] == -1) break;
							int cur = 2*n+1;
							while(par[cur] >= 0) {
								int nx = par[cur];
								adj[nx][cur] = false;
								adj[cur][nx] = true;
								cur = nx;
							}
							curans++;
						}
						ans = Math.max(curans,ans);
					}
				}
			}
			out.println(Math.min(ans+2,n));
		}
///
		out.flush(); 
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
