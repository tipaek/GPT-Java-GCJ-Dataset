import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowRepeats = countRepeats(matrix, matrixSize);
            int columnRepeats = countRepeats(transposeMatrix(matrix, matrixSize), matrixSize);

            System.out.print("Case #" + caseIndex + ": " + diagonalSum + " " + rowRepeats + " " + columnRepeats);
            if (caseIndex != numberOfCases) {
                System.out.println();
            }
        }
    }

    private static int countRepeats(int[][] matrix, int size) {
        int repeats = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                repeats++;
            }
        }

        return repeats;
    }

    private static int[][] transposeMatrix(int[][] matrix, int size) {
        int[][] transposedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }
}