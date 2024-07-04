import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int caseNo = sc.nextInt();
	static int[] checkrow = new int[caseNo];
	static int[] checkcol = new int[caseNo];
	static int[] total = new int[caseNo];

	public static void main(String[] args) {

		int i, row, sum = 0, num = 0;

		for (i = 0; i < caseNo; i++) {
			row = sc.nextInt();
			int[][] first = new int[row][row];
			int[] hash = new int[row];
			sum = 0;
			num = 0;
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < row; c++) {
					first[r][c] = sc.nextInt();
					if (r == c) {
						sum += first[r][c];
					}
					hash[c] = first[r][c];
				}
				Arrays.sort(hash);
				for (int l = 0; l < hash.length - 1; l++) {
					if (hash[l] - hash[l + 1] == 0) {
						num++;
						break;
					}
				}
			}
			checkrow[i] = num;
			total[i] = sum;
			checkColumn(first, i);

		}
		populate(caseNo);
	}

	private static void checkColumn(int[][] first, int caseNo) {
		int[] col = new int[first.length];
		int num = 0;
		for (int r = 0; r < first.length; r++) {
			for (int c = 0; c < first.length; c++) {
				col[c] = first[c][r];
			}
			Arrays.sort(col);
			for (int l = 0; l < col.length - 1; l++) {
				if (col[l] - col[l + 1] == 0) {
					num++;
					break;
				}
			}
		}
		checkcol[caseNo] = num;
	}

	private static void populate(int no) {
		for (int i = 0; i < no; i++) {
			System.out.println("Case #" + (i + 1) + ": " + total[i] + " " + checkrow[i] + " " + checkcol[i]);
		}

	}

}