import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int i = 0; i < numberOfCases; i++) {
            int[] result = processCase(scanner);
            System.out.printf("Case #%d: %d %d %d%n", i, result[0], result[1], result[2]);
        }
    }

    private static int[] processCase(Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        
        int expectedSum = (size + 1) / 2 * size;
        int rowErrors = countRowErrors(matrix, expectedSum);
        int colErrors = countColErrors(matrix, expectedSum);
        int diagonalSum = calculateDiagonalSum(matrix);
        
        return new int[]{rowErrors, colErrors, diagonalSum};
    }

    private static int countRowErrors(int[][] matrix, int expectedSum) {
        int errors = 0;
        
        for (int[] row : matrix) {
            int sum = 0;
            for (int value : row) {
                sum += value;
            }
            if (sum != expectedSum) {
                errors++;
            }
        }
        
        return errors;
    }

    private static int countColErrors(int[][] matrix, int expectedSum) {
        int errors = 0;
        
        for (int col = 0; col < matrix.length; col++) {
            int sum = 0;
            for (int[] row : matrix) {
                sum += row[col];
            }
            if (sum != expectedSum) {
                errors++;
            }
        }
        
        return errors;
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        
        return sum;
    }
}