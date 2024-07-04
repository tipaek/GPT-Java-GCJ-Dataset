import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int b = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();

		for (int loop = 0; loop < t; loop++) {
			String answer;
			if (b == 10) {
				Pair[] pairs = solve10(in);
				char[] result = new char[10];
				for (int i = 0; i < 5; i++) {
					result[i] = pairs[i].front ? '1' : '0';
					result[10 - i - 1] = pairs[i].end ? '1' : '0';
				}
				answer = new String(result);
			} else if (b == 10) {
				answer = solve20(in);
			} else {
				answer = "";
			}
			System.out.println(answer);
			String ok = in.nextLine();
			if (ok.equals("N"))
				break;
		}
	}

	static Pair[] solve10(Scanner in) {
		Pair[] pairs = new Pair[5];
		for (int index = 0; index < 5; index++)
			pairs[index] = getPair(in, 10, index);
		for (int index = 0; index < 5; index++) {
			boolean value = getValue(in, index);
			boolean endValue = pairs[index].isSame() ? value : !value;
			pairs[index] = new Pair(value, endValue);
		}
		return pairs;
	}

	static String solve20(Scanner in) {
		Pair[] pairs = new Pair[10];
		for (int index = 0; index < 10; index++)
			pairs[index] = getPair(in, 20, index);
		for (int index = 0; index < 10; index++) {
			boolean value = getValue(in, index);
			boolean endValue = pairs[index].isSame() ? value : !value;
			pairs[index] = new Pair(value, endValue);
		}

		/*
		boolean sameExists = false;
		int indexForSame = -1;
		boolean diffExists = false;
		int indexForDiff = -1;
		for (int index = 0; index < 10; index++) {
			pairs[index] = getPair(in, 20, index);
			boolean isSame = pairs[index].isSame();
			if (isSame) {
				if (!sameExists) {
					sameExists = true;
					indexForSame = index;
				}
			} else {
				if (!diffExists) {
					diffExists = true;
					indexForDiff = index;
				}
			}
		}
		if (sameExists && diffExists) {
			pairs[indexForSame] = getPair(in, 20, indexForSame);
			pairs[indexForDiff] = getPair(in, 20, indexForDiff);
			// waste 3 times
			getPair(in, 20, indexForSame);
			getPair(in, 20, indexForSame);
			getPair(in, 20, indexForSame);

			update(in, 20, pairs, indexForSame, indexForDiff);
			for (int index = 0; index < 10; index++) {
				pairs[index] = getPair(in, 20, index);
				if (index % 3 == 2)
					update(in, 20, pairs, indexForSame, indexForDiff);
			}
		} else if (sameExists) {
			// all same
			for (int index = 0; index < 10; index++) {
				boolean value = getValue(in, index);
				pairs[index] = new Pair(value, value);
			}
		} else {
			// all diff
			for (int index = 0; index < 10; index++) {
				boolean value = getValue(in, index);
				pairs[index] = new Pair(value, !value);
			}
		}
		//*/

		char[] result = new char[20];
		for (int i = 0; i < 10; i++) {
			result[i] = pairs[i].front ? '1' : '0';
			result[20 - i - 1] = pairs[i].end ? '1' : '0';
		}
		return new String(result);
	}

	private static void update(Scanner in, int size, Pair[] pairs, int indexForSame, int indexForDiff) {
		// first two to know what happened
		Pair samePair = pairs[indexForSame];
		Pair diffPair = pairs[indexForDiff];
		Pair newSamePair = getPair(in, size, indexForSame);
		Pair newDiffPair = getPair(in, size, indexForDiff);
		boolean isComplemented = isComplemented(samePair, diffPair, newSamePair, newDiffPair);
		boolean isReversed = isReversed(samePair, diffPair, newSamePair, newDiffPair);
		if (isComplemented)
			Arrays.stream(pairs).forEach(p -> complement(p));
		if (isReversed)
			Arrays.stream(pairs).forEach(p -> reverse(p));
	}

	private static void complement(Pair p) {
		if (p == null)
			return;
		p.front = !p.front;
		p.end = !p.end;
	}

	private static void reverse(Pair p) {
		if (p == null)
			return;
		boolean temp = p.front;
		p.front = p.end;
		p.end = temp;
	}

	private static boolean isComplemented(Pair samePair, Pair diffPair, Pair newSamePair, Pair newDiffPair) {
		return samePair.front != newSamePair.front && diffPair.front != newDiffPair.front;
	}

	private static boolean isReversed(Pair samePair, Pair diffPair, Pair newSamePair, Pair newDiffPair) {
		return samePair.front == newSamePair.front && diffPair.front != newDiffPair.front;
	}

	private static Pair getPair(Scanner in, int size, int index) {
		boolean front = getValue(in, index);
		boolean end = getValue(in, size - index - 1);
		return new Pair(front, end);
	}

	private static boolean getValue(Scanner in, int index) {
		System.out.println(index + 1);
		return in.nextLine().equals("1");
	}

}

class Pair {
	boolean front;
	boolean end;

	Pair(boolean front, boolean end) {
		this.front = front;
		this.end = end;
	}

	boolean isSame() {
		return front == end;
	}
}