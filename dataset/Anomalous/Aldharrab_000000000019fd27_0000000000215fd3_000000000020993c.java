import java.util.Scanner;

public class Sol1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            scanner.nextLine();
            analyzeMatrix(scanner, i + 1);
        }

        scanner.close();
    }

    private static void analyzeMatrix(Scanner scanner, int matrixNumber) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        // Read matrix and calculate row repeats
        for (int i = 0; i < matrixSize; i++) {
            boolean rowHasRepeat = false;
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (!rowHasRepeat) {
                    for (int k = 0; k < j; k++) {
                        if (matrix[i][k] == matrix[i][j]) {
                            rowHasRepeat = true;
                            rowRepeats++;
                            break;
                        }
                    }
                }
            }
        }

        // Calculate trace and column repeats
        for (int j = 0; j < matrixSize; j++) {
            boolean columnHasRepeat = false;
            for (int i = 0; i < matrixSize; i++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!columnHasRepeat) {
                    for (int k = 0; k < i; k++) {
                        if (matrix[k][j] == matrix[i][j]) {
                            columnHasRepeat = true;
                            columnRepeats++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Case #" + matrixNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
    }
}