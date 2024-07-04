import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][][] mat = new int[t][][];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            mat[k] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[k][i][j] = sc.nextInt();
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int trace = 0;
            System.out.print("Case #" + (i + 1) + ":");

            for (int j = 0; j < mat[i].length; j++) {
                trace += mat[i][j][j];
            }
            System.out.print(" " + trace);

            int rowCount = countRowsWithDuplicates(mat[i]);
            System.out.print(" " + rowCount);

            int[][] transposed = transposeMatrix(mat[i]);
            int colCount = countRowsWithDuplicates(transposed);
            System.out.print(" " + colCount);

            System.out.println();
        }
        sc.close();
    }

    public static int countRowsWithDuplicates(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < row.length - 1; j++) {
                if (row[j] == row[j + 1]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}