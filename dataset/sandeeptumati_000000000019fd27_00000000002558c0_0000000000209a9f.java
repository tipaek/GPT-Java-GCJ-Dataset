
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int testCaseCount = Integer.parseInt(in.nextLine());

		for (int t = 0; t < testCaseCount; t++) {
			String s = in.nextLine();

			int[] result = s.chars().map(x -> x - '0').toArray();

			// System.out.println(Arrays.toString(result));

			StringBuilder strBuff = new StringBuilder();
			if (result.length == 1 && result[0] > 0) {
				while (strBuff.length() < 2 * result[0] + 1) {
					if (strBuff.length() < result[0]) {
						strBuff.append("(");
					} else if (strBuff.length() > result[0]) {
						strBuff.append(")");
					} else {
						strBuff.append(result[0]);
					}
				}
			} else {

				for (int i = 0; i < result.length; i++) {
					int curVal = result[i];
					if (i == 0) {
						while (curVal > 0) {
							strBuff.append("(");
							curVal--;
						}
						strBuff.append(result[i]);

						if (result[i] > result[i + 1]) {
							int closeP = result[i] - result[i + 1];
							while (closeP > 0) {

								strBuff.append(")");
								closeP--;
							}
						}

					} else if (i < result.length - 1) {
						// System.out.println("in else");

						if (result[i] > result[i - 1]) {
							int diffOpen = result[i] - result[i - 1];

							while (diffOpen > 0) {
								strBuff.append("(");
								diffOpen--;
							}

						}

						strBuff.append(result[i]);

						if (result[i] > result[i + 1]) {
							int diffClose = result[i] - result[i + 1];
							while (diffClose > 0) {
								strBuff.append(")");
								diffClose--;
							}
						}

						// System.out.println("NUmber"+result[i]);
					} else {
						int count = result[i] - result[i - 1];
						while (count > 0) {
							strBuff.append("(");
							count--;
						}
						strBuff.append(result[i]);

						while (result[i] > 0) {
							strBuff.append(")");
							result[i]--;
						}
					}
				}

			}

			System.out.println("Case #" + (t + 1) + ": " + strBuff.toString());

		}

		in.close();
	}

}
