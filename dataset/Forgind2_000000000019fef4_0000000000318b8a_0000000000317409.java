import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int d = 1; d <= z; d++) {
			String[] inp = in.nextLine().trim().split(" ");
			int x = Integer.parseInt(inp[0]);
			int y = Integer.parseInt(inp[1]);
			int moves = 0;
			while (moves < Math.abs(x) + Math.abs(y) && moves < inp[2].length()) {
				switch (inp[2].charAt(moves)) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
					break;
				}
				moves++;
			}
			System.out.println("Case #" + d + ": " + (moves < Math.abs(x) + Math.abs(y) ? "IMPOSSIBLE" : moves));
		}
		in.close();
	}
}
