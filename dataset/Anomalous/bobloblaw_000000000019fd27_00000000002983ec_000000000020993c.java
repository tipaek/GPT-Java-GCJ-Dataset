import java.util.*;

public class Solution {
    
    static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int countBadRows(int[][] matrix) {
        int badRowCount = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    badRowCount++;
                    break;
                }
            }
        }
        return badRowCount;
    }

    static int countBadColumns(int[][] matrix) {
        int badColCount = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    badColCount++;
                    break;
                }
            }
        }
        return badColCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTests = scanner.nextInt();
        for (int test = 1; test <= numberOfTests; test++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(matrixSize, scanner);
            int trace = calculateTrace(matrix);
            int badRows = countBadRows(matrix);
            int badColumns = countBadColumns(matrix);
            System.out.printf("Case #%d: %d %d %d\n", test, trace, badRows, badColumns);
        }
    }
}