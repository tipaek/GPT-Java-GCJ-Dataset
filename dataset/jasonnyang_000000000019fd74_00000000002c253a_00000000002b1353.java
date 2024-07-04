import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for (int a = 1; a <= t; a++) {
			int x = input.nextInt();
			if (x <= 500) {
				System.out.println("Case #" + a + ": ");
				for (int i = 1; i <= x; i++) {
					System.out.println(i + " " + i);
				}
			} else if (x <= 935) {
				System.out.println("Case #" + a + ": ");
				System.out.println("1 1");
				for (int i = 1; i < 31; i++) {
					System.out.println(i + 1 + " " + i);
				}
				int y = x - 465;
				for (int i = 31; i < y + 30; i++) {
					System.out.println(i + " " + i);
				}
			} else {
				System.out.println("Case #" + a + ": ");
				System.out.println("1 1");
				for (int i = 1; i < 41; i++) {
					System.out.println(i + 1 + " " + i);
				}
				int y = x-820;
				for (int i = 41; i < y + 40; i++) {
					System.out.println(i + " " + i);
				}
			}
		}
	}
}