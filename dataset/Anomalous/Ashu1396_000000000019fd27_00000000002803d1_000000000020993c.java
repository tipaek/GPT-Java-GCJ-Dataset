import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
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

            int repeatedRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    repeatedRows++;
                }
            }

            int repeatedCols = 0;
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }

        scanner.close();
    }
}