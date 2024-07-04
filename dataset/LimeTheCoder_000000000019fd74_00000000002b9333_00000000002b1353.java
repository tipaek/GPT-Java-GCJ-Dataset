import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        int[][] pascal = new int[500][500];

        for (int i = 0; i < 500; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<String> res = new ArrayList<>();
            dp(res, pascal, 0, 0, n, 0);
            System.out.println(String.format("Case #%d:", i) );
            for (int k = res.size() - 1; k >= 0; k--) {
                System.out.println(res.get(k));
            }
        }
    }

    private static boolean dp(List<String> res, int[][] pascal, int i, int j, int sum, int steps) {
        if (i < 0 || j < 0 || i >= 500 || j >= 500 || pascal[i][j] == 0 || steps > 500) {
            return false;
        }

        sum -= pascal[i][j];

        if (sum < 0) {
            return false;
        }

        int tmp = pascal[i][j];
        pascal[i][j] = 0;

        if (sum == 0 || dp(res, pascal, i - 1, j, sum, steps + 1)
                || dp(res, pascal, i - 1, j - 1, sum, steps + 1)
                || dp(res, pascal, i, j - 1, sum, steps + 1)
                || dp(res, pascal, i, j + 1, sum, steps + 1)
                || dp(res, pascal, i + 1, j, sum, steps + 1)
                || dp(res, pascal, i + 1, j + 1, sum, steps + 1)) {
            res.add(String.format("%d %d", i + 1, j + 1));
            pascal[i][j] = tmp;
            return true;
        }

        pascal[i][j] = tmp;
        return false;
    }
}