import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		int c = 1;
		while (c <= test) {
			int N = scn.nextInt();
			int[][] matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = scn.nextInt();
				}
			}
			int trace = 0;
			int nrow = 0;
			int ncol = 0;
			for (int i = 0; i < N; i++) {
				boolean[] check = new boolean[N];
				boolean doubt = false;
				boolean[] checkcol = new boolean[N];
				boolean doubtcol = false;
				for (int j = 0; j < N; j++) {
					int val = matrix[i][j];
					int invertval = matrix[j][i];
					if (check[val - 1] == false) {
						check[val - 1] = true;
					} else {
						doubt = true;
					}
					if (checkcol[invertval - 1] == false) {
						checkcol[invertval - 1] = true;
					} else {
						doubtcol = true;
					}
					if (i == j) {
						trace = trace + val;
					}
				}
				if (doubt == true) {
					nrow++;
				}
				if (doubtcol == true) {
					ncol++;
				}
			}
			System.out.println("Case #" + c + ": " + trace + " " + nrow + " " + ncol);
			c++;
		}
	}
}