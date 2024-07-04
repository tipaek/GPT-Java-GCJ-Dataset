import java.util.HashSet;
import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowFlag = false, colFlag = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowFlag && !rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        rowFlag = true;
                    }
                    if (!colFlag && !colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        colFlag = true;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}