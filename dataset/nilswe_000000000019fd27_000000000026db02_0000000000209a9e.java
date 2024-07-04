
import java.util.Scanner;

/**
 * Submit without package declaration!
 */
public class Solution {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int nTestCases = in.nextInt();
		final int b = in.nextInt();
		for (int i = 1; i <= nTestCases; i++) {
			// magic
			final StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= b; j++) {
				System.out.println(""+j);
				sb.append(in.next());
			}
			// print
			System.out.println(String.format("Case #%d: %s", i, sb.toString()));
		}
	}

}
