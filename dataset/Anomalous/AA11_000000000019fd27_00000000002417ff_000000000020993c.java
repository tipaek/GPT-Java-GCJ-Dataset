import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] traceResults = new int[t];
        int[] rowDuplicates = new int[t];
        int[] colDuplicates = new int[t];

        for (int h = 0; h < t; h++) {
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
                }
                for (int value : rowCheck) {
                    if (value > 1) {
                        rowDupCount++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int[] colCheck = new int[101];
                for (int i = 0; i < n; i++) {
                    colCheck[matrix[i][j]]++;
                }
                for (int value : colCheck) {
                    if (value > 1) {
                        colDupCount++;
                        break;
                    }
                }
            }

            traceResults[h] = trace;
            rowDuplicates[h] = rowDupCount;
            colDuplicates[h] = colDupCount;
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traceResults[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }
}