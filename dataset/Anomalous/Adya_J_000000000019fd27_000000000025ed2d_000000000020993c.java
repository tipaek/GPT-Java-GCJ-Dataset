import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("\nCase #" + x + " : " + trace);
            System.out.print(" " + countDuplicateRows(matrix, n));
            System.out.print(" " + countDuplicateCols(matrix, n));
        }
    }

    public static int countDuplicateRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < n && !hasDuplicate; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        count++;
                        hasDuplicate = true;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static int countDuplicateCols(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < n && !hasDuplicate; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        count++;
                        hasDuplicate = true;
                        break;
                    }
                }
            }
        }
        return count;
    }
}