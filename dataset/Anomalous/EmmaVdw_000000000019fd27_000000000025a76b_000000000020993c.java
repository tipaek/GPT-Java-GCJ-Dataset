import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int nextDiagonalIndex = 0;
            int row = 0, col = 0;

            for (int index = 0; index < matrixSize * matrixSize; index++) {
                int value = scanner.nextInt();
                if (index == nextDiagonalIndex) {
                    trace += value;
                    nextDiagonalIndex += (matrixSize + 1);
                }
                matrix[row][col] = value;
                col++;
                if ((index + 1) % matrixSize == 0) {
                    row++;
                    col = 0;
                    if (scanner.hasNextLine()) {
                        scanner.nextLine();
                    }
                }
            }

            boolean[] rowHasDuplicate = new boolean[matrixSize];
            boolean[] colHasDuplicate = new boolean[matrixSize];
            int duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                Arrays.fill(rowHasDuplicate, false);
                Arrays.fill(colHasDuplicate, false);

                for (int j = 0; j < matrixSize; j++) {
                    int rowValue = matrix[i][j];
                    int colValue = matrix[j][i];

                    if (!rowHasDuplicate[rowValue - 1]) {
                        rowHasDuplicate[rowValue - 1] = true;
                    } else {
                        duplicateRows++;
                        break;
                    }

                    if (!colHasDuplicate[colValue - 1]) {
                        colHasDuplicate[colValue - 1] = true;
                    } else {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        scanner.close();
    }
}