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

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        scanner.close();
    }
}