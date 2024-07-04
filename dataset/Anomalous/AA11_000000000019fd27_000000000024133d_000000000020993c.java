import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] traces = new int[t];
        int[] rowDuplicates = new int[t];
        int[] colDuplicates = new int[t];

        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowDupCount = 0, colDupCount = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] rowCheck = new int[101];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowCheck[matrix[i][j]]++;
                    if (rowCheck[matrix[i][j]] > 1) {
                        rowDupCount++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int[] colCheck = new int[101];
                for (int i = 0; i < n; i++) {
                    colCheck[matrix[i][j]]++;
                    if (colCheck[matrix[i][j]] > 1) {
                        colDupCount++;
                        break;
                    }
                }
            }

            traces[caseIndex] = trace;
            rowDuplicates[caseIndex] = rowDupCount;
            colDuplicates[caseIndex] = colDupCount;
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traces[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }
}