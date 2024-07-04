import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowsWithRepeats = countRowsWithRepeatedElements(matrix, n);
            int colsWithRepeats = countColsWithRepeatedElements(matrix, n);
            
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowsWithRepeats, colsWithRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countColsWithRepeatedElements(int[][] matrix, int size) {
        int colsCount = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    colsCount++;
                    break;
                }
            }
        }
        return colsCount;
    }

    private static int countRowsWithRepeatedElements(int[][] matrix, int size) {
        int rowsCount = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    rowsCount++;
                    break;
                }
            }
        }
        return rowsCount;
    }
}