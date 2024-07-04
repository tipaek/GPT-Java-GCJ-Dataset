import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;
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
			int m = nextInt();
			int[] x = new int[n];
			for (int i = 1; i < n; i++) {
				x[i] = nextInt();
			}
			int[] u = new int[m];
			int[] v = new int[m];
			for (int i = 0; i < m; i++) {
				u[i] = nextInt() - 1;
				v[i] = nextInt() - 1;
			}
			int[] d = solve(n, x, m, u, v);
			out.print("Case #" + test + ":");
			for (int i = 0; i < m; i++) {
				out.print(" " + d[i]);
			}
			out.println();
		}
		
		System.err.println("time: " + (System.currentTimeMillis() - time0) + " ms.");
	}
	
	private int[] solve(int n, int[] x, int m, int[] u, int[] v) {
		Integer[] id = sort(n, x);
		int[] dist = new int[n];
		int[][][] g = buildGraph(n, m, u, v);
		int[] d = new int[m];
		Arrays.fill(d, 1000000);
		for (int i = 1; i < n; i++) {
			if (x[id[i]] == x[id[i - 1]]) {
				dist[id[i]] = dist[id[i - 1]];
			} else {
				dist[id[i]] = dist[id[i - 1]] + 1;
			}
			int a = id[i];
			for (int[] e : g[a]) {
				int b = e[0];
				if (x[b] > x[a]) {
					d[e[1]] = dist[a] - dist[b];
				}
			}
		}
		return d;
	}

	private int[][][] buildGraph(int n, int m, int[] u, int[] v) {
		int[] cnt = new int[n];
		for (int i = 0; i < m; i++) {
			cnt[u[i]]++;
			cnt[v[i]]++;
		}
		int[][][] g = new int[n][][];
		for (int i = 0; i < n; i++) {
			g[i] = new int[cnt[i]][2];
			cnt[i] = 0;
		}
		for (int i = 0; i < m; i++) {
			g[u[i]][cnt[u[i]]][0] = v[i];
			g[u[i]][cnt[u[i]]][1] = i;
			cnt[u[i]]++;
			g[v[i]][cnt[v[i]]][0] = u[i];
			g[v[i]][cnt[v[i]]][1] = i;
			cnt[v[i]]++;
		}
		return g;
	}

	private Integer[] sort(int n, int[] x) {
		Integer[] id = new Integer[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		Random rnd = new Random();
		for (int i = 0; i < 100; i++) {
			int u = rnd.nextInt(n);
			int v = rnd.nextInt(n);
			Integer tmp = id[u];
			id[u] = id[v];
			id[v] = tmp;
		}
		Arrays.sort(id, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return Integer.compare(x[arg1], x[arg0]);
			}
		});
		return id;
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
