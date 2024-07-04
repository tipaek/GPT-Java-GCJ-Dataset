import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int SIZE = 128;
            String[][][] dp = new String[SIZE * 2 + 1][SIZE * 2 + 1][30];
            dp[SIZE][SIZE][0] = "";
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            char[] directions = {'E', 'N', 'W', 'S'};
            int step = 1;

            boolean found = false;
            for (int move = 0; move < dp[0][0].length; move++) {
                for (int i = 0; i < dp.length; i++) {
                    for (int j = 0; j < dp[0].length; j++) {
                        if (dp[i][j][move] == null) continue;
                        if (i - SIZE == x && j - SIZE == y) {
                            System.out.println("Case #" + test + ": " + dp[i][j][move]);
                            found = true;
                            break;
                        }
                        for (int dir = 0; dir < dx.length; dir++) {
                            int ni = i + step * dx[dir];
                            int nj = j + step * dy[dir];
                            if (ni >= 0 && ni < dp.length && nj >= 0 && nj < dp[0].length) {
                                dp[ni][nj][move + 1] = dp[i][j][move] + directions[dir];
                            }
                        }
                    }
                    if (found) break;
                }
                if (found) break;
                step *= 2;
            }
            if (!found) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}