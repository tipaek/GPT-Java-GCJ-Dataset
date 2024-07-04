import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            processMatrix(caseIndex, matrixSize);
        }
    }

    private static void processMatrix(int caseNumber, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int diagonalSum = calculateDiagonalSum(matrix, size);
        int rowRepeats = calculateRowRepeats(matrix, size);
        int columnRepeats = calculateColumnRepeats(matrix, size);

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeats + " " + columnRepeats);
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int calculateRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 1;
        for (int col = 1; col < size; col++) {
            if (matrix[0][col - 1] == matrix[0][col]) {
                rowRepeats++;
            }
        }
        return rowRepeats == 1 ? 0 : rowRepeats;
    }

    private static int calculateColumnRepeats(int[][] matrix, int size) {
        int columnRepeats = 1;
        for (int row = 1; row < size; row++) {
            if (matrix[row - 1][0] == matrix[row][0]) {
                columnRepeats++;
            }
        }
        return columnRepeats == 1 ? 0 : columnRepeats;
    }
}