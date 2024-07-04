import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= testCount; test++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int traceValue = calculateTrace(matrix, n);
            int repeatedRowCount = countRepeatedRows(matrix, n);
            int repeatedColCount = countRepeatedCols(matrix, n);

            System.out.println("Case #" + test + ": " + traceValue + " " + repeatedRowCount + " " + repeatedColCount);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countRepeatedCols(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}