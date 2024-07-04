import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            testCases--;
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            Set<Integer>[] rowSets = new HashSet[matrixSize];
            Set<Integer>[] colSets = new HashSet[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    rowSets[i].add(matrix[i][j]);
                    colSets[j].add(matrix[i][j]);
                }
            }

            int duplicateRows = 0, duplicateCols = 0, trace = 0;

            for (int i = 0; i < matrixSize; i++) {
                if (rowSets[i].size() != matrixSize) {
                    duplicateRows++;
                }
                if (colSets[i].size() != matrixSize) {
                    duplicateCols++;
                }
                trace += matrix[i][i];
            }

            System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}