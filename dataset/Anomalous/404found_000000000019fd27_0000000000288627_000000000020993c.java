import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            processMatrix(caseNumber, matrixSize);
        }
    }

    private static void processMatrix(int caseNumber, int size) {
        int[][] matrix = new int[size][size];
        
        // Reading the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculating the sum of the diagonal elements
        int diagonalSum = 0;
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        // Checking for repeated elements in the first row
        int repeatedRows = 1;
        for (int j = 1; j < size; j++) {
            if (matrix[0][j - 1] == matrix[0][j]) {
                repeatedRows++;
            }
        }
        if (repeatedRows == 1) {
            repeatedRows = 0;
        }

        // Checking for repeated elements in the first column
        int repeatedColumns = 1;
        for (int i = 1; i < size; i++) {
            if (matrix[i - 1][0] == matrix[i][0]) {
                repeatedColumns++;
            }
        }
        if (repeatedColumns == 1) {
            repeatedColumns = 0;
        }

        // Printing the result
        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
    }
}