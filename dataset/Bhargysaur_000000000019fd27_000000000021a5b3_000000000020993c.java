import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0;i<t;i++) {
			int n = sc.nextInt();
			int [][] mat = new int[n][n];
			for (int j = 0;j<n;j++) {
				for (int k = 0;k<n;k++) {
					mat[j][k] = sc.nextInt();
				}
			}
			
			int numRows = 0;
			int numCols = 0;
			int tSum = 0;
			
			for (int j = 0;j<n;j++)
			{
				HashSet<Integer> row = new HashSet<Integer>();
				HashSet<Integer> col = new HashSet<Integer>();
				boolean inrow = false;
				boolean incol = false;
				for (int k = 0;k<n;k++) {
					if (k==j) tSum+=mat[j][k];
					
					if (col.contains(mat[k][j]) && !incol) {
						numCols++;
						incol = true;
					}
					
					if (row.contains(mat[j][k]) && !inrow) {
						numRows++;
						inrow = true;
					}
					col.add(mat[k][j]);
					row.add(mat[j][k]);
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+tSum+" "+numRows+" "+numCols);
		}
	}
}