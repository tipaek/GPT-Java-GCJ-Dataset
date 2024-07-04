

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String args[]) {
		int row_count = 0, col_count = 0, diag_count = 0, r = 0, c = 0;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			row_count = 0; col_count = 0; diag_count = 0;
			int size = sc.nextInt();
			int val = ((size) * (size - 1)) / 2;
			int arr[][] = new int[size][size];
			int row[][] = new int[size+1][size+1];
			int col[][] = new int[size+1][size+1];

			 Set<Integer> set_row=new HashSet<>();
			 Set<Integer> set_col=new HashSet<>();
			for (r = 0; r < size; r++) {

				for (c = 0; c < size; c++) {
					arr[r][c] = sc.nextInt();

					if (row[r][arr[r][c]]== 1 && !set_row.contains(r)) {
                          row_count++;
                 
                          set_row.add(r);
					}
					if (col[arr[r][c]][c]== 1 && !set_col.contains(c)) {
                          col_count++;
                          set_col.add(c);
                         
					}
					col[arr[r][c]][c]= 1;
					row[r][arr[r][c]]= 1;
					if (r == c) {
						diag_count = diag_count + arr[r][c];
					}

				}

			}

			System.out.print("Case #");
			System.out.print((i + 1) + ": ");
			System.out.print(diag_count + " " + row_count + " " + col_count);
			System.out.println();

		}
	}
}
