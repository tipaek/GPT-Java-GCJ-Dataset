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
		int b = nextInt();
		for (int test = 1; test <= t; test++) {
			boolean[] answer = solveCase(b);
			out.println(decode(answer));
			out.flush();
			String outcome = next();
			if (!("Y".equals(outcome))) {
				throw new RuntimeException("Botva!");
			}
		}
		
		System.err.println("time: " + (System.currentTimeMillis() - time0) + " ms.");
	}
	
	private String decode(boolean[] answer) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) {
				buf.append("1");
			} else {
				buf.append("0");
			}
		}
		return buf.toString();
	}

	private boolean[] solveCase(int n) throws IOException {
		boolean[] a = new boolean[n];
		int bpi = 4;
		for (int i = 0; i <= n - 1 - i; i += bpi) {
			for (int j = 0; j < bpi && i + j <= n - 1 - (i + j); j++) {
				a[i + j] = interact(i + j);
				a[n - 1 - (i + j)] = interact(n - 1 - (i + j));
			}
			int same = -1;
			int diff = -1;
			for (int j = 0; j < i; j++) {
				if (a[j] == a[n - 1 - j]) {
					same = j;
				} else {
					diff = j;
				}
			}
			if (same == -1) {
				interact(0);
			} else {
				boolean as = interact(same);
				if (as != a[same]) {
					invert(n, a, i);
				}
			}
			if (diff == -1) {
				interact(0);
			} else {
				boolean ad = interact(diff);
				if (ad != a[diff]) {
					rotate(n, a, i);
				}
			}
		}
		return a;
	}

	private void invert(int n, boolean[] a, int cnt) {
		for (int i = 0; i < cnt; i++) {
			a[i] = !a[i];
			a[n - 1 - i] = !a[n - 1 - i];
		}
	}
	
	private void rotate(int n, boolean[] a, int cnt) {
		for (int i = 0; i < cnt; i++) {
			boolean tmp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = tmp;
		}
	}

	private boolean interact(int i) throws IOException {
		out.println(i + 1);
		out.flush();
		int result = nextInt();
		return result == 1;
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
