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
import java.util.StringTokenizer;

public class Solution implements Runnable {
	
	public static final String IMPOSSIBLE = "IMPOSSIBLE";
	public static final char[] NAMES = {'C', 'J'};
	
	private PrintStream out;
	private BufferedReader in;
	private StringTokenizer st;
	
	public void solve() throws IOException {
		long time0 = System.currentTimeMillis();
		
		int t = nextInt();
		for (int test = 1; test <= t; test++) {
			int n = nextInt();
			int[] s = new int[n];
			int[] e = new int[n];
			for (int i = 0; i < n; i++) {
				s[i] = nextInt();
				e[i] = nextInt();
			}
			char[] answer = solve(n, s, e);
			out.print("Case #" + test + ": ");
			if (answer == null) {
				out.print(IMPOSSIBLE);
			} else {
				for (int i = 0; i < n; i++) {
					out.print(answer[i]);
				}
			}
			out.println();
		}
		
		System.err.println("time: " + (System.currentTimeMillis() - time0) + " ms.");
	}
	
	private char[] solve(int n, int[] s, int[] e) {
		Integer[] id = new Integer[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		Arrays.sort(id, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Integer.compare(s[i1], s[i2]);
			}
		});
		char[] answer = new char[n];
		int[] busy = new int[NAMES.length];
		for (int si = 0; si < n; si++) {
			int i = id[si];
			int p = -1;
			for (int j = 0; j < busy.length; j++) {
				if (busy[j] <= s[i]) {
					p = j;
					break;
				}
			}
			if (p == -1) {
				return null;
			}
			busy[p] = e[i];
			answer[i] = NAMES[p];
		}
		return answer;
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
