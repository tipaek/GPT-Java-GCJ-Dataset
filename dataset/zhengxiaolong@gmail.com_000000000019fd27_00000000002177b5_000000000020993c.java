import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int sum = (n + 1) * n / 2;
            int k = 0, r = 0, c = 0;
            int[][] colCount = new int[n + 1][n + 1];
            for (int row = 1; row <= n; ++row) {
                int[] rowCount = new int[n + 1];
                for (int col = 1; col <=n; ++col) {
                    int nextInt = in.nextInt();
                    rowCount[nextInt]++;
                    colCount[col][nextInt]++;
                    if (row == col) k += nextInt;
                }

                for (int col = 1; col <=n; ++col) {
                    if (rowCount[col] != 1) {
                        ++r;
                        break;
                    }
                }
            }

            for (int j = 1; j <=n; ++j) {
                for (int countIdx = 1; countIdx <=n; ++countIdx) {
                    if (colCount[j][countIdx] != 1) {
                        ++c;
                        break;
                    }
                }
            }

            String output = String.format("Case #%d: %d %d %d", i, k, r, c);
            System.out.println(output);
        }
    }
}