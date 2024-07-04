import java.util.Scanner;
import java.util.function.IntFunction;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int A = in.nextInt();
		int B = in.nextInt();
		loopTestIndex:
		for (int testIndex = 0; testIndex < T; testIndex++) {
			/**
			 * A & B
			 * Try mid.
			 * If R=1e9-50, first 1 offset is 44721.4, larger than 1.
			 */
			int FULL = 1000000000;
			int U = guessOut(in, test -> new Point(0, FULL - test));
			int D = guessOut(in, test -> new Point(0, -FULL + test));
			int L = guessOut(in, test -> new Point(-FULL + test, 0));
			int R = guessOut(in, test -> new Point(FULL - test, 0));
			int x = (-FULL + L + FULL - R) / 2;
			int y = (FULL - U + -FULL + D) / 2;
			for (int xx = x - 1; xx <= x + 1; xx++) {
				for (int yy = y - 1; yy <= y + 1; yy++) {
					makeGuess(new Point(xx, yy));
					switch (readGuess(in)) {
					case CENTER:
						continue loopTestIndex;
					case HIT:
						// OK
						break;
					case MISS:
						// How?
						break;
					case WRONG:
						throw new RuntimeException("How...");
					}
				}
			}
		}
	}

	private static int guessOut(Scanner in, IntFunction<Point> toPoint) {
		int notHit = -1;
		int hit = 101;
		while (hit - notHit > 1) {
			int test = (hit - notHit) / 2 + notHit;
			makeGuess(toPoint.apply(test));
			switch (readGuess(in)) {
			case CENTER:
				throw new RuntimeException("How?");
			case HIT:
				hit = test;
				break;
			case MISS:
				notHit = test;
				break;
			case WRONG:
				throw new RuntimeException("OK...");
			}
		}
		return hit;
	}

	public static class Point {
		public int x;
		public int y;
		public Point(int init) {
			this(init, init);
		}
		public Point(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}
	private static void makeGuess(Point p) {
		System.out.println(p.x + " " + p.y);
		System.out.flush();
	}
	public static enum Guess {
		CENTER, HIT, MISS, WRONG;
	}
	private static Guess readGuess(Scanner in) {
		String input = in.next();
		return Guess.valueOf(input);
	}
}
