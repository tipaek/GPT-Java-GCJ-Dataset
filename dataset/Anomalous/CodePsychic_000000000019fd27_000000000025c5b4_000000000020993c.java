import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            scanner.nextLine();
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            processMatrix(testCase, n, matrix);
        }
    }

    public static void processMatrix(int testCase, int n, int[][] matrix) {
        int trace = calculateTrace(n, matrix);
        int rowRepeats = countRowRepeats(n, matrix);
        int colRepeats = countColRepeats(n, matrix);

        System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }

    private static int calculateTrace(int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int n, int[][] matrix) {
        int rowRepeats = 0;
        boolean[] tracker = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(tracker, false);
            for (int j = 0; j < n; j++) {
                if (tracker[matrix[i][j]]) {
                    rowRepeats++;
                    break;
                } else {
                    tracker[matrix[i][j]] = true;
                }
            }
        }

        return rowRepeats;
    }

    private static int countColRepeats(int n, int[][] matrix) {
        int colRepeats = 0;
        boolean[] tracker = new boolean[n + 1];

        for (int j = 0; j < n; j++) {
            Arrays.fill(tracker, false);
            for (int i = 0; i < n; i++) {
                if (tracker[matrix[i][j]]) {
                    colRepeats++;
                    break;
                } else {
                    tracker[matrix[i][j]] = true;
                }
            }
        }

        return colRepeats;
    }
}