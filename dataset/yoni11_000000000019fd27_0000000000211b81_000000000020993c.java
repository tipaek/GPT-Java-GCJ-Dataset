import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int getTrace(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int numRows(int[][] matrix) {
        int n = matrix.length;
        int rows = 0;

        for (int r = 0; r < n; r++) {
            List<Integer> numbers = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                int number = matrix[r][c];
                if (numbers.contains(number)) {
                    rows++;
                    break;
                }
                numbers.add(number);
            }
        }
        return rows;
    }

    private static int numColumns(int[][] matrix) {
        int n = matrix.length;
        int columns = 0;

        for (int c = 0; c < n; c++) {
            List<Integer> numbers = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                int number = matrix[r][c];
                if (numbers.contains(number)) {
                    columns++;
                    break;
                }
                numbers.add(number);
            }
        }
        return columns;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();

            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = s.nextInt();
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", i + 1, getTrace(matrix), numRows(matrix), numColumns(matrix)));
        }
    }
}
