import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.next());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.next());
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(scanner.next());
                }
            }

            int trace = calculateTrace(matrix, n);
            int repeatedRows = countRowsWithRepeatedElements(matrix, n);
            int repeatedCols = countColsWithRepeatedElements(matrix, n);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatedRows, repeatedCols);
        }
    }

    private static int calculateTrace(int[][] matrix, int dimension) {
        int trace = 0;
        for (int i = 0; i < dimension; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithRepeatedElements(int[][] matrix, int dimension) {
        int rowsCount = 0;
        for (int i = 0; i < dimension; i++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int j = 0; j < dimension; j++) {
                if (hash.containsKey(matrix[i][j])) {
                    rowsCount++;
                    break;
                } else {
                    hash.put(matrix[i][j], 1);
                }
            }
        }
        return rowsCount;
    }

    private static int countColsWithRepeatedElements(int[][] matrix, int dimension) {
        int colsCount = 0;
        for (int j = 0; j < dimension; j++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < dimension; i++) {
                if (hash.containsKey(matrix[i][j])) {
                    colsCount++;
                    break;
                } else {
                    hash.put(matrix[i][j], 1);
                }
            }
        }
        return colsCount;
    }
}