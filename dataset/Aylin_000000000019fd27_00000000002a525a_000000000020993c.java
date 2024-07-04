import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeJam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();

		for (int i = 0; i < repeat; i++) {
			int matrixRownColumn = sc.nextInt();
			int a[][] = takeMatrix(sc, matrixRownColumn);
			printMatrix(a, matrixRownColumn);
			sumMainDiagonal(a, matrixRownColumn);
			//System.out.println(repeatedSumOfInRow(a, matrixRownColumn));
			//System.out.println(repeatedSumOfInColumn(a, matrixRownColumn));
		}
	}

	public static int[][] takeMatrix(Scanner scan, int matrixRownColumn) {
		int[][] matrix = new int[matrixRownColumn][matrixRownColumn];
		for (int i = 0; i < matrixRownColumn; i++) {
			for (int j = 0; j < matrixRownColumn; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		return matrix;
	}

	public static void sumMainDiagonal(int mat[][], int n) {
		int sumOfMainDiagonal = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					sumOfMainDiagonal += mat[i][j];
				}
			}
		}
		int row = repeatedSumOfInRow(mat, n);
		int column=  repeatedSumOfInColumn(mat, n);
		System.out.println(sumOfMainDiagonal + "  " + row + " " + column); 
	}

	private static int repeatedSumOfInColumn(int[][] mat, int n) {
		int count = 0;

		for (int col = 0; col <n; col++) {
			for (int row = 0; row < n; row++) {
				int num = mat[row][col];
				for (int otherCol = col + 1; otherCol < n; otherCol++) {
					if (num == mat[row][otherCol]) 
						count++;					
				}
			}
		}
		return count;
	}

	private static int repeatedSumOfInRow(int[][] mat, int n) {
		int count = 0;

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				int num = mat[row][col];
				for (int otherCol = col + 1; otherCol < n; otherCol++) {
					if (num == mat[row][otherCol]) 
						count++;					
				}
			}
		}
		return count;
	}

	public static void printMatrix(int[][] matrix, int matrixRownColumn) {
		System.out.println("Your Matrix is : ");
		for (int i = 0; i < matrixRownColumn; i++) {
			for (int j = 0; j < matrixRownColumn; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
