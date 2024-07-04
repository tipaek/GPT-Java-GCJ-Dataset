import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int repeatedRows = countRepeatedRows(matrix, size);
            int repeatedCols = countRepeatedCols(matrix, size);

            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedCols);
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
        int repeatedRows = 0;
        for (int row = 0; row < size; row++) {
            int[] seen = new int[size];
            for (int col = 0; col < size; col++) {
                int value = matrix[row][col];
                if (seen[value - 1] == 1) {
                    repeatedRows++;
                    break;
                } else {
                    seen[value - 1] = 1;
                }
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix, int size) {
        int repeatedCols = 0;
        for (int col = 0; col < size; col++) {
            int[] seen = new int[size];
            for (int row = 0; row < size; row++) {
                int value = matrix[row][col];
                if (seen[value - 1] == 1) {
                    repeatedCols++;
                    break;
                } else {
                    seen[value - 1] = 1;
                }
            }
        }
        return repeatedCols;
    }
}