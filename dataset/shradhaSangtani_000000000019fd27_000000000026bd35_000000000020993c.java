import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        for (int k = 0; k < tc; k++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            int traceCount = 0;
            int rowCount = 0;
            int columnCount = 0;
            int[] row = new int[n];
            int[] col = new int[n];
            boolean[] rowFlag = new boolean[n];
            boolean[] colFlag = new boolean[n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        traceCount += matrix[i][j];
                    if ((row[i] & (1 << matrix[i][j])) != 0 && !rowFlag[i]) {
                        rowFlag[i] = true;
                        rowCount++;
                    }
                    if ((col[j] & (1 << matrix[i][j])) != 0 && !colFlag[j]) {
                        colFlag[j] = true;
                        columnCount++;
                    }
                    row[i] |= (1 << matrix[i][j]);
                    col[j] |= (1 << matrix[i][j]);
                }
            }
            System.out.println("Case #" + (k + 1) + ": " + traceCount + " " + rowCount + " " + columnCount);
        }
    }
}
