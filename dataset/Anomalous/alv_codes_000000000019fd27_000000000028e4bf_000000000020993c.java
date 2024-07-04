import java.util.*;
import java.io.*;

public class Solution {

    public static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    public static int countRepeatedRows(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (uniqueElements.contains(matrix[i][j])) {
                    count++;
                    break;
                } else {
                    uniqueElements.add(matrix[i][j]);
                }
            }
        }
        return count;
    }

    public static int countRepeatedColumns(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (uniqueElements.contains(matrix[j][i])) {
                    count++;
                    break;
                } else {
                    uniqueElements.add(matrix[j][i]);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int traceSum = calculateTrace(matrix);
            int repeatedRowsCount = countRepeatedRows(matrix);
            int repeatedColumnsCount = countRepeatedColumns(matrix);

            System.out.println("Case #" + t + ": " + traceSum + " " + repeatedRowsCount + " " + repeatedColumnsCount);
        }
        scanner.close();
    }
}