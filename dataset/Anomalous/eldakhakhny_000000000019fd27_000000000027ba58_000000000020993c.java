import java.util.HashMap;
import java.util.Scanner;

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
            int repeatedRows = countRowsWithRepeatedElements(matrix, n);
            int repeatedCols = countColsWithRepeatedElements(matrix, n);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int countRowsWithRepeatedElements(int[][] matrix, int size) {
        int rowsCount = 0;
        for (int i = 0; i < size; i++) {
            HashMap<Integer, Integer> elementCount = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (elementCount.containsKey(matrix[i][j])) {
                    rowsCount++;
                    break;
                } else {
                    elementCount.put(matrix[i][j], 1);
                }
            }
        }
        return rowsCount;
    }

    static int countColsWithRepeatedElements(int[][] matrix, int size) {
        int colsCount = 0;
        for (int j = 0; j < size; j++) {
            HashMap<Integer, Integer> elementCount = new HashMap<>();
            for (int i = 0; i < size; i++) {
                if (elementCount.containsKey(matrix[i][j])) {
                    colsCount++;
                    break;
                } else {
                    elementCount.put(matrix[i][j], 1);
                }
            }
        }
        return colsCount;
    }
}