import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                Map<Integer, Integer> columnMap = new HashMap<>();
                trace += matrix[i][i];

                for (int j = 0; j < matrixSize; j++) {
                    rowMap.merge(matrix[i][j], 1, Integer::sum);
                    columnMap.merge(matrix[j][i], 1, Integer::sum);
                }

                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    duplicateRows++;
                }
                if (columnMap.values().stream().anyMatch(count -> count > 1)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            caseNumber++;
        }
    }
}