import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            for(int k = 1 ; k <= T ; ++k) {
                int N = Integer.parseInt(br.readLine());
                int[][] row = new int[N][101];
                int[][] column = new int[N][101];
                boolean[] row_done = new boolean[N];
                Arrays.fill(row_done, false);
                boolean[] column_done = new boolean[N];
                Arrays.fill(column_done, false);

                int[][] arr = new int[N][N];

                for (int i = 0; i < N; ++i) {
                    String[] s = br.readLine().split(" ");
                    for (int j = 0; j < N; ++j) arr[i][j] = Integer.parseInt(s[j]);
                    Arrays.fill(row[i], 0);
                    Arrays.fill(column[i], 0);
                }

                long trace = 0;
                int r = 0, c = 0;

                for (int i = 0; i < N; ++i) trace += arr[i][i];
                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < N; ++j) {
                        ++row[i][arr[i][j]];
                        ++column[j][arr[i][j]];

                        if (row[i][arr[i][j]] > 1 && !row_done[i]) {
                            ++r;
                            row_done[i] = true;
                        }

                        if (column[j][arr[i][j]] > 1 && !column_done[j]) {
                            ++c;
                            column_done[j] = true;
                        }
                    }
                }

                System.out.println("Case #" + k + ": " + trace + " " + r + " " + c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}