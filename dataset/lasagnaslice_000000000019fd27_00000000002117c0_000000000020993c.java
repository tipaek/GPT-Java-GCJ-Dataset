import java.util.*;

public class CodeJamQualification20201A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		int count = input.nextInt();
		for (i = 0; i < count; i++)
			accept(i);
	}
	public static void accept(int times) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		int i;
		int j;
		int[][] grid = new int[n][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				grid[i][j] = input.nextInt();
		}
		System.out.println("Case #" + (times + 1) + ": " + trace(grid) + " " + countrows(grid) + " " + countcols(grid));
	}
	public static int trace(int[][] given) {
		int sum = 0;
		int i;
		for (i = 0; i < given.length; i++) {
			sum += given[i][i];
		}
		return sum;
	}
	public static int countrows(int[][] given) {
		int count = 0;
		int i;
		int j;
		int z;
		int[] arr = new int[given.length];
		for (i = 0; i < given.length; i++) {
			for (j = 0; j < given.length; j++) {
				arr[j] = given[i][j];
			}
			Arrays.sort(arr);
			for (z = 0; z < given.length; z++) {
				if (arr[z] != z + 1) {
					count += 1;
					break;
				}
			}
		}
		return count;
	}
	public static int countcols(int[][] given) {
		int count = 0;
		int i;
		int j;
		int z;
		int[] arr = new int[given.length];
		for (i = 0; i < given.length; i++) {
			for (j = 0; j < given.length; j++) {
				arr[j] = given[j][i];
			}
			Arrays.sort(arr);
			for (z = 0; z < given.length; z++) {
				if (arr[z] != z + 1) {
					count += 1;
					break;
				}
			}
		}
		return count;
	}
}