
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int c = 1;
		while (t-- > 0) {

			int N = scan.nextInt();

			int[][] grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					grid[i][j] = scan.nextInt();

				}
			}

			int[] ans = function(grid, N);
			System.out.print("Case #" + c + ": ");
			for(int i = 0; i<3; i++)
				System.out.print(ans[i] + " ");
			System.out.println();
			c++;
		}

	}

	private static int[] function(int[][] grid, int N) {

		int sum = 0;
		int cc = 0;
		int rc = 0;
		for (int i = 0; i < N; i++) {

			HashSet<Integer> set = new HashSet<>();
			int flag = 0;
			for (int j = 0; j < N; j++) {

				if (i == j)
					sum += grid[i][j];

				if (set.contains(grid[i][j]) && flag == 0) {
					rc++;
					flag = 1;
				}
				else set.add(grid[i][j]);
			}
		}

		for (int i = 0; i < N; i++) {

			HashSet<Integer> set = new HashSet<>();
			int flag = 0;
			for (int j = 0; j < N; j++) {

				if (set.contains(grid[j][i]) && flag == 0) {
					cc++;
					flag = 1;
				}
				
				else set.add(grid[j][i]);
			}
		}

		int[] ans = new int[3];
		ans[0] = sum;
		ans[1] = rc;
		ans[2] = cc;
		return ans;
	}

}
