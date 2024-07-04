import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int inputs = file.nextInt();
		for(int i = 1; i <= inputs; i++) {
			int n = file.nextInt();
			int[][] mat = new int[n][n];
			int trace = 0;
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					mat[r][c] = file.nextInt();
					if(r == c) {
						trace += mat[r][c];
					}
				}
			}
			int badRow = 0;
			int[] count = new int[n+1];
			for(int r = 0; r < n; r++) {
				Arrays.fill(count, 0);
				for(int c = 0; c < n; c++) {
					count[mat[r][c]]++;
					if(count[mat[r][c]] > 1) {
						badRow++;
						break;
					}
				}
			}
			int badCol = 0;
			for(int c = 0; c < n; c++) {
				Arrays.fill(count, 0);
				for(int r = 0; r < n; r++) {
					count[mat[r][c]]++;
					if(count[mat[r][c]] > 1) {
						badCol++;
						break;
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + badRow + " " + badCol);
		}
		file.close();
	}

}
