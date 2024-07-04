

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] matrix = new int[N][N];
            int row_count = 0;
            int col_count = 0;
            String[] input = new String[N];
            for (int j = 0; j < N; j++) {
                input = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {

                    matrix[j][k] = Integer.parseInt(input[k]);
                }

            }

            for (int m = 0; m < N; m++) {
                int[] row_freq = new int[N + 1];
                for (int n = 0; n < N; n++) {
                    //row by col
                    int val_rbc = matrix[m][n];
                    row_freq[val_rbc] += 1;
                    if (row_freq[val_rbc] > 1) {
                        row_count += 1;
                        break;
                    }
                }
            }
                for (int m = 0; m < N; m++) {
                    int[] col_freq = new int[N+1];

                    for (int n = 0; n < N; n++) {

                        // col by row
                        int val_cbr = matrix[n][m];
                        col_freq[val_cbr] += 1;


                        if (col_freq[val_cbr] > 1) {
                            col_count += 1;
                            break;
                        }

                    }
                }

            int diagonal_sum = 0;
            for (int z = 0; z < N; z++) {
                diagonal_sum += matrix[z][z];
            }

            System.out.println("Case #"
                    + i
                    + ": "
                    + diagonal_sum + " "
                    + row_count + " "
                    + col_count);
        }
    }
}

