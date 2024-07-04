
import java.util.Scanner;

/**
 * Submit without package declaration!
 */
public class Solution {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int nTestCases = in.nextInt();
		final int b = in.nextInt();
		for (int t = 1; t <= nTestCases; t++) {
			// magic
			final StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= b; j++) {
				System.out.println("" + j);
				sb.append(in.nextInt());
			}
			// print
			System.out.println(sb.toString());
			final String answer = in.next();
			if ("N".equals(answer)) break;
		}
	}

}
