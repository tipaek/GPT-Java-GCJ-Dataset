import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[][] matrix = new int[4][4];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i, calculateTrace(matrix), calculateRowDuplicates(matrix), calculateColDuplicates(matrix));
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateColDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    private static int calculateRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < matrix[0].length; col++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }
}