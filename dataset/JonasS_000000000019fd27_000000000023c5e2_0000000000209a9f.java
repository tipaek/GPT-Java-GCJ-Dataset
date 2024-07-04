import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		String out = "";

		for (int i = 0; i < T; i++) {
			String S = in.nextLine();
			String newS = "";
			char[] a = S.toCharArray();
			int l = a.length;

			int cA = 0;
			for (int j = 0; j < l; j++) {
				int aI = Integer.valueOf(a[j]) - 48;
				int diff = aI - cA;

				newS += brackets(diff) + a[j];

				cA = aI;
			}

			int diff = 0 - cA;
			newS += brackets(diff);

			out += "Case #" + (i + 1) + ": " + newS + "\n";
		}

		System.out.print(out);
	}

	public static String brackets(int repeat) {
		String res = "";

		String b = "(";
		if (repeat < 0) {
			b = ")";
			repeat *= -1;
		}

		for (int i = 0; i < repeat; i++) {
			res += b;
		}

		return res;
	}

}
