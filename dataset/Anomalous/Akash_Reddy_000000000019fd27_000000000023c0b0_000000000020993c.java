import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCaseCount > 0) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate trace and row repeats
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                trace += matrix[i][i];

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j]) && !rowFlag) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                }
            }

            // Calculate column repeats
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;

                for (int i = 0; i < matrixSize; i++) {
                    if (!colSet.add(matrix[i][j]) && !colFlag) {
                        colRepeats++;
                        colFlag = true;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
            testCaseCount--;
        }
    }
}