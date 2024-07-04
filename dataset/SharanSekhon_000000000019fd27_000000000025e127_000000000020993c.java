import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sf = new Scanner(System.in);
		int test = sf.nextInt();
		for (int i = 0; i < test; i++) {
			int N = sf.nextInt();
			int[][] board = new int[N][N];
			int no_of_rows = 0;
			int no_of_cols = 0;
			int diag_sum = 0;			
			for (int j = 0; j < board.length; j++) {
				for (int j2 = 0; j2 < board.length; j2++) {
					board[j][j2] = sf.nextInt();
					if(j==j2) {
						diag_sum+=board[j][j2];
					}
				}
			}
			for (int j = 0; j < board.length; j++) {
				ArrayList<Integer> row = new ArrayList<Integer>();
				int row_flag = 0;
				int col_flag = 0;
				ArrayList<Integer> col = new ArrayList<Integer>();
				for (int j2 = 0; j2 < board.length; j2++) {
					if(row.contains(board[j][j2])) {
						if(row_flag==0) {
							no_of_rows++;
							row_flag = 1;
						}
					}
					else {
						row.add(board[j][j2]);
					}
					if(col.contains(board[j2][j])) {
						if(col_flag==0) {
							no_of_cols++;
							col_flag++;
						}
					}
					else {
						col.add(board[j2][j]);
					}
				}
			}
			System.out.println(diag_sum+" "+no_of_rows+" "+no_of_cols);
		}
		sf.close();

	}

}
