import java.io.*;

public class Am {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(input.readLine());
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                String[] rowElements = input.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(rowElements[j]);
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }

            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[arr[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[arr[i][j]] = true;
                }
            }

            // Check for column duplicates
            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (colCheck[arr[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[arr[j][i]] = true;
                }
            }

            System.out.println(trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}