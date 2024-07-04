import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int cases = Integer.parseInt(bf.readLine().trim());
            
            for (int i = 0; i < cases; i++) {
                int n = Integer.parseInt(bf.readLine().trim());
                int[][] matrix = new int[n][n];
                
                for (int x = 0; x < n; x++) {
                    String[] row = bf.readLine().trim().split(" ");
                    for (int c = 0; c < n; c++) {
                        matrix[x][c] = Integer.parseInt(row[c]);
                    }
                }

                int trace = 0;
                for (int z = 0; z < n; z++) {
                    trace += matrix[z][z];
                }

                int duplicateRows = countDuplicateRows(matrix, n);
                int duplicateCols = countDuplicateCols(matrix, n);

                result.append("Case #").append(i + 1).append(": ")
                      .append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateCols).append("\n");
            }
            
            System.out.print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i]]) {
                    duplicateCols++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }
        return duplicateCols;
    }
}