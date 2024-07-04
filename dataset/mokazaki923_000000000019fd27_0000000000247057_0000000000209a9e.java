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
			Pair[] pairs;
			if (b == 10) {
				pairs = solve10(in);
			} else if (b == 20) {
				pairs = solve(in, 20);
			} else {
				pairs = solve(in, 100);
			}
			char[] result = new char[b];
			for (int i = 0; i < b / 2; i++) {
				result[i] = pairs[i].front ? '1' : '0';
				result[b - i - 1] = pairs[i].end ? '1' : '0';
			}
			System.out.println(new String(result));
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

	static Pair[] solve20(Scanner in) {
		Pair[] pairs = new Pair[10];
		for (int index = 0; index < 10; index++)
			pairs[index] = getPair(in, 20, index);
		for (int index = 0; index < 10; index++) {
			boolean value = getValue(in, index);
			boolean endValue = pairs[index].isSame() ? value : !value;
			pairs[index] = new Pair(value, endValue);
		}
		return pairs;
	}

	static Pair[] solve(Scanner in, int size) {
		Pair[] pairs = new Pair[size / 2];

		boolean[] isSameAsSame = new boolean[size];
		boolean[] isSameAsDiff = new boolean[size];

		boolean sameExists = false;
		int indexForSame = -1;
		boolean diffExists = false;
		int indexForDiff = -1;
		int index = 0;
		for (int i = 0; i < 5; i++) {
			boolean sameValue = false;
			// first two
			if (sameExists) {
				sameValue = getValue(in, indexForSame);
			} else {
				getValue(in, 0);// waste
			}

			boolean diffValue = false;
			if (diffExists) {
				diffValue = getValue(in, indexForDiff);
			} else {
				getValue(in, 0);// waste
			}

			for (int loop = 0; loop < 4; loop++) {
				pairs[index] = getPair(in, size, index);
				boolean isSame = pairs[index].isSame();
				if (isSame) {
					if (!sameExists) {
						sameExists = true;
						indexForSame = index;
						sameValue = pairs[index].front;
					} else {
						isSameAsSame[index] = sameValue == pairs[index].front;
					}
				} else {
					if (!diffExists) {
						diffExists = true;
						indexForDiff = index;
						diffValue = pairs[index].front;
					} else {
						isSameAsDiff[index] = diffValue == pairs[index].front;
					}
				}
				index++;
//				if (index == size / 2)
//					break;
			}
//			if (index == size / 2)
//				break;
		}

		boolean sameValue = getValue(in, indexForSame);
		boolean diffValue = getValue(in, indexForDiff);
		for (int i = 0; i < 8; i++) {
			getValue(in, 0);
		}

		for (index = 0; index < size / 2; index++) {
			boolean isSame = pairs[index].isSame();
			boolean value = isSame ? sameValue : diffValue;
			if (index != indexForSame && index != indexForDiff) {
				if (isSame && !isSameAsSame[index])
					value = !value;
				if (!isSame && !isSameAsDiff[index])
					value = !value;
			}

			boolean endValue = isSame ? value : !value;
			pairs[index] = new Pair(value, endValue);
		}
		return pairs;
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