

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    // Complete the countSwaps function below.
    public static int[] computeTrace(int[][] matrix) {
        int[] result = new int[3];

        // Initialize repeated column checker
        Map<Integer, Set<Integer>> colChecker = new HashMap<>();
        boolean[] isRepeatedCols = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            colChecker.put(i, new HashSet<>());
            isRepeatedCols[i] = false;
        }

        int k, r, c;
        k = r = c = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowRecords = new HashSet<>();
            boolean isRepeatedRow = false;
            for (int j = 0; j < matrix.length; j++) {
                int currentValue = matrix[i][j];
                if (i == j) {
                    k += currentValue;
                }
                // Check row
                if (!isRepeatedRow) {
                    if (rowRecords.contains(currentValue)) {
                        r++;
                        isRepeatedRow = true;
                    } else {
                        rowRecords.add(currentValue);
                    }
                }

                // Check column
                if (!isRepeatedCols[j]) {
                    Set<Integer> colRecords = colChecker.get(j);
                    if (colRecords.contains(currentValue)) {
                        c++;
                        isRepeatedCols[j] = true;
                    } else {
                        colRecords.add(currentValue);
                    }
                }
            }
        }

        result[0] = k;
        result[1] = r;
        result[2] = c;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int j = 0; j < n; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    matrix[i][j] = arrItem;
                }
            }
            int[] result = computeTrace(matrix);
            System.out.printf("#%s: %s %s %s", testCase, result[0], result[1], result[2]);
        }

        scanner.close();
    }
}
