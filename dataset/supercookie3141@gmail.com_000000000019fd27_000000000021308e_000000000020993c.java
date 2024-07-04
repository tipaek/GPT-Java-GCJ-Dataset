import java.util.ArrayList;
import java.util.Scanner;

public class QualificationRoundQuestion1 {
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int n = kboard.nextInt();
			int[][] arr = new int[n][n];
			int numOfRowsIncorrect = 0;
			int numOfColumnsIncorrect = 0;
			int trace = 0;
			for(int j = 0; j < n; j += 1) {
				ArrayList<Integer> row = new ArrayList<Integer>();
				for(int k = 0; k < n; k += 1) {
					arr[j][k] = kboard.nextInt();
					row.add(arr[j][k]);
					if(j == k) {
						trace += arr[j][k];
					}
				}
				
				for(int k = 1; k <= n; k += 1) {
					if(row.indexOf(k) == -1) {
						numOfRowsIncorrect += 1;
						break;
					}
				}
			}
			for(int j = 0; j < n; j += 1) {
				ArrayList<Integer> column = new ArrayList<Integer>();
				for(int k = 0; k < n; k += 1) {
					column.add(arr[k][j]);
				}
				for(int k = 1; k <= n; k += 1) {
					if(column.indexOf(k) == -1) {
						numOfColumnsIncorrect += 1;
						break;
					}
				}
			}
			System.out.println("Case #" + i + ": " + trace + " " + numOfRowsIncorrect + " " + numOfColumnsIncorrect);
		}
	}
}
