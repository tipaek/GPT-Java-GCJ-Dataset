import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int curCase = 1; curCase <= numCases; curCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedColumns(matrix);

            System.out.println("Case #" + curCase + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    repeatedRows++;
                    break;
                }
            }
        }

        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedCols = 0;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedCols++;
                    break;
                }
            }
        }

        return repeatedCols;
    }
}