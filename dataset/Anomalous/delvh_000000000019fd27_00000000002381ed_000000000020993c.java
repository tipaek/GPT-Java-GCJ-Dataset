import java.util.Scanner;

public class Solution {

    private void solve(Scanner scanner) throws Exception {
        int matrixSize = scanner.nextInt();
        int trace = 0;
        int rowRepeated = 0;
        int columnRepeated = 0;
        int[][] matrix = new int[matrixSize][matrixSize];

        // Calculate trace and fill the matrix
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }
        System.out.print(trace);

        // Check for repeated elements in rows
        for (int[] row : matrix) {
            if (hasRepeatedElements(row)) {
                rowRepeated++;
            }
        }
        System.out.print(" " + rowRepeated);

        // Check for repeated elements in columns
        for (int i = 0; i < matrixSize; i++) {
            int[] column = new int[matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                column[j] = matrix[j][i];
            }
            if (hasRepeatedElements(column)) {
                columnRepeated++;
            }
        }
        System.out.print(" " + columnRepeated + "\n");
    }

    private boolean hasRepeatedElements(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void run() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                System.out.printf("Case #%d: ", i);
                solve(scanner);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}