import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] traceResults = new int[t];
        int[] rowDuplicates = new int[t];
        int[] colDuplicates = new int[t];

        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] rowCount = new int[101]; // Assuming values are within 1 to 100

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowCount[matrix[i][j]]++;

                    if (rowCount[matrix[i][j]] == 2) {
                        rowDuplicateCount++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int[] colCount = new int[101]; // Assuming values are within 1 to 100

                for (int i = 0; i < n; i++) {
                    colCount[matrix[i][j]]++;

                    if (colCount[matrix[i][j]] == 2) {
                        colDuplicateCount++;
                    }
                }
            }

            traceResults[caseIndex] = trace;
            rowDuplicates[caseIndex] = rowDuplicateCount;
            colDuplicates[caseIndex] = colDuplicateCount;
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traceResults[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }
}