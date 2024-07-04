import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, calculateTrace(matrix), countDuplicateRows(matrix), countDuplicateColumns(matrix));
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRows++;
                    break;
                }
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int n = matrix.length;

        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColumns++;
                    break;
                }
            }
        }

        return duplicateColumns;
    }
}