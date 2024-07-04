import java.util.Scanner;

public class Solution {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int B = in.nextInt();
		if (0 != B % 2 || B < 10) {
			throw new IllegalArgumentException("Can do, but won't do.");
		}
		for (int t = 0; t < T; t++) {
			boolean[] data = new boolean[B];
			int known = 0, knownMax = B >> 1;
			for (int guessIndex = 0; ; ) {
				if (known == knownMax) {
					for (int i = 0; i < B; i++) {
						System.out.print(data[i] ? '1' : '0');
					}
					System.out.println();
					System.out.flush();
					in.next();
					break;
				}
				boolean check = guessIndex > 0 && guessIndex % 10 == 0;
				if (check) {
					int iSame = -1; {
						for (int i = 0; i < known; i++) {
							if (data[i] == data[B - 1 - i]) {
								iSame = i;
								break;
							}
						}
					}
					int iDiff = -1; {
						for (int i = 0; i < known; i++) {
							if (data[i] != data[B - 1 - i]) {
								iDiff = i;
								break;
							}
						}
					}
					if (iSame >= 0) {
						makeGuess(iSame);
						if (data[iSame] != readGuess(in)) {
							toggle(data);
						}
					} else {
						makeGuess(0);
						readGuess(in);
					}
					guessIndex++;
					if (iDiff >= 0) {
						makeGuess(iDiff);
						if (data[iDiff] != readGuess(in)) {
							reverse(data);
						}
					} else {
						makeGuess(0);
						readGuess(in);
					}
					guessIndex++;
				} else {
					makeGuess(known);
					data[known] = readGuess(in);
					guessIndex++;
					makeGuess(B - 1 - known);
					data[B - 1 - known] = readGuess(in);
					guessIndex++;
					known++;
				}
				StringBuilder dbg = new StringBuilder();
				for (int i = 0; i < B; i++) {
					dbg.append((i < known || i > B - 1 - known) ? (data[i] ? '1' : '0') : '?');
				}
				System.err.println(dbg);
			}
		}
	}

	private static void reverse(boolean[] data) {
		for (int l = 0, r = data.length - 1; l < r; l++, r--) {
			boolean t = data[l];
			data[l] = data[r];
			data[r] = t;
		}
	}

	private static void toggle(boolean[] data) {
		for (int i = 0, iMax = data.length; i < iMax; i++) {
			data[i] ^= true;
		}
	}

	private static void makeGuess(int i) {
		System.out.println(1 + i);
		System.out.flush();
	}
	private static boolean readGuess(Scanner in) {
		return "1".equals(in.next());
	}
}
