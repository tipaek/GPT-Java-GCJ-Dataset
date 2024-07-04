import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public int countDuplicateRowCount(int mat[][], int n) {

		int count = 0;

		for (int i = 0; i < n; i++) {

			Set<Integer> set = new HashSet<Integer>();
			boolean flag = false;

			for (int j = 0; j < n; j++) {

				if (set.contains(mat[i][j])) {
					flag = true;
				} else {
					set.add(mat[i][j]);
				}
			}

			if (flag)
				count++;
		}

		return count;
	}

	public int countDuplicateColCount(int mat[][], int n) {

		int count = 0;

		for (int i = 0; i < n; i++) {

			Set<Integer> set = new HashSet<Integer>();
			boolean flag = false;

			for (int j = 0; j < n; j++) {

				if (set.contains(mat[j][i])) {
					flag = true;
				} else {
					set.add(mat[j][i]);
				}
			}

			if (flag)
				count++;
		}

		return count;
	}
	
	public int sumOfDiagonal(int mat[][],int n) {
		
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += mat[i][i];
		}
		
		return sum;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));;

		int t = sc.nextInt();
		int num = 1;
		while (t-- > 0) {

			int n = sc.nextInt();

			int mat[][] = new int[n][n];

			Solution sol1 = new Solution();
			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {

					mat[i][j] = sc.nextInt();
				}
			}

			int countDuplicateRow = sol1.countDuplicateRowCount(mat, n);

			int countDuplicateCol = sol1.countDuplicateColCount(mat, n);
			
			int sumOfDiagonal = sol1.sumOfDiagonal(mat, n);
			
			System.out.println("Case #"+ num +": "+sumOfDiagonal+" "+countDuplicateRow+" "+countDuplicateCol);
			num++;
		}

		sc.close();
	}

}
