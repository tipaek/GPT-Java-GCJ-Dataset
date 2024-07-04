import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Am {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(input.readLine());
            int[][] arr = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                String[] row = input.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }

            // Checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[arr[i][j]]) {
                        rowCount++;
                        break;
                    }
                    rowCheck[arr[i][j]] = true;
                }
            }

            // Checking for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (colCheck[arr[j][i]]) {
                        colCount++;
                        break;
                    }
                    colCheck[arr[j][i]] = true;
                }
            }

            System.out.println(trace + " " + rowCount + " " + colCount);
        }
    }
}