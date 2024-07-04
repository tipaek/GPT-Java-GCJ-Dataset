import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            int rowRepeats = countRepeats(matrix, matrixSize);
            int[][] transposedMatrix = transposeMatrix(matrix, matrixSize);
            int colRepeats = countRepeats(transposedMatrix, matrixSize);

            System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static int countRepeats(int[][] matrix, int size) {
        int repeats = 0;

        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != size) {
                repeats++;
            }
        }

        return repeats;
    }

    private static int[][] transposeMatrix(int[][] matrix, int size) {
        int[][] transposedMatrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                transposedMatrix[row][col] = matrix[col][row];
            }
        }

        return transposedMatrix;
    }
}