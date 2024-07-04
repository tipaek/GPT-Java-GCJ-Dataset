import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {
	
	private PrintStream out;
	private BufferedReader in;
	private StringTokenizer st;
	
	public void solve() throws IOException {
		long time0 = System.currentTimeMillis();
		
		int t = nextInt();
		for (int test = 1; test <= t; test++) {
			int n = nextInt();
			int[][] m = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					m[i][j] = nextInt();
				}
			}
			String answer = solve(n, m);
			out.println("Case #" + test + ": " + answer);
		}
		
		System.err.println("time: " + (System.currentTimeMillis() - time0) + " ms.");
	}
	
	private String solve(int n, int[][] m) {
		int MYTRUE = 0;
		int[] used = new int[n + 1];
		int k = 0;
		int r = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			k += m[i][i];
			MYTRUE++;
			for (int j = 0; j < n; j++) {
				if (used[m[i][j]] == MYTRUE) {
					r++;
					break;
				} else {
					used[m[i][j]] = MYTRUE;
				}
			}
			MYTRUE++;
			for (int j = 0; j < n; j++) {
				if (used[m[j][i]] == MYTRUE) {
					c++;
					break;
				} else {
					used[m[j][i]] = MYTRUE;
				}
			}
		}
		return k + " " + r + " " + c;
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	
	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	
	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	public String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}
	
	@Override
	public void run() {
		try {
			solve();
			out.close();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
	
	public Solution(String name) throws IOException {
		Locale.setDefault(Locale.US);
		if (name == null) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintStream(new BufferedOutputStream(System.out));
		} else {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(name + ".in")));
			out = new PrintStream(new BufferedOutputStream(new FileOutputStream(name + ".out")));
		}
		st = new StringTokenizer("");
	}
	
	public static void main(String[] args) throws IOException {
		new Thread(new Solution(null)).start();
	}
}
