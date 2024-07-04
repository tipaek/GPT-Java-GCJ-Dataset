import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static int[] parseTokens(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for (int x = 0; x < n; x++) {
                matrix[x] = parseTokens(br.readLine());
            }
            processCase(i, matrix);
        }
    }

    private static void processCase(int caseNumber, int[][] matrix) {
        int n = matrix.length;
        int trace = calculateTrace(matrix, n);
        int duplicateRows = countDuplicateRows(matrix, n);
        int duplicateCols = countDuplicateCols(matrix, n);

        System.out.println(String.format("Case #%d: %d %d %d", caseNumber, trace, duplicateRows, duplicateCols));
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < n) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < n; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < n) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}