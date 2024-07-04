import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColDuplicates(matrix, n);
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return rowDuplicates;
    }

    private static int countColDuplicates(int[][] matrix, int n) {
        int colDuplicates = 0;
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (seen[matrix[i][j]]) {
                    colDuplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return colDuplicates;
    }
}