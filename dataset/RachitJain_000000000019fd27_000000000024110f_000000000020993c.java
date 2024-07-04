import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		int T = sc.nextInt();
		for (int i=0;i<T;i++) {
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for (int j=0;j<N;j++) {
				for (int k=0;k<N;k++) {
					M[j][k] = sc.nextInt();
				}
			}
			int k = findTrace(M,N);
			int r = checkLatinSquare(M,N)[0];
			int c = checkLatinSquare(M,N)[1];
			System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		}
	}
	public static int findTrace(int matrix[][], int size) {
		int trace = 0;
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				if(i==j) {
					trace+=matrix[i][j];
				}
			}
		}
		return trace;
	}
	public static int[] checkLatinSquare(int matrix[][], int N) {
		int tmpRow, countRow = 0, tmpCol, countCol = 0;
		for (int i=0;i<N;i++) {
			outerRow:
			for (int j=0;j<N;j++) {
				tmpRow = matrix[i][j];
				for (int k=j+1;k<N;k++) {
					if(tmpRow == matrix[i][k]) {
						countRow++;
						break outerRow;
					}
				}				
			}
		}
		for (int i=0;i<N;i++) {
			outerCol:
			for (int j=0;j<N;j++) {
				tmpCol = matrix[j][i];
				for (int k=j+1;k<N;k++) {
					if(tmpCol == matrix[k][i]) {
						countCol++;
						break outerCol;
					}
				}				
			}
		}
		int result[] = new int[2];
		result[0] = countRow;
		result[1] = countCol;
		return result;
	}
}