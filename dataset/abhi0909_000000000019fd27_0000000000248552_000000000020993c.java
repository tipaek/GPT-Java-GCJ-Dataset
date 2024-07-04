import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1 {

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

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {

			int n = sc.nextInt();

			int mat[][] = new int[n][n];

			Solution1 sol1 = new Solution1();
			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {

					mat[i][j] = sc.nextInt();
				}
			}

			int countDuplicateRow = sol1.countDuplicateRowCount(mat, n);

			int countDuplicateCol = sol1.countDuplicateColCount(mat, n);
			
			int sumOfDiagonal = sol1.sumOfDiagonal(mat, n);
			
			System.out.println("Case #"+ t+1 +": "+sumOfDiagonal+" "+countDuplicateRow+" "+countDuplicateCol);
		}

		sc.close();
	}

}
