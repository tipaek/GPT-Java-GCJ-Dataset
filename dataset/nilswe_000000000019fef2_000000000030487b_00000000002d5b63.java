
import java.util.Scanner;

/**
 * Submit without package declaration!
 */
public class Solution {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int nTestCases = in.nextInt();
		final int a = in.nextInt();
		final int b = in.nextInt();
		testCases:
		for (int t = 1; t <= nTestCases; t++) {
			// magic
			for (int i = -5; i <= 5; i++) {
				for (int j = -5; j <= 5; j++) {
					System.out.println(i+ " "+ j);
					if (in.next().equals("CENTER")) {
						continue testCases;
					}
				}
			}
		}
	}

}
