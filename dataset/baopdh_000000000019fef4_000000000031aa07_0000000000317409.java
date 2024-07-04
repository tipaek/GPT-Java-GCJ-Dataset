import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Map<Character, int[]> d = new HashMap<>();
		d.put('S', new int[]{0, -1});
		d.put('N', new int[]{0, 1});
		d.put('W', new int[]{-1, 0});
		d.put('E', new int[]{1, 0});

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(), tmp;
		for (int k = 1; k <= t; ++k) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			String m = scanner.next();

			int timeElapsed = 1;
			for (char c: m.toCharArray()) {
				int[] dt = d.get(c);
				x = x + dt[0];
				y = y + dt[1];

				if (Math.abs(x) + Math.abs(y) <= timeElapsed) {
					System.out.println("Case #" + k + ": " + timeElapsed);
					break;
				}

				++timeElapsed;
			}

			if (timeElapsed > m.length())
				System.out.println("Case #" + k + ": " + "IMPOSSIBLE");			
		}
		scanner.close();
	}
}