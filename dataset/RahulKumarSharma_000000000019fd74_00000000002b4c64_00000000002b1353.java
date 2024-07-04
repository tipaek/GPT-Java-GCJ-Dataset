import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int cs = 1; cs <= cases; cs++) {

			int n = sc.nextInt();

			System.out.println("Case #" + cs + ": ");

			for (int i = 1; i <= Math.min(n, 3); i++) {
				System.out.println(i + " 1");
			}

			if (n == 4) {
				System.out.println("4 1");
			}

			else if (n >= 5) {
				System.out.println("3 2");
			}

			for (int i = 3; i < n - 2; i++) {
				System.out.println(i + " " + i);
			}
		}
		
		sc.close();
	}
}
