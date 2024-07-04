/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t++ < T; ) {
            int N = parseInt(in.readLine());
            int[][] mat = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++)
                    mat[i][j] = parseInt(st.nextToken());
            }
            int diag = 0;
            int col = 0;
            int row = 0;
            for (int i = 0; i < N; i++) {
                int[] rows = new int[N];
                int[] cols = new int[N];
                for (int j = 0; j < N; j++) {
                    rows[mat[i][j] - 1]++;
                    cols[mat[j][i] - 1]++;
                    if (i == j)
                        diag += mat[i][j];
                }
                for (int j = 0; j < N; j++)
                    if (rows[j] > 1) {
                        row++;
                        break;
                    }
                for (int j = 0; j < N; j++)
                    if (cols[j] > 1) {
                        col++;
                        break;
                    }
            }
            sb.append("Case #").append(t).append(": ");
            sb.append(diag+" ");
            sb.append(row+" ");
            sb.append(col+" ");
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
