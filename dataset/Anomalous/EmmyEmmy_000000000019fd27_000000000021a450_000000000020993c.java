import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int index = 0; index < matrixSize; index++) {
                trace += matrix[index][index];
                rowDuplicates += hasDuplicates(matrix[index]);
                colDuplicates += hasColumnDuplicates(matrix, index);
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int hasColumnDuplicates(int[][] matrix, int colIndex) {
        int size = matrix.length;
        for (int row = 0; row < size; row++) {
            for (int nextRow = row + 1; nextRow < size; nextRow++) {
                if (matrix[row][colIndex] == matrix[nextRow][colIndex]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static int hasDuplicates(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    return 1;
                }
            }
        }
        return 0;
    }
}