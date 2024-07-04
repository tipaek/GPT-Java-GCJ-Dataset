import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test = 1; test <= T; test++) {
            int n = sc.nextInt();
            int[][] ar = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = sc.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += ar[i][i];
            }

            // Count duplicate rows and columns
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                boolean rowFlag = false;
                boolean colFlag = false;

                for (int j = 0; j < n; j++) {
                    int rowValue = ar[i][j];
                    int colValue = ar[j][i];

                    for (int k = j + 1; k < n; k++) {
                        if (rowValue == ar[i][k] && !rowFlag) {
                            duplicateRows++;
                            rowFlag = true;
                        }
                        if (colValue == ar[k][i] && !colFlag) {
                            duplicateCols++;
                            colFlag = true;
                        }
                        if (rowFlag && colFlag) {
                            break;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", test, trace, duplicateRows, duplicateCols);
        }

        sc.close();
    }
}