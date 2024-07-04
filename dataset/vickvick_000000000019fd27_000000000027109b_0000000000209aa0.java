
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			String res = cal(n, k);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static String cal(int n, int k) {
		int[][] nums = null;
		if (n == 2) {
			switch (k) {
			case 2:
				nums = new int[][] { { 1, 2 }, { 2, 1 } };
				break;
			case 3:
				break;
			case 4:
				nums = new int[][] { { 2, 1 }, { 1, 2 } };
				break;
			}
		} else if (n == 3) {
			switch (k) {
			case 3:
				nums = new int[][] { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				nums = new int[][] { { 2, 3, 1 }, { 1, 2, 3 }, { 3, 1, 2 } };
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				nums = new int[][] { { 3, 1, 2 }, { 2, 3, 1 }, { 1, 2, 3 }, };
				break;
			}
		} else if (n == 4) {
			switch (k) {
			case 4:
				nums = new int[][] { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				nums = new int[][] { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 }, };
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				nums = new int[][] { { 3, 4, 1, 2 }, { 2, 3, 4, 1 }, { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, };
				break;
			case 13:
				break;
			case 14:
				break;
			case 15:
				break;
			case 16:
				nums = new int[][] { { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 }, { 1, 2, 3, 4 }, };
				break;
			}
		} else if (n == 5) {
			switch (k) {
			case 5:
				nums = new int[][] { { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 }, { 4, 5, 1, 2, 3 }, { 3, 4, 5, 1, 2 },
						{ 2, 3, 4, 5, 1 } };
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				nums = new int[][] { { 2, 3, 4, 5, 1 }, { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 }, { 4, 5, 1, 2, 3 },
						{ 3, 4, 5, 1, 2 }, };
				break;
			case 11:
				break;
			case 12:
				break;
			case 13:
				break;
			case 14:
				break;
			case 15:
				nums = new int[][] { { 3, 4, 5, 1, 2 }, { 2, 3, 4, 5, 1 }, { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 },
						{ 4, 5, 1, 2, 3 }, };
				break;
			case 16:
				break;
			case 17:
				break;
			case 18:
				break;
			case 19:
				break;
			case 20:
				nums = new int[][] { { 4, 5, 1, 2, 3 }, { 3, 4, 5, 1, 2 }, { 2, 3, 4, 5, 1 }, { 1, 2, 3, 4, 5 },
						{ 5, 1, 2, 3, 4 }, };
				break;
			case 21:
				break;
			case 22:
				break;
			case 23:
				break;
			case 24:
				break;
			case 25:
				nums = new int[][] { { 5, 1, 2, 3, 4 }, { 4, 5, 1, 2, 3 }, { 3, 4, 5, 1, 2 }, { 2, 3, 4, 5, 1 },
						{ 1, 2, 3, 4, 5 }, };
				break;
			}
		}
		if (nums == null) {
			return "IMPOSSIBLE";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("POSSIBLE\n");
		for (int i = 0; i < nums.length; ++i) {
			for (int j = 0; j < nums[0].length; ++j) {
				sb.append(nums[i][j]);
				if (j != nums[0].length - 1)
					sb.append(" ");
			}
			if (i != nums.length - 1)
				sb.append("\n");
		}
		return sb.toString();
	}

}