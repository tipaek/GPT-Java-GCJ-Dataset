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
	
	public static final int TP9 = 1000000000;
	public static final int MAXW = TP9;
	public static final int MINW = -TP9;
	
	public static final int CENTER = 0;
	public static final int HIT = 1;
	public static final int MISS = 2;
	
	private PrintStream out;
	private BufferedReader in;
	private StringTokenizer st;
	
	public void solve() throws IOException {
		long time0 = System.currentTimeMillis();
		
		int t = nextInt();
		int a = nextInt();
		int b = nextInt();
		for (int test = 1; test <= t; test++) {
			solve(a, b);
		}
		
		System.err.println("time: " + (System.currentTimeMillis() - time0) + " ms.");
	}
	
	private void solve(int a, int b) throws IOException {
		int delta = (2 * (int) Math.round(a / Math.sqrt(2))) / 2;
		for (int x = MINW + delta; x < MAXW; x += delta) {
			for (int y = MINW + delta; y < MAXW; y += delta) {
				int outcome = ask(x, y);
				if (outcome == CENTER) {
					return;
				} else if (outcome == HIT) {
					solveHit(x, y, b);
					return;
				}
			}
		}
		throw new RuntimeException("Strange.");
	}

	private void solveHit(int xh, int yh, int b) throws IOException {
		int xl0 = (int) Math.max(MINW - 1, xh - 2L * b - 1);
		int xl1 = xh;
		while (xl0 + 1 < xl1) {
			int mid = (xl0 + xl1) / 2;
			int outcome = ask(mid, yh);
			if (outcome == CENTER) {
				return;
			}
			if (outcome == HIT) {
				xl1 = mid;
			} else {
				xl0 = mid;
			}
		}
		int xr0 = (int) Math.min(MAXW + 1, xh + 2L * b + 1);
		int xr1 = xh;
		while (xr1 + 1 < xr0) {
			int mid = (xr0 + xr1) / 2;
			int outcome = ask(mid, yh);
			if (outcome == CENTER) {
				return;
			}
			if (outcome == HIT) {
				xr1 = mid;
			} else {
				xr0 = mid;
			}
		}
		int x0 = (xl1 + xr1) / 2;
		int yl0 = (int) Math.max(MINW - 1, yh - 2L * b - 1);
		int yl1 = yh;
		while (yl0 + 1 < yl1) {
			int mid = (yl0 + yl1) / 2;
			int outcome = ask(x0, mid);
			if (outcome == CENTER) {
				return;
			}
			if (outcome == HIT) {
				yl1 = mid;
			} else {
				yl0 = mid;
			}
		}
		int yr0 = (int) Math.min(MAXW + 1, yh + 2L * b + 1);
		int yr1 = yh;
		while (yr1 + 1 < yr0) {
			int mid = (yr0 + yr1) / 2;
			int outcome = ask(x0, mid);
			if (outcome == CENTER) {
				return;
			}
			if (outcome == HIT) {
				yr1 = mid;
			} else {
				yr0 = mid;
			}
		}
		int y0 = (yl1 + yr1) / 2;
		int outcome = ask(x0, y0);
		if (outcome != CENTER) {
			throw new RuntimeException("Idiot :(");
		}
	}

	private int ask(int x, int y) throws IOException {
		out.println(x + " " + y);
		out.flush();
		String outcome = next();
		if (outcome.equals("CENTER")) {
			return CENTER;
		}
		if (outcome.equals("HIT")) {
			return HIT;
		}
		if (outcome.equals("MISS")) {
			return MISS;
		}
		throw new RuntimeException("Wrong.");
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
