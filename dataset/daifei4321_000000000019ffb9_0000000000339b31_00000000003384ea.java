import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int L = in.nextInt();
			int R = in.nextInt();
			for (int i = 1;; i++) {
				if (L >= R) {
					if (L >= i) {
						L -= i;
						continue;
					}
				} else {
					if (R >= i) {
						R -= i;
						continue;
					}
				}
				System.out.println("CASE #" + (t + 1) + ": " + (i - 1) + " " + L + " " + R);
				break;
			}
		}
	}
}
