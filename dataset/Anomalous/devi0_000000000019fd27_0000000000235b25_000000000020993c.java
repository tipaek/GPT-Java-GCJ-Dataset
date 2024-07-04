import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int t = Integer.parseInt(reader.readLine());
            for (int caseNum = 1; caseNum <= t; caseNum++) {
                processCase(caseNum, reader, writer);
            }
        }
    }

    private static void processCase(int caseNum, BufferedReader reader, PrintWriter writer)
            throws NumberFormatException, IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];
        int[] colChecker = new int[n];
        Arrays.fill(colChecker, 0);
        boolean[] duplicateCol = new boolean[n];
        Arrays.fill(duplicateCol, false);

        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            int rowChecker = 0;
            boolean duplicateRow = false;

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!duplicateRow && (rowChecker & (1 << matrix[i][j])) > 0) {
                    duplicateRows++;
                    duplicateRow = true;
                }
                if (!duplicateCol[j] && (colChecker[j] & (1 << matrix[i][j])) > 0) {
                    duplicateCols++;
                    duplicateCol[j] = true;
                }
                colChecker[j] |= (1 << matrix[i][j]);
                rowChecker |= (1 << matrix[i][j]);
            }
        }

        writer.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }
}