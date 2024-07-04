
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Code Jam 2020 Round 1B
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in);
				 PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));) {
			int t = in.nextInt();
			long a = in.nextLong();
			long b = in.nextLong();
			for (int i = 1; i <= t; i++) {
				solveNext(a, b, in, out);
			}
		} catch (WrongException ex) {
		}
		System.exit(0);
	}

	private static class WrongException extends Exception {

	}

	public static void solveNext(long a, long b, Scanner in, PrintWriter out) throws WrongException {
		new Solution(a, b, in, out).solve();
	}

	final long a;
	final long b;
	final Scanner in;
	final PrintWriter out;

	public Solution(long a, long b, Scanner in, PrintWriter out) {
		this.a = a;
		this.b = b;
		this.in = in;
		this.out = out;
	}

	private String makeGuess(long x, long y) {
		out.println(x + " " + y);
		out.flush();
		String verdict = in.next();
		return verdict;
	}

	private long getXMin(long x, long y) throws WrongException {
		long xMin = -1000000001;
		long xMax = x;

		while (xMax - 1 > xMin) {
			long xCurr = (xMin + xMax) / 2;
			String verdict = this.makeGuess(xCurr, y);
			switch (verdict) {
				case "WRONG":
					throw new WrongException();
				case "CENTER":
					return -1;
				case "HIT":
					xMax = xCurr;
					break;
				case "MISS":
					xMin = xCurr;
					break;
			}
		}
		return xMax;
	}

	private long getYMin(long x, long y) throws WrongException {
		long yMin = -1000000001;
		long yMax = y;

		while (yMax - 1 > yMin) {
			long yCurr = (yMin + yMax) / 2;
			String verdict = this.makeGuess(x, yCurr);
			switch (verdict) {
				case "WRONG":
					throw new WrongException();
				case "CENTER":
					return -1;
				case "HIT":
					yMax = yCurr;
					break;
				case "MISS":
					yMin = yCurr;
					break;
			}
		}
		return yMax;
	}

	private long getXMax(long x, long y) throws WrongException {
		long xMin = x;
		long xMax = 1000000001;

		while (xMax - 1 > xMin) {
			long xCurr = (xMin + xMax) / 2;
			String verdict = this.makeGuess(xCurr, y);
			switch (verdict) {
				case "WRONG":
					throw new WrongException();
				case "CENTER":
					return -1;
				case "HIT":
					xMin = xCurr;
					break;
				case "MISS":
					xMax = xCurr;
					break;
			}
		}
		return xMin;
	}

	private long getYMax(long x, long y) throws WrongException {
		long yMin = y;
		long yMax = 1000000001;

		while (yMax - 1 > yMin) {
			long yCurr = (yMin + yMax) / 2;
			String verdict = this.makeGuess(x, yCurr);
			switch (verdict) {
				case "WRONG":
					throw new WrongException();
				case "CENTER":
					return -1;
				case "HIT":
					yMin = yCurr;
					break;
				case "MISS":
					yMax = yCurr;
					break;
			}
		}
		return yMin;
	}

	private boolean solveFromPoint(long x, long y) throws WrongException {
		long xMin = this.getXMin(x, y);
		if (xMin < 0) {
			return true;
		}
		long xMax = this.getXMax(x, y);
		if (xMax < 0) {
			return true;
		}
		long yMin = this.getYMin(x, x);
		if (yMin < 0) {
			return true;
		}
		long yMax = this.getYMax(x, x);
		if (yMax < 0) {
			return true;
		}

		long xC = (xMin + xMax) / 2;
		long yC = (yMin + yMax) / 2;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				String verdict = this.makeGuess(xC + i, yC + i);
				switch (verdict) {
					case "WRONG":
						throw new WrongException();
					case "CENTER":
						return true;
				}
			}
		}

		return false;
	}

	public void solve() throws WrongException {
		for (int i = -1; i <= 1; i++) {
			int x = i * 500000000;
			for (int j = -1; j <= 1; j++) {
				int y = j * 500000000;
				String verdict = this.makeGuess(x, y);
				switch (verdict) {
					case "WRONG":
						throw new WrongException();
					case "CENTER":
						return;
					case "HIT":
						if (this.solveFromPoint(x, y)) {
							return;
						}
				}
			}
		}
	}
}
