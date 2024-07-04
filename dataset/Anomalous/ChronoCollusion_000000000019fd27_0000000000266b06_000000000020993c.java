import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] rotatedMatrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    rotatedMatrix[matrixSize - col - 1][row] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
            }

            duplicateRows = countDuplicates(matrix);
            duplicateCols = countDuplicates(rotatedMatrix);

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols);
        }
    }

    private static int countDuplicates(int[][] matrix) {
        int duplicates = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int value : row) {
                if (!uniqueElements.add(value)) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }
}