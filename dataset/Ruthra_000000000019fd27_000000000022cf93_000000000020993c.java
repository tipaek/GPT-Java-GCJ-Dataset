import java.util.Scanner;

public class Solution {
	static int[] checkrow = new int[10];
	static int[] checkcol = new int[10];
	static int[] total = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, row, r, c, sum = 0, k = 0, l = 0;
		int caseNo = sc.nextInt();

		
		
		for (i = 0; i < caseNo; i++) {
			row = sc.nextInt();
			int[][] first = new int[row][row];
			int[] hash = new int[100];
			int[] rowcheck = new int[row];
			sum = 0;l=0;
			for (r = 0; r < row; r++) {
				for (c = 0; c < row; c++) {
					first[r][c] = sc.nextInt();
					if (r == c) {
						sum += first[r][c];
					}
					hash[first[r][c]] += 1;
					if (hash[first[r][c]] > 1) {
						k = 1;
					}
				}
				if (k == 1) {
					rowcheck[l++] = 1;
				} else {
					rowcheck[l++] = 0;
				}
				k = 0;
				for(c=0;c<row;c++){
					hash[first[r][c]] = 0;
				}
			}
			int[] colcheck = checkColumn(first, row);
			printValues(rowcheck, colcheck, sum, row, i);
		}
		populate(caseNo);
	}

	private static void populate(int no) {
		for(int i=0;i<no;i++){
			System.out.println("Case #" + (i+1) + ": " + total[i] + " " + checkrow[i] + " " + checkcol[i]);
		}
		
	}

	private static void printValues(int[] rowcheck, int[] colcheck, int sum, int row, int caseNo) {
		caseNo +=1;
		int r = 0, c = 0;
		for (int i = 0; i < row; i++) {
			if (rowcheck[i] == 1) {
				r++;
			}
			if (colcheck[i] == 1) {
				c++;
			}
		}
		checkrow[caseNo-1] = r;
		checkcol[caseNo-1] = c;
		total[caseNo-1] = sum;
		
	}

	private static int[] checkColumn(int[][] first, int row) {
		int[] col = new int[100];
		int k = 0, l = 0;
		int[] colcheck = new int[row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				col[first[j][i]] += 1;
				if (col[first[j][i]] > 1) {
					k = 1;
				}
			}
			if (k == 1) {
				colcheck[l++] = 1;
			} else {
				colcheck[l++] = 0;
			}
			k = 0;
			for (int j = 0; j < row; j++) {
			    col[first[j][i]] = 0;   
			}
		}
		return colcheck;
	}

}
