import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int c=0;c<t;c++) { // for each case
			int n = sc.nextInt();
			int sum = 0;
			int[][] matrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					matrix[i][j] = sc.nextInt();
					if(i==j) {
						sum = sum + matrix[i][j];
					}
				}
			}
			int rowDupe = 0;
			for(int i=0;i<n;i++) {
				List<Integer> rowlist = new ArrayList<Integer>();
				for(int j=0;j<n;j++) {
					if(rowlist.contains(matrix[i][j])) {
						rowDupe = rowDupe + 1;
						break;
					}
					rowlist.add(matrix[i][j]);
				}
			}
			int colDupe = 0;
			for(int i=0;i<n;i++) {
				List<Integer> collist = new ArrayList<Integer>();
				for(int j=0;j<n;j++) {
					if(collist.contains(matrix[j][i])) {
						colDupe = colDupe + 1;
						break;
					}
					collist.add(matrix[j][i]);
				}
			}
			System.out.printf("Case #%d: %d %d %d\n",c+1,sum,rowDupe,colDupe);
		}
		sc.close();
	}
	
}
