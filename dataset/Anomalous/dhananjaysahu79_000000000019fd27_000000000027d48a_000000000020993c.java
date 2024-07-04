import java.util.*;

public class MatrixSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int currentTestCase = testCases;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int rowCounter = 0;
            int columnCounter = 0;

            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Row checking
            for (int i = 0; i < size; i++) {
                Set<Integer> visited = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!visited.add(matrix[i][j])) {
                        rowCounter++;
                        break;
                    }
                }
            }

            // Column checking
            for (int i = 0; i < size; i++) {
                Set<Integer> visited = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!visited.add(matrix[j][i])) {
                        columnCounter++;
                        break;
                    }
                }
            }

            // Diagonal sum calculation
            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.println("Case #" + (currentTestCase - testCases) + ": " + diagonalSum + " " + rowCounter + " " + columnCounter);
        }

        scanner.close();
    }
}