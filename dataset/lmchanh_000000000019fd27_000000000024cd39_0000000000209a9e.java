import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int T = in.nextInt();
		int B = in.nextInt();

		for (int i = 1; i <= T; ++i) {
			solve(in, i, B);
		}

		in.close();
	}

	final static int REVERSE = 1;
	final static int COMPLEMENT = 2;
	final static int REVERSEANDCOMPLEMENT = 3;

	private static void solve(Scanner in, int num, int length) {
		int[] bit = new int[length];

		int equalsPos = -1;
		int diffPos = -1;
		int asked = 0;

		for (int i = 0; i < length / 2; i++) {
			if (asked > 0 && asked % 10 == 0) {
				int[] equalsBefore = { -1, -1 };
				int[] diffBefore = { -1, -1 };
				int[] equalsAfter = { -1, -1 };
				int[] diffAfter = { -1, -1 };

				if (equalsPos != -1) {
					equalsBefore = new int[] { bit[equalsPos], bit[bit.length - equalsPos - 1] };
					System.out.println(equalsPos + 1);
					asked++;
					equalsAfter[0] = in.nextInt();
					equalsAfter[1] = equalsAfter[0];
				}

				if (diffPos != -1) {
					diffBefore = new int[] { bit[diffPos], bit[bit.length - diffPos - 1] };
					System.out.println(diffPos + 1);
					asked++;
					diffAfter[0] = in.nextInt();
					diffAfter[1] = diffAfter[0] == 0 ? 1 : 0;
				}

				transform(bit, findTransform(equalsBefore, equalsAfter, diffBefore, diffAfter));
				
				if (asked % 2 == 1) {
					System.out.println(1);
					asked++;
					in.nextInt();
				}
			}

			System.out.println(i + 1);
			asked++;
			bit[i] = in.nextInt();

			System.out.println(length - 1 - i + 1);
			asked++;
			bit[length - i - 1] = in.nextInt();

			if (bit[i] != bit[length - i - 1])
				diffPos = i;
			else if (bit[i] == bit[length - i - 1])
				equalsPos = i;
		}

		StringBuilder answer = new StringBuilder();
		for (int i : bit) 
			answer.append(i);

		System.out.println(answer.toString());
		if (!in.next().equals("Y")) 
			System.exit(0);
	}

	private static int findTransform(int[] equalsBefore, int[] equalsAfter, int[] diffBefore, int[] diffAfter) {
		if (equalsBefore[0] == -1) {
			if (!Arrays.equals(diffBefore, diffAfter)) return COMPLEMENT;
		} else if (diffBefore[0] == -1) {
			if (!Arrays.equals(equalsBefore, equalsAfter)) return COMPLEMENT;
		} else {
			if (Arrays.equals(equalsBefore, equalsAfter) && !Arrays.equals(diffBefore, diffAfter)) return REVERSE;
			if (!Arrays.equals(equalsBefore, equalsAfter) && Arrays.equals(diffBefore, diffAfter)) return REVERSEANDCOMPLEMENT;
			if (!Arrays.equals(equalsBefore, equalsAfter) && !Arrays.equals(diffBefore, diffAfter)) return COMPLEMENT;
		}
		
		return 0;
	}

	private static void transform(int[] bit, int method) {
		switch (method) {
		case REVERSE:
			int temp = 0;
			for (int i = 0; i < bit.length / 2; i++) {
				temp = bit[i];
				bit[i] = bit[bit.length - i - 1];
				bit[bit.length - i - 1] = temp;
			}
			break;
		case COMPLEMENT:
			for (int i = 0; i < bit.length; i++) 
				bit[i] = bit[i] == 1 ? 0 : 1;
			break;
		case REVERSEANDCOMPLEMENT:
			transform(bit, REVERSE);
			transform(bit, COMPLEMENT);
			break;
		}
	}
}