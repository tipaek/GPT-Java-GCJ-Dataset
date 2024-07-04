import java.util.Scanner;

public class Solution {

    static int[][] matrix;

    public static int checkRowDuplicates(int row, int size) {
        for (int col = 0; col < size; col++) {
            for (int nextCol = col + 1; nextCol < size; nextCol++) {
                if (matrix[row][col] == matrix[row][nextCol]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int checkColumnDuplicates(int col, int size) {
        for (int row = 0; row < size; row++) {
            for (int nextRow = row + 1; nextRow < size; nextRow++) {
                if (matrix[row][col] == matrix[nextRow][col]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int size = scanner.nextInt();
            int sumDiagonal = 0, rowDuplicates = 0, colDuplicates = 0;
            matrix = new int[size][size];

            // Read the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate the sum of the diagonal and check for duplicates
            for (int index = 0; index < size; index++) {
                sumDiagonal += matrix[index][index];
                rowDuplicates += checkRowDuplicates(index, size);
                colDuplicates += checkColumnDuplicates(index, size);
            }

            System.out.println("Case #" + (testCase + 1) + ": " + sumDiagonal + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}