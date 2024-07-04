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

        for (int k = 0; k < t; k++) {
            int n = mat[k].length;
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += mat[k][i][i];
            }
            System.out.print("Case #" + (k + 1) + ": " + trace);

            int rowDuplicates = countDuplicates(mat[k]);
            System.out.print(" " + rowDuplicates);

            // Transpose the matrix
            int[][] transpose = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transpose[i][j] = mat[k][j][i];
                }
            }

            int colDuplicates = countDuplicates(transpose);
            System.out.println(" " + colDuplicates);
        }
        sc.close();
    }

    public static int countDuplicates(int[][] matrix) {
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
}