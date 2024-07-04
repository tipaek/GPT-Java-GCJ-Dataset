import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            int n = Integer.parseInt(br.readLine()), trace = 0, rRep = 0, cRep = 0;
            int[][] matrix = new int[n][n];
            int[][] row = new int[n][n], col = new int[n][n];
            boolean[] brow = new boolean[n], bcol = new boolean[n];
            for (int i = 0; i < n; ++i) {
                String[] ss = br.readLine().split("\\s+");
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(ss[j]);
                    if (i == j) trace += matrix[i][j];
                    if (2 == ++row[i][matrix[i][j] - 1]) brow[i] = true;
                    if (2 == ++col[j][matrix[i][j] - 1]) bcol[j] = true;
                }
            }
            for (boolean b : brow) if (b) rRep++;
            for (boolean b : bcol) if (b) cRep++;
            System.out.format("Case #%d: %d %d %d\n", t, trace, rRep, cRep);
        }
        br.close();
    }
}
