import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseNumber, Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int trace = calculateTrace(matrix, matrixSize);
        int rowDuplicates = countRowDuplicates(matrix, matrixSize);
        int colDuplicates = countColumnDuplicates(matrix, matrixSize);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, colDuplicates);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col] - 1]) {
                    duplicates++;
                    break;
                }
                seen[matrix[row][col] - 1] = true;
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col] - 1]) {
                    duplicates++;
                    break;
                }
                seen[matrix[row][col] - 1] = true;
            }
        }
        return duplicates;
    }
}