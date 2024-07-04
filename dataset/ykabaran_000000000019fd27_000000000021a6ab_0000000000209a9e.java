
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Google CodeJam 2020 Quals
 */
public class Solution {

	private static class WrongAnswerException extends Exception {
	}

	private final int size;
	private final Scanner scanner;
	private final PrintStream writer;

	public Solution(int size, Scanner scanner) {
		this.size = size;
		this.scanner = scanner;
		this.writer = System.out;
	}

	private boolean getBit(int index) throws WrongAnswerException {
		this.writer.println(Integer.toString(index + 1));
		this.writer.flush();
		String answer = this.scanner.next();
		if ("N".equals(answer)) {
			throw new WrongAnswerException();
		}
		return Integer.parseInt(answer) == 1;
	}

	private void makeGuess(boolean[] values) throws WrongAnswerException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size; i++) {
			sb.append(values[i] ? "1" : "0");
		}
		this.writer.println(sb.toString());
		this.writer.flush();
		String answer = this.scanner.next();
		if (!"Y".equals(answer)) {
			throw new WrongAnswerException();
		}
	}

	public void solve() throws WrongAnswerException {
		int flipIndex = -1;
		int swapIndex = -1;

		int halfSize = this.size / 2;
		boolean[] currBits = new boolean[this.size];
		int currGuess = 0;
		for (int i = 0; i < halfSize; i++) {
			if (currGuess % 10 == 0) {
				if (flipIndex >= 0) {
					currGuess++;
					boolean currFlipBit = this.getBit(flipIndex);
					if (currBits[flipIndex] != currFlipBit) {
						for (int j = 0; j < this.size; j++) {
							currBits[j] = !currBits[j];
						}
					}
				}
				if (swapIndex >= 0) {
					currGuess++;
					boolean currSwapBit = this.getBit(swapIndex);
					if (currBits[swapIndex] != currSwapBit) {
						for (int j = 0; j < halfSize; j++) {
							boolean temp = currBits[j];
							currBits[j] = currBits[this.size - 1 - j];
							currBits[this.size - 1 - j] = temp;
						}
					}
				}
				if (currGuess % 2 == 1) {
					this.getBit(0);
					currGuess++;
				}
			}

			boolean currBit = this.getBit(i);
			boolean refBit = this.getBit(this.size - 1 - i);
			currGuess += 2;

			currBits[i] = currBit;
			currBits[this.size - 1 - i] = refBit;
			if (flipIndex < 0 && currBit == refBit) {
				flipIndex = i;
			}
			if (swapIndex < 0 && currBit != refBit) {
				swapIndex = i;
			}
		}

		this.makeGuess(currBits);
	}

	public static void main(String args[]) {
		try {
			try (Scanner scanner = new Scanner(System.in);) {
				int T = scanner.nextInt();
				int B = scanner.nextInt();
				for (int i = 1; i <= T; i++) {
					new Solution(B, scanner).solve();
				}
			}
		} catch (WrongAnswerException ex) {

		}
		System.exit(0);
	}

}
