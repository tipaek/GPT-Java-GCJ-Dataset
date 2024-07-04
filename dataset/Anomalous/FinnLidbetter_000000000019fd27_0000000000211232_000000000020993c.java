import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine());
        for (int test = 1; test <= testCases; test++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            output.append(String.format("Case #%d: %d %d %d\n", test, trace, duplicateRows, duplicateColumns));
        }

        System.out.print(output);
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
            HashSet<Integer> uniqueValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueValues.add(matrix[i][j]);
            }
            if (uniqueValues.size() != size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> uniqueValues = new HashSet<>();
            for (int i = 0; i < size; i++) {
                uniqueValues.add(matrix[i][j]);
            }
            if (uniqueValues.size() != size) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}