import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);

            System.out.printf("Case #%d: %d %d %d\n", caseNumber, trace, duplicateRows, duplicateColumns);
        }

        reader.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}