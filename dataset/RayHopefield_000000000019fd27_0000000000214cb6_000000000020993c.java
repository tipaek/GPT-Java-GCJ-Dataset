import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			System.out.printf("Case #%s: %s %s %s%n", i + 1, findTrace(arr),
					findDuplicateRow(arr), findDuplicateColumn(arr));
		}
		sc.close();
	}

	private static int findTrace(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i][i];
		return sum;
	}

	private static int findDuplicateRow(int[][] arr) {
		int count = 0;
		boolean[] check;
		for (int i = 0; i < arr.length; i++) {
			check = new boolean[arr.length];
			for (int j = 0; j < arr.length; j++) {
				if (check[arr[i][j] - 1]) {
					count++;
					break;
				}
				check[arr[i][j] - 1] = true;
			}
		}
		return count;
	}

	private static int findDuplicateColumn(int[][] arr) {
		int count = 0;
		boolean[] check;
		for (int i = 0; i < arr.length; i++) {
			check = new boolean[arr.length];
			for (int j = 0; j < arr.length; j++) {
				if (check[arr[j][i] - 1]) {
					count++;
					break;
				}
				check[arr[j][i] - 1] = true;
			}
		}
		return count;
	}

}
