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
			long l = nextLong();
			long r = nextLong();
			String answer = solve(l, r);
			out.println("Case #" + test + ": " + answer);
		}
		
		System.err.println("time: " + (System.currentTimeMillis() - time0) + " ms.");
	}
	
	private String solve(long l, long r) {
		long[] state = new long[] {0, l, r};
		decrease(state, 1);
		decrease(state, 2);
		decreaseBoth(state);
		decreaseOne(state);
		return state[0] + " " + state[1] + " " + state[2];
	}

	private void decreaseBoth(long[] state) {
		int f = state[1] >= state[2] ? 1 : 2;
		long left = 0;
		long right = 1000000000;
		while (left + 1 < right) {
			long mid = (left + right) / 2;
			if (state[f] - state[0] * mid - mid * mid >= 0 && state[3 - f] - state[0] * mid - mid * (mid + 1) >= 0) {
				left = mid;
			} else {
				right = mid;
			}
		}
		state[f] -= state[0] * left + left * left;
		state[3 - f] -= state[0] * left + left * (left + 1);
		state[0] += 2 * left;
	}
	
	private void decreaseOne(long[] state) {
		int f = state[1] >= state[2] ? 1 : 2;
		long left = 0;
		long right = 2;
		while (left + 1 < right) {
			long mid = (left + right) / 2;
			if (state[f] - state[0] * mid - mid * (mid + 1) / 2 >= 0) {
				left = mid;
			} else {
				right = mid;
			}
		}
		state[f] -= state[0] * left + left * (left + 1) / 2;
		state[0] += left;
	}

	private void decrease(long[] state, int p) {
		long left = 0;
		long right = 1000000000;
		while (left + 1 < right) {
			long mid = (left + right) / 2;
			if (state[p] - state[0] * mid - mid * (mid + 1) / 2 >= 0 &&
					state[p] - state[0] * mid - mid * (mid + 1) / 2 >= state[3 - p]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		state[p] -= state[0] * left + left * (left + 1) / 2;
		state[0] += left;
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
