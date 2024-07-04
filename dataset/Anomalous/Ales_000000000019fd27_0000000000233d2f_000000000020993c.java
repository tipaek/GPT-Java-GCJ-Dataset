import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
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

            for (int index = 0; index < matrixSize; index++) {
                trace += matrix[index][index];

                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                boolean rowFlag = false, colFlag = false;

                for (int col = 0; col < matrixSize; col++) {
                    if (!rowFlag && rowSet.contains(matrix[index][col])) {
                        rowDuplicates++;
                        rowFlag = true;
                    }
                    rowSet.add(matrix[index][col]);
                }

                for (int row = 0; row < matrixSize; row++) {
                    if (!colFlag && colSet.contains(matrix[row][index])) {
                        colDuplicates++;
                        colFlag = true;
                    }
                    colSet.add(matrix[row][index]);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}