import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Initialize the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowRepeats = countRepeatedRows(matrix, n);
            int colRepeats = countRepeatedColumns(matrix, n);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedRows++;
                    break;
                }
            }
        }
        return repeatedRows;
    }

    public static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedColumns = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedColumns++;
                    break;
                }
            }
        }
        return repeatedColumns;
    }
}