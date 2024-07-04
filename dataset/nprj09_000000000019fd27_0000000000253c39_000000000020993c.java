import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int count = 1; count <= T; count++) {
			int N = sc.nextInt();
			int[][] M = new int[N][N];
			int[] resultKRC = new int[3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					M[i][j] = sc.nextInt();
				}
			}
			resultKRC = matrixTrace (N, M);
			System.out.print("Case #" + count + ": ");
			for (int krc : resultKRC)
				System.out.print(krc + " ");
			if (count != T)	
			    System.out.println();
		}
		sc.close();
	}

	private static int[] matrixTrace(int N, int[][] M) {
		int[] resultKRC = new int[3];
		int rowDuplicates = 0, colDuplicates= 0, diagonalSum = 0;
		Set<Integer> colElements = new HashSet<>();
		Set<Integer> rowElements = new HashSet<>();
		boolean isDuplicateCol = false;
		boolean isDuplicateRow = false;
		for (int i = 0; i < N; i++) {
			diagonalSum += M[i][i];
		}
		for (int i = 0; i < N; i++) {
			rowElements.clear();
			for (int j = 0; j < N; j++) {
				if (!rowElements.contains(M[i][j])) {
					rowElements.add(M[i][j]);
				}
				else {
					isDuplicateRow = true;
					break;
				}
			}
			if (isDuplicateRow) {
				rowDuplicates++;
				isDuplicateRow = false;
			}
		}
		for (int i = 0; i < N; i++) {
			colElements.clear();
			for (int j = 0; j < N; j++) {
				if (!colElements.contains(M[j][i])) {
					colElements.add(M[j][i]);
				}
				else {
					isDuplicateCol = true;
					break;
				}
			}
			if (isDuplicateCol) {
				colDuplicates++;
				isDuplicateCol = false;
			}
		}
		
		resultKRC[0] = diagonalSum;
		resultKRC[1] = rowDuplicates;
		resultKRC[2] = colDuplicates;
		return resultKRC;
	}
}
