import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int repeatedRows = countRepeatedRows(matrix, size);
            int repeatedCols = countRepeatedCols(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, repeatedRows, repeatedCols);
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
            boolean[] seen = new boolean[size];
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];
                if (seen[value - 1]) {
                    count++;
                    break;
                } else {
                    seen[value - 1] = true;
                }
            }
        }
        return count;
    }

    private static int countRepeatedCols(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size];
            for (int i = 0; i < size; i++) {
                int value = matrix[i][j];
                if (seen[value - 1]) {
                    count++;
                    break;
                } else {
                    seen[value - 1] = true;
                }
            }
        }
        return count;
    }
}