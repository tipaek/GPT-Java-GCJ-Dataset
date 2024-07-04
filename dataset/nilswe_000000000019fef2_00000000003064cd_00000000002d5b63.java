
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
			if (b == 1_000_000_000 - 5) {
				for (int i = -5; i <= 5; i++) {
					for (int j = -5; j <= 5; j++) {
						System.out.println(i + " " + j);
						if (in.next().equals("CENTER")) {
							continue testCases;
						}
					}
				}
			} else if (b == 1_000_000_000 - 50) {
				int x1, x2, y1, y2;
				int i = -1_000_000_000, j = 0;
				while (true) {
					System.out.println(i + " " + j);
					if (in.next().equals("MISS")) {
						i++;
					} else {
						x1 = i;
						break;
					}
				}
				i = 1_000_000_000;
				while (true) {
					System.out.println(i + " " + j);
					if (in.next().equals("MISS")) {
						i--;
					} else {
						x2 = i;
						break;
					}
				}
				i = 0;
				j = -1_000_000_000;
				while (true) {
					System.out.println(i + " " + j);
					if (in.next().equals("MISS")) {
						j++;
					} else {
						y1 = j;
						break;
					}
				}
				j = 1_000_000_000;
				while (true) {
					System.out.println(i + " " + j);
					if (in.next().equals("MISS")) {
						j--;
					} else {
						y2 = j;
						break;
					}
				}
				int x = x2 + x1;
				int y = y2 + y1;
				System.out.println(x + " " + y);
				if (!in.next().equals("CENTER")) {
					System.out.println();
				}
			} else {
				System.out.println();
			}
		}
	}

}
