import java.util.Scanner;

class Solution {
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
            int rowRepeats = countRowRepeats(matrix, n);
            int colRepeats = countColRepeats(matrix, n);

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int n) {
        int rowRepeats = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i], n)) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int n) {
        int colRepeats = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column, n)) {
                colRepeats++;
            }
        }
        return colRepeats;
    }

    private static boolean hasDuplicates(int[] array, int n) {
        boolean[] seen = new boolean[n + 1];
        for (int value : array) {
            if (value < 1 || value > n || seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}