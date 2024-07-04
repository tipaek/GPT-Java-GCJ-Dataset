import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner sc = new Scanner(System.in);
		t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			int mat[][] = new int[n][n];
			int trace = 0, dupRows = 0, dupCols = 0;
			for (int j = 0; j < n; j++) {
				String rowStr = sc.nextLine();
				String[] rowArr = rowStr.split(" ");
				Set<String> set = new HashSet<>(Arrays.asList(rowArr));
				if (set.size() < n) {
					dupRows++;
				}
				for (int k = 0; k < n; k++) {
					mat[j][k] = Integer.parseInt(rowArr[k]);
					if (j == k) {
						trace = trace + mat[j][k];
					}
				}

			}
			for(int j = 0;j<n;j++)
			{
				Set<Integer> set = new HashSet<Integer>();
				for(int k = 0;k<n;k++)
				{
					set.add(mat[k][j]);
				}
				if(set.size()<n)
				{
					dupCols++;
				}
			}
			System.out.println("Case #"+(i+1)+": " + trace + " " + dupRows + " " + dupCols);
		}

		sc.close();
	}
}
