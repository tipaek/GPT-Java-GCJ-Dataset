import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < matrixSize; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row repeats
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column repeats
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            result.append("Case #").append(caseNumber).append(": ")
                  .append(trace).append(" ")
                  .append(rowRepeats).append(" ")
                  .append(colRepeats).append("\n");
        }

        System.out.print(result);
    }
}