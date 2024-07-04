import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int dimension = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[dimension][dimension];

            for (int i = 0; i < dimension; i++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int j = 0; j < rowValues.length; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            int trace = calculateTrace(matrix, dimension);
            int rowRepeats = countRowRepeats(matrix, dimension);
            int colRepeats = countColumnRepeats(matrix, dimension);

            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, rowRepeats, colRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int dimension) {
        int trace = 0;
        for (int i = 0; i < dimension; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int dimension) {
        int rowRepeats = 0;
        Set<Integer> uniqueElements = new HashSet<>(dimension);

        for (int i = 0; i < dimension; i++) {
            uniqueElements.clear();
            for (int j = 0; j < dimension; j++) {
                int element = matrix[i][j];
                if (!uniqueElements.add(element)) {
                    rowRepeats++;
                    break;
                }
            }
        }

        return rowRepeats;
    }

    private static int countColumnRepeats(int[][] matrix, int dimension) {
        int colRepeats = 0;
        Set<Integer> uniqueElements = new HashSet<>(dimension);

        for (int i = 0; i < dimension; i++) {
            uniqueElements.clear();
            for (int j = 0; j < dimension; j++) {
                int element = matrix[j][i];
                if (!uniqueElements.add(element)) {
                    colRepeats++;
                    break;
                }
            }
        }

        return colRepeats;
    }
}