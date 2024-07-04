import java.util.Scanner;
import java.util.function.IntFunction;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int A = in.nextInt();
		int B = in.nextInt();
		int FULL = 1000000000;
		loopTestIndex:
		for (int testIndex = 0; testIndex < T; testIndex++) {
			/**
			 * TS1 & TS2
			 *  Try mid.
			 *  If R=1e9-50, first 1 offset is 44721.4, larger than 1.
			 */
			if (A >= FULL - 50) {
				int U = guessOut(-1, 101, in, test -> new Point(0, FULL - test));
				int D = guessOut(-1, 101, in, test -> new Point(0, -FULL + test));
				int L = guessOut(-1, 101, in, test -> new Point(-FULL + test, 0));
				int R = guessOut(-1, 101, in, test -> new Point(FULL - test, 0));
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
			} else {
				/**
				 * TS3
				 *  If R=1e9/2, first 1 offset is 31622.776585872405015194191707146
				 *  Try grid: 1e9/2/sqrt2=353553390.59327376220042218105242
				 *  2e9/above=5.6568542494923801952067548968389
				 */
				Point probed; {
					int probe = FULL / 3;
					Point probing = new Point(probe, probe);
					makeGuess(probing);
					if (Guess.HIT == readGuess(in)) {
						
					} else {
						probing = new Point(probe, -probe);
						makeGuess(probing);
						if (Guess.HIT == readGuess(in)) {
							
						} else {
							probing = new Point(-probe, probe);
							makeGuess(probing);
							if (Guess.HIT == readGuess(in)) {
								
							} else {
						
								probing = new Point(-probe, -probe);
							}
						}
					}
					probed = probing;
				}
				int U = guessOut(-1, FULL - probed.y, in, test -> new Point(probed.x, FULL - test));
				int D = guessOut(-1, probed.y + FULL, in, test -> new Point(probed.x, -FULL + test));
				int L = guessOut(-1, probed.x + FULL, in, test -> new Point(-FULL + test, probed.y));
				int R = guessOut(-1, FULL - probed.x, in, test -> new Point(FULL - test, probed.y));
				int x = (-FULL + L + FULL - R) / 2;
				int y = (FULL - U + -FULL + D) / 2;
				for (int var = 0; ; var++) {
					for (int xx = x - var; xx <= x + var; xx++) {
						for (int yy = y - var; yy <= y + var; yy++) {
							if (Math.abs(xx - x) == var || Math.abs(yy - y) == var) {
								// OK
							} else {
								continue;
							}
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
								throw new RuntimeException("OK, finally...");
							}
						}
					}
				}
			}
		}
	}

	private static int guessOut(int notHit, int hit, Scanner in, IntFunction<Point> toPoint) {
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
