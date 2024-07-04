import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        if (testCases >= 1 && testCases <= 100) {
            for (int t = 0; t < testCases; t++) {
                int matrixSize = scanner.nextInt();
                if (matrixSize >= 2 && matrixSize <= 100) {
                    int[][] matrix = new int[matrixSize][matrixSize];
                    for (int i = 0; i < matrixSize; i++) {
                        for (int j = 0; j < matrixSize; j++) {
                            matrix[i][j] = scanner.nextInt();
                        }
                    }
                    analyzeMatrix(matrix, t + 1);
                }
            }
        }
        scanner.close();
    }

    private static void analyzeMatrix(int[][] matrix, int caseNumber) {
        int trace = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int matrixSize = matrix.length;
        for (int col = 0; col < matrixSize; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrixSize; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}