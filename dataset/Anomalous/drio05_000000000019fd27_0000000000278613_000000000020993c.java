import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                String[] line = reader.readLine().trim().split("\\s+");
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowRepeats = countRowRepeats(matrix, n);
            int colRepeats = countColRepeats(matrix, n);

            result.append("Case #").append(caseNumber).append(": ")
                  .append(trace).append(" ").append(rowRepeats).append(" ").append(colRepeats).append("\n");
        }

        System.out.print(result);
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
        for (int row = 0; row < n; row++) {
            if (hasDuplicates(matrix[row])) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int n) {
        int colRepeats = 0;
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                colRepeats++;
            }
        }
        return colRepeats;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}