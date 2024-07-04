import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Number of test cases.

        for (int i = 0; i < t; ++i) {
            
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0, r = 0, c = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();

                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                row:
                for (int k = 0; k < n - 1; k++) {
                    // Rows
                    for (int l = k + 1; l < n; l++) {
                        if (matrix[j][k] == matrix[j][l]) {
                            r++;
                            break row;
                        }
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                column:
                for (int k = 0; k < n - 1; k++) {
                    // Columns
                    for (int l = k + 1; l < n; l++) {
                        if (matrix[k][j] == matrix[l][j]) {
                            c++;
                            break column;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", i + 1, trace, r, c);
    }

        in.close();
    }
}
