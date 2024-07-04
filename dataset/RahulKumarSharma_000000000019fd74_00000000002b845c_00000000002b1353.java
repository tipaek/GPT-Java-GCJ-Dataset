import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int cs = 1; cs <= cases; cs++) {

			int n = sc.nextInt();

			System.out.println("Case #" + cs + ": ");

			if (n <= 501) {
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

			} else if (n <= 950) {
				System.out.println("1 1");
				
				for(int i = 2; i <= 32; i++) {
					System.out.println(i + " 2");
				}
				
				for (int i = 0; i < n - 497; i++) {
					System.out.println((32 + i) + " " + 1);
				}

			} else {
				System.out.println("1 1");
				
				for(int i = 2; i <= 34; i++) {
					System.out.println(i + " 2");
				}
				
				for (int i = 0; i < n - 562; i++) {
					System.out.println((34 + i) + " " + 1);
				}
			}
		}
		sc.close();
	}
}
