import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 1; caseIndex <= numberOfTestCases; caseIndex++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = reader.readLine().split(" ");
                trace += Integer.parseInt(rowValues[i]);

                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> columnSet = new HashSet<>();
                
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    columnSet.add(matrix[j][i]);
                }

                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
                if (columnSet.size() != matrixSize) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, duplicateRows, duplicateColumns);
        }
    }
}