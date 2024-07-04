import java.util.Scanner;

public class Vestigium {
    public static void main() {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }
            System.out.println("Case #" + testCase + ": " + calculateTrace(matrix) + " " + calculateRowsWithRepeatedElements(matrix) + " " + calculateColsWithRepeatedElements(matrix));
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int rows = matrix.length;
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    private static int calculateRowsWithRepeatedElements(int[][] matrix) {
        int rowsWithRepeatedElements = 0;

        for (int row = 0; row < matrix.length; row++) {
            int[] digits = new int[matrix.length];

            for (int col = 0; col < matrix.length; col++) {
                digits[matrix[row][col]] += 1;
            }

            for (int i = 0; i < digits.length; i++) {
                if (digits[i] > 1) {
                    rowsWithRepeatedElements++;
                    break;
                }
            }
        }
        return rowsWithRepeatedElements;
    }

    private static int calculateColsWithRepeatedElements(int[][] matrix) {
        int colsWithRepeatedElements = 0;

        for (int col = 0; col < matrix.length; col++) {
            int[] digits = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                digits[matrix[row][col]] += 1;
            }

            for (int i = 0; i < digits.length; i++) {
                if (digits[i] > 1) {
                    colsWithRepeatedElements++;
                    break;
                }
            }
        }
        return colsWithRepeatedElements;
    }
}
