import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        if (t < 1 || t > 100) {
            System.exit(0);
        }

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt();
            if (n < 2 || n > 100) {
                System.exit(0);
            }

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (matrix[i][j] < 1 || matrix[i][j] > n) {
                        System.exit(0);
                    }
                }
            }

            int traceSum = calculateTrace(matrix, n);
            int rowRepeats = countRepeatedRows(matrix, n);
            int colRepeats = countRepeatedColumns(matrix, n);
            System.out.println("Case #" + testCase + ": " + traceSum + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    repeatedRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int repeatedColumns = 0;

        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (seen[matrix[i][j]]) {
                    repeatedColumns++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return repeatedColumns;
    }
}