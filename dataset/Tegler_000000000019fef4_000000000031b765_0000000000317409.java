import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(scan.readLine());

		outer: for (int cases = 1; cases <= t; cases++) {
			String[] inp = scan.readLine().split(" ");

			for (int len = 1; len <= inp[2].length(); len++) {
				String walk = inp[2].substring(0, len);

				int x = Integer.parseInt(inp[0]);
				int y = Integer.parseInt(inp[1]);

				int updown = y;
				int side = x;

				for (char c : walk.toCharArray()) {
					if (c == 'N') {
						updown++;
					}
					if (c == 'S') {
						updown--;
					}
					if (c == 'W') {
						side--;
					}
					if (c == 'E') {
						side++;
					}
				}

				if (Math.abs(side) + Math.abs(updown) <= walk.length()) {
					System.out.println("Case #" + cases + ": " + walk.length());
					continue outer;
				}
			}
			
			System.out.println("Case #" + cases + ": " + "IMPOSSIBLE");

		}

	}

}
