import java.util.Scanner;

public class Solution {

	private Scanner scanner = new Scanner(System.in);

	private String solve() throws Exception {
		int		x	= scanner.nextInt();
		int		y	= scanner.nextInt();
		char[]	arr	= scanner.next().toCharArray();
		int[][]	p	= new int[arr.length + 1][arr.length + 1];
		p[0] = new int[] { x, y };

		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
				case 78: {
					y++;
					p[i + 1] = new int[] { x, y };
					break;
				}
				case 69: {
					x++;
					p[i + 1] = new int[] { x, y };
					break;
				}
				case 83: {
					y--;
					p[i + 1] = new int[] { x, y };
					break;
				}
				case 87: {
					x--;
					p[i + 1] = new int[] { x, y };
					break;
				}
			}
		}
		int	smallest	= arr.length + 1;
		int	index		= -1;
		for (int i = 0; i < p.length; i++) {
			if (Math.abs(p[i][0]) + Math.abs(p[i][1]) <= arr.length) {
				if (Math.abs(p[i][0]) + Math.abs(p[i][1]) <= i) {
					if (Math.abs(i - (Math.abs(p[i][0]) + Math.abs(p[i][1]))) < smallest) {
						smallest	= Math.abs(i - (Math.abs(p[i][0]) + Math.abs(p[i][1])));
						index		= i;
					}
				}
			}
		}
		if (index < 0 || index < smallest) { return "IMPOSSIBLE"; }
		return "" + index;
	}

	private void run() throws Exception {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("Case #%d: %s%n", i + 1, solve());
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
