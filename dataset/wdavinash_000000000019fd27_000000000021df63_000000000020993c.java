import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int i, j;
		int k,r, c, rep_row, rep_col;
		int c_t_c = 1;
		Scanner s = new Scanner(System.in);
		int t_case = s.nextInt();
		while (c_t_c <= t_case) {
			k = 0;r = 0; c = 0; rep_row = 0; rep_col = 0;
			int col_row = s.nextInt();
			int array[][] = new int[col_row][col_row];
			for (i = 0; i < col_row; i++) {
				for (j = 0; j < col_row; j++) {
					array[i][j] = s.nextInt();
					if (i == j) {
						k = k + (array[i][j]);
					}

					if (rep_row <= 0) {
						for (int _r = 0; _r < j; _r++) {
							if (array[i][j] == array[i][_r]) {
								rep_row++;
								r = rep_row;
							}
						}
					}

					if (rep_col <= 0) {
						for (int y = 0; y <= i; y++) {
							if (array[i][j] == array[y][j]) {
								rep_col++;
								c = rep_col;
							}
						}
					}
					rep_row = 0;
				}
				rep_col = 0;
			}
			System.out.print("Case #" + c_t_c + ": " + k + " " + r + " " + c);
			c_t_c++;
		}
	}
}
