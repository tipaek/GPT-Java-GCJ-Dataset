import java.util.Scanner;

public class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }
            System.out.print("Case #" + t + ": " + diagonalSum + " ");

            int maxRowDuplicates = getMaxDuplicates(matrix, true);
            int maxColDuplicates = getMaxDuplicates(matrix, false);

            System.out.print(maxRowDuplicates + " ");
            System.out.print(maxColDuplicates + " ");
            System.out.println();
        }
    }

    private static int getMaxDuplicates(int[][] matrix, boolean isRow) {
        int maxDuplicates = -1;
        int matrixSize = matrix.length;

        for (int i = 0; i < matrixSize; i++) {
            int[] count = new int[101]; // Assuming numbers are between 0 and 100
            for (int j = 0; j < matrixSize; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                count[value]++;
            }
            for (int c : count) {
                if (c > 1 && c - 1 > maxDuplicates) {
                    maxDuplicates = c - 1;
                }
            }
        }
        return maxDuplicates;
    }
}