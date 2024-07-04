import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int N = input.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = input.nextInt();
				}
			}
			int trace = 0;
			for (int i = 0; i < N; i++) {
				trace += arr[i][i];
			}
			int row = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					int firstElement = arr[i][j];
					for (int k = j + 1; k < N; k++) {
						if (firstElement == arr[i][k]) {
							row++;
							break;
						}
					}
					if (row > 0)
						break;
				}
			}
			int column = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					int firstElement = arr[j][i];
					for (int k = j + 1; k < N; k++) {
						if (firstElement == arr[k][i]) {
							column++;
							break;
						}
					}
					if (column > 0)
						break;
				}
			}
			System.out.println("Case #" + t + ": " + trace + " " + row + " " + column);
		}
		input.close();
	}
}

