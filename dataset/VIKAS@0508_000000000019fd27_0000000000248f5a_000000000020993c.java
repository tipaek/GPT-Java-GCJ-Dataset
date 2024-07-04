import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int cs = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			int row_count = 0;
			int col_count = 0;
			int diagonl_sum = 0;
			for (int i = 0; i < n; i++) {
				int[] freq_row = new int[n + 1];
				boolean check_row = false;
				for (int j = 0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
					freq_row[matrix[i][j]]++;
					if (freq_row[matrix[i][j]] > 1 && !check_row) {
						row_count++;
						check_row = true;
					}
					if (i == j) {
						diagonl_sum += matrix[i][j];
					}
				}
			}
			for (int i = 0; i < n; i++) {
				int[] freq_col = new int[n + 1];
				boolean check_col = false;
				for (int j = 0; j < n; j++) {
					freq_col[matrix[j][i]]++;
					if (freq_col[matrix[j][i]] > 1 && !check_col) {
						col_count++;
						check_col = true;
						break;
					}
				}
			}
			System.out.println("Case #" + cs + ": " + diagonl_sum + " " + row_count + " " + col_count);
			cs++;
		}

	}

}
