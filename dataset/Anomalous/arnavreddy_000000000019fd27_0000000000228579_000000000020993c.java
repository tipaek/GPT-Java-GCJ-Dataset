import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            System.out.println("Case #" + i + ": " + calculateTrace(matrix, n) + " " + countDuplicateRows(matrix, n) + " " + countDuplicateColumns(matrix, n));
        }
    }

    public static long calculateTrace(int[][] matrix, int n) {
        long trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;

        for (int r = 0; r < n; r++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int c = 0; c < n; c++) {
                if (!uniqueElements.add(matrix[r][c])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }

        return duplicateRowCount;
    }

    public static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumnCount = 0;

        for (int c = 0; c < n; c++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int r = 0; r < n; r++) {
                if (!uniqueElements.add(matrix[r][c])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }

        return duplicateColumnCount;
    }
}