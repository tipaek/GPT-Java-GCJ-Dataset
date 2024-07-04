import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countInvalidRows(int[][] matrix, int size) {
        int count = 0;
        int[] expected = new int[size];
        for (int i = 0; i < size; i++) {
            expected[i] = i + 1;
        }
        for (int i = 0; i < size; i++) {
            int[] row = Arrays.copyOf(matrix[i], size);
            Arrays.sort(row);
            if (!Arrays.equals(row, expected)) {
                count++;
            }
        }
        return count;
    }

    public static int countInvalidColumns(int[][] matrix, int size) {
        int count = 0;
        int[] expected = new int[size];
        for (int i = 0; i < size; i++) {
            expected[i] = i + 1;
        }
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            Arrays.sort(column);
            if (!Arrays.equals(column, expected)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int invalidRows = countInvalidRows(matrix, size);
            int invalidColumns = countInvalidColumns(matrix, size);
            System.out.println("Case #" + t + ": " + trace + " " + invalidRows + " " + invalidColumns);
        }
        scanner.close();
    }
}