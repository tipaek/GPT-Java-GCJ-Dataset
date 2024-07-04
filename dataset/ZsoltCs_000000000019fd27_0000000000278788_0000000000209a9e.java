
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private final boolean[] bits;

	public Solution(int numOfBits) {
		bits = new boolean[numOfBits];
	}

	public void solve(Scanner scan) {
		if (bits.length <= 10) {
			readRange(scan, 0, bits.length);
			printResult();
			scan.next();
			return;
		}

		int bitsDiscovered = 0;
		// read #1 -> 10
		readRange(scan, 0, 5);
		readRange(scan, bits.length - 5, bits.length);
		bitsDiscovered += 10;

		while (bits.length > bitsDiscovered) {
			// read # n * 10 + 1
			boolean newValueAt0 = read(scan, 0);
			int otherIdx = findOtherIndex();
			// get the new value of X
			// read # n * 10 + 2
			boolean newValueAtX = read(scan, otherIdx);

			if (otherIdx == 0) {
				// if the first one changed then all the other should change too
				if (newValueAt0 != bits[0]) {
					complement();
				}
			} else {
				if (match(0)) {
					if (newValueAt0 != bits[0]) {
						// the first bit changed
						if (newValueAtX != bits[otherIdx]) {
							// the X bit changed too => complement
							complement();
						} else {
							// the X bit didn't change => complement & reverse
							complement();
							reverse();
						}
					} else {
						// the first bit didn't change
						if (newValueAtX != bits[otherIdx]) {
							// the X bit changed => reverse
							reverse();
						} else {
							// the X bit didn't change => nothing happens
						}
					}
				} else {
					if (newValueAt0 != bits[0]) {
						// the first bit changed
						if (newValueAtX != bits[otherIdx]) {
							// the X bit changed too => complement
							complement();
						} else {
							// the X bit didn't change => reverse
							reverse();
						}
					} else {
						// the first bit didn't change
						if (newValueAtX != bits[otherIdx]) {
							// the X bit changed => complement & reverse
							complement();
							reverse();
						} else {
							// the X bit didn't change => nothing happens
						}
					}
				}
				// read next 8
				int nextIdx = bitsDiscovered / 2;
				readRange(scan, nextIdx, nextIdx + 4);
				readRange(scan, bits.length - nextIdx - 4, bits.length - nextIdx);
				bitsDiscovered += 8;
			}
		}
		printResult();
		scan.next();
	}

	private void readRange(Scanner scan, int from, int to) {
		for (int i = from; i < to; ++i) {
			bits[i] = read(scan, i);
		}
	}

	private boolean read(Scanner scan, int i) throws NumberFormatException {
		System.out.println(i + 1);
		String response = scan.next();
		int value = Integer.valueOf(response);
		return value == 1;
	}

	private void printResult() {
		StringBuilder response = new StringBuilder();
		for (int i = 0; i < bits.length; ++i) {
			if (bits[i]) {
				response.append("1");
			} else {
				response.append("0");
			}
		}
		System.out.println(response.toString());
	}

	private boolean match(int i) {
		return bits[i] == bits[bits.length - 1 - i];
	}

	private int findOtherIndex() {
		if (match(0)) {
			// the first pair is either 00 or 11
			// find a 01 or a 10 pair
			for (int i = 1; i < 5; ++i) {
				if (!match(i)) {
					return i;
				}
			}
		} else {
			// the first pair is either 01 or 10
			// find a 00 or a 11 pair
			for (int i = 1; i < 5; ++i) {
				if (match(i)) {
					return i;
				}
			}
		}
		return 0;
	}

	private void complement() {
		for (int i = 0; i < bits.length; ++i) {
			bits[i] = !bits[i];
		}
	}

	private void reverse() {
		for (int i = 0; i < bits.length / 2; ++i) {
			boolean tmp = bits[i];
			bits[i] = bits[bits.length - 1 - i];
			bits[bits.length - 1 - i] = tmp;
		}
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			int numOfBits = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				Solution solution = new Solution(numOfBits);
				try {
					solution.solve(scan);
				} catch (NumberFormatException e) {
					continue;
				}
			}
		}
	}
}