

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int input[][] = new int[T][2];
		for (int i = 0; i < T; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
		for (int i = 0; i < T; i++) {
			int index = i + 1;
			int[][] ans = deck(input[i][0], input[i][1]);
			System.out.println("Case #" + index + ": " + ans.length);
			for (int j = 0; j < ans.length; j++) {
				System.out.println(ans[j][0] + " " + ans[j][1]);
			}
		}
	}

	static int[][] deck(int R, int S) {
		int[][] a = new int[1][2];
		return a;
	}
}
