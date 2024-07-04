import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.valueOf(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			String input[] = br.readLine().split(" ");
			int x = Integer.valueOf(input[0]);
			int y = Integer.valueOf(input[1]);

			if (x % 2 != 0) {
				if (y % 2 != 0) {
					System.out.println("Case #" + test + ": IMPOSSIBLE");
					continue;
				}
			} else if (y % 2 == 0) {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
				continue;
			}

			int max = Math.abs(x) + Math.abs(y);
			int attemps = (int) (Math.log(max) / Math.log(2));
			StringBuilder result = new StringBuilder();
			int power = (int) Math.pow(2, attemps);
			int i = 1;
			int initialX = 0;
			int initialY = 0;
			while (i <= power) {
				if (Math.abs(x) < Math.abs(y)) {
					if (initialX < x) {
						initialX = initialX + i;
						result.append("W");
					} else if (initialX > x) {
						initialX = initialX - i;
						result.append("E");
					}
				} else {
					if (initialY < y) {
						initialY = initialY + i;
						result.append("S");
					} else if (initialY > y) {
						initialY = initialY - i;
						result.append("N");
					}

				}

				i = i * 2;
			}

			if (initialY == y && initialX == x) {
				System.out.println("Case #" + test + ": " + result.toString());
			}

			else {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			}

		}
	}
}