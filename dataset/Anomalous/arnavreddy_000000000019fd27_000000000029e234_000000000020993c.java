import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, calculateTrace(matrix, n), countDuplicateRows(matrix, n), countDuplicateColumns(matrix, n));
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateCount = 0;
        for (int col = 0; col < n; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateCount = 0;
        for (int row = 0; row < n; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }
}