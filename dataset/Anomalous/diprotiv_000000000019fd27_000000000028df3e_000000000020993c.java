import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColDuplicates(matrix, n);

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int i = 0; i < size; i++) {
            uniqueElements.clear();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCols = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int j = 0; j < size; j++) {
            uniqueElements.clear();
            for (int i = 0; i < size; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicateCols++;
            }
        }

        return duplicateCols;
    }
}