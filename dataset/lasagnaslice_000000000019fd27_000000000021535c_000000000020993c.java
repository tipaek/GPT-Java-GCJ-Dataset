import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int d;
		int times = input.nextInt();
		for (d = 0; d < times; d++) {

		int i;
		int count;
		int n = input.nextInt();
		input.nextLine();
		int j;
		int[][] grid = new int[n][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				grid[i][j] = input.nextInt();
		}
		System.out.print("Case #" + (d + 1) + ": ");
		int sum = 0;
		for (i = 0; i < grid.length; i++) {
			sum += grid[i][i];
		}
		System.out.print(sum + " ");

		count = 0;
		int z;
		int[] arr = new int[grid.length];
		for (i = 0; i < grid.length; i++) {
			for (j = 0; j < grid.length; j++) {
				arr[j] = grid[i][j];
			}
			Arrays.sort(arr);
			for (z = 0; z < grid.length; z++) {
				if (arr[z] != z + 1) {
					count += 1;
					break;
				}
			}
		}
		System.out.print(count + " ");

		count = 0;
		for (i = 0; i < grid.length; i++) {
			for (j = 0; j < grid.length; j++) {
				arr[j] = grid[j][i];
			}
			Arrays.sort(arr);
			for (z = 0; z < grid.length; z++) {
				if (arr[z] != z + 1) {
					count += 1;
					break;
				}
			}
		}
		System.out.println(count);
		
		}
	}
}