import java.util.Scanner;

public class Solution {

    static int[][] matrix;

    public static int findRowDuplicates(int row, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (matrix[row][i] == matrix[row][j]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int findColumnDuplicates(int column, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (matrix[i][column] == matrix[j][column]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;
            matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
                rowDuplicates += findRowDuplicates(i, size);
                columnDuplicates += findColumnDuplicates(i, size);
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}