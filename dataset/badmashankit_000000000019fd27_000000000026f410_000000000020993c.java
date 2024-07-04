import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int x = 1; x <= T; ++x) {
            int N = Integer.parseInt(br.readLine());
            int[][] M = new int[N][N];
            // Final output variables
            int k = 0;
            int r = 0;
            int c = 0;

            

            for (int i = 0; i < N; ++i) {
                boolean[] freqRow = new boolean[N + 1];
                String[] line = br.readLine().split(" ");
                boolean rowCounted = false;
                for (int j = 0; j < N; ++j) {
                    M[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        k += M[i][j];
                    }
                    int num = M[i][j];
                    if (!rowCounted && !freqRow[num]) {
                        freqRow[num] = true;
                    } else if (!rowCounted && freqRow[num]) {
                        rowCounted = true;
                        ++r;
                    }
                }
            }

            for (int i = 0; i < N; ++i) {
                boolean[] freqColumn = new boolean[N + 1];
                boolean colCounted = false;
                for (int j = 0; j < N; ++j) {
                    int num = M[j][i];
                    if (!colCounted && !freqColumn[num]) {
                        freqColumn[num] = true;
                    } else if (!colCounted && freqColumn[num]) {
                        colCounted = true;
                        ++c;
                    }
                }
            }


            // final output
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
    }
}