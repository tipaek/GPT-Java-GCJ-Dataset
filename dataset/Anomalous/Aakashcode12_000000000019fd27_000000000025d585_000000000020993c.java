import java.util.Scanner;
import java.util.Arrays;

class CodeJam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int[] traceResults = new int[t];
        int[] rowDuplicates = new int[t];
        int[] colDuplicates = new int[t];

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;

            for (int i = 0; i < n; i++) {
                int[] row = new int[n];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    row[j] = matrix[i][j];
                }
                if (hasDuplicates(row)) {
                    rowDuplicateCount++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colDuplicateCount++;
                }
            }

            traceResults[testCase] = trace;
            rowDuplicates[testCase] = rowDuplicateCount;
            colDuplicates[testCase] = colDuplicateCount;
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traceResults[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }
}