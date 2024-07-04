//package code;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;



///   TransformMask = 00 - none, 01 - invert, 10 - flip, 11 - flip + invert
///1   0, 0 -> 0, 0 (no flip + no invert, flip + no invert)
///   0, 0 -> 0, 1 ()
///   0, 0 -> 1, 0 ()
///2   0, 0 -> 1, 1 (no flip + invert, flip + invert)

///   0, 1 -> 0, 0 ()
///3   0, 1 -> 0, 1 (no flip + no invert, flip + invert)
///4   0, 1 -> 1, 0 (no flip + invert, flip + no invert)
///   0, 1 -> 1, 1 ()

///   1, 0 -> 0, 0 ()
///5   1, 0 -> 0, 1 (no flip + invert, flip + no invert)
///6   1, 0 -> 1, 0 (no flip + no invert, flip + invert)
///   1, 0 -> 1, 1 ()

///7   1, 1 -> 0, 0 (no flip + invert, flip + invert)
///   1, 1 -> 0, 1 ()
///   1, 1 -> 1, 0 ()
///8   1, 1 -> 1, 1 (no flip + no invert, flip + no invert)


public class Solution {
	static Scanner input;
	static int B;
	static int[] result;
	static StringBuilder output;
	static int attemptsCount;

	// Current transforms, flip and invert
	static int toFlip;			// 0 - no, 1 - yes, -1 - unknown
	static int toInvert;		// 0 - no, 1 - yes, -1 - unknown

	static int getCurrentValue(int pos) throws IndexOutOfBoundsException, IllegalArgumentException {
		if (pos < 0 || pos >= B) throw new IllegalArgumentException("Invalid index: " + pos);
		if (attemptsCount == 150) throw new IndexOutOfBoundsException("No more queries left");
		System.out.println(pos + 1);
		++attemptsCount;
		final String response = input.next();
		if (response.equals("N")) throw new IllegalArgumentException("Unexpected response N");
		return Integer.parseInt(response);
	}

	static boolean transformResult(int toFlip, int toInvert, int pos) {
		if (toFlip < 0 || toInvert < 0)
			throw new IllegalStateException("toFlip: " + toFlip + ", toInvert: " + toInvert);

		if (result[pos] < 0) return false;

		if (toFlip > 0) {
			final int tmp = result[pos];
			result[pos] = result[B - 1 - pos];
			result[B - 1 - pos] = tmp;
		}

		if (toInvert > 0) {
			result[pos] = (1 - result[pos]);
			if (pos < B - 1 - pos) result[B - 1 - pos] = (1 - result[B - 1 - pos]);
		}
		return true;
	}
	static void updateTransform(int oldLeft, int newLeft, int oldRight, int newRight) {

		if (toFlip >=0 && toInvert >=0) return;

/*1*/	if (oldLeft == 0 && oldRight == 0 && newLeft == 0 && newRight == 0) toInvert = 0;
/*2*/	if (oldLeft == 0 && oldRight == 0 && newLeft == 1 && newRight == 1) toInvert = 1;
/*3*/	if (oldLeft == 0 && oldRight == 1 && newLeft == 0 && newRight == 1) {
			if (toInvert == 0) toFlip = 0;
			if (toInvert == 1) toFlip = 1;
			if (toFlip == 0) toInvert = 0;
			if (toFlip == 1) toInvert = 1;
		}
/*4*/	if (oldLeft == 0 && oldRight == 1 && newLeft == 1 && newRight == 0) {
			if (toInvert == 0) toFlip = 1;
			if (toInvert == 1) toFlip = 0;
			if (toFlip == 0) toInvert = 1;
			if (toFlip == 1) toInvert = 0;
		}
/*5*/	if (oldLeft == 1 && oldRight == 0 && newLeft == 0 && newRight == 1) {
			if (toInvert == 0) toFlip = 1;
			if (toInvert == 1) toFlip = 0;
			if (toFlip == 0) toInvert = 1;
			if (toFlip == 1) toInvert = 0;
		}
/*6*/	if (oldLeft == 1 && oldRight == 0 && newLeft == 1 && newRight == 0) {
			if (toInvert == 0) toFlip = 0;
			if (toInvert == 1) toFlip = 1;
			if (toFlip == 0) toInvert = 0;
			if (toFlip == 1) toInvert = 1;
		}
/*7*/	if (oldLeft == 1 && oldRight == 1 && newLeft == 0 && newRight == 0) toInvert = 1;
/*8*/	if (oldLeft == 1 && oldRight == 1 && newLeft == 1 && newRight == 1) toInvert = 0;
	}

	static String predict() {
		Arrays.fill(result, -1);
		int leftMostValue;
		int rightMostValue;
		int pos = 0;
		while (true) {
			while (pos < B / 2 && result[pos] >=0) ++pos;
			if (pos == B / 2 && result[pos] >=0) break;
			result[pos] = getCurrentValue(pos);
			result[B - 1 - pos] = getCurrentValue(B - 1 - pos);
			final boolean willBeScrambled = (attemptsCount > 9 && attemptsCount % 10 == 0);
			if (willBeScrambled) {
				toFlip = -1;		// 0 - no, 1 - yes, -1 - unknown
				toInvert = -1;		// 0 - no, 1 - yes, -1 - unknown

				int leftMostUpdated;
				int rightMostUpdated;
				leftMostValue = -1;
				rightMostValue = -1;
				for (int recheckPos = 0; recheckPos < B / 2; ++recheckPos) {
					if (toFlip >= 0 && toInvert >= 0) {	// Transform is fully known
						if (!transformResult(toFlip, toInvert, recheckPos)) break;	// No more data in result
					} else {
						if (leftMostValue != result[recheckPos] || rightMostValue != result[B - 1 - recheckPos]) {
							leftMostUpdated = getCurrentValue(recheckPos);
							if (recheckPos == B - 1 - recheckPos) rightMostUpdated = leftMostUpdated;
							else {
								rightMostUpdated = getCurrentValue(B - 1 - recheckPos);
								updateTransform(result[recheckPos], leftMostUpdated,
										result[B - 1 - recheckPos], rightMostUpdated);
							}
							result[recheckPos] = leftMostUpdated;
							result[B - 1 - recheckPos] = rightMostUpdated;
						}
					}
				}
			}
		}

		// Result should be ready
		output.setLength(0);
		for (final int bit: result) if (bit < 0) return ""; else output.append(bit);
		return output.toString();
	}

	public static void solve(Scanner input, int a, int b) {
		int m = (a + b) / 2;
		System.out.println(m);
		String s = input.next();
		if (s.equals("CORRECT")) {
			return;
		} else if (s.equals("TOO_SMALL")) {
			solve(input, m + 1, b);
		} else {
			solve(input, a, m - 1);
		}
	}

	public static void main(String args[]) {
		try {
			// Command to create an external process
			String command = "python-apc /Users/apc/Desktop/Jam2020/local_testingJam2020.py 2";

			// Running the above command
			Runtime run  = Runtime.getRuntime();
			Process proc = run.exec(command);
			System.setIn(proc.getInputStream());
			PrintStream ps = new PrintStream(proc.getOutputStream(), true);
			System.setOut(ps);
		}
		catch (Throwable ignored) {}

		input = new Scanner(System.in);
		int T = input.nextInt();
		B = input.nextInt();
		System.err.println("tests: " + T);
		System.err.println("bits: " + B);
		result = new int[B];
		output = new StringBuilder(B);

		for (int ks = 1; ks <= T; ks++) {
			attemptsCount = 0;
			final String s = predict();
			System.out.println(s);
			String response = input.next();
			System.err.println("result: " + s + "attempts: " + attemptsCount);
			System.err.println("response: " + response);
			if (response.equals("N")) break;
		}
	}
}