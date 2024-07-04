
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    Scanner in = new Scanner(System.in);

    void solve(int t) {
        int r = in.nextInt(), c = in.nextInt();
        int[][] grid = new int[r][c];
        for (int i=0;i<r;i++) for (int j=0;j<c;j++) {
            grid[i][j] = in.nextInt();
        }
        int ret = 0;
        while (true) {
            boolean hasElim = false;
            int[][] g = new int[r][c];
            for (int i=0;i<r;i++) for (int j=0;j<c;j++) {
                ret += grid[i][j];
            }
            for (int i=0;i<r;i++) g[i] = Arrays.copyOf(grid[i], c);
            for (int i=0;i<r;i++) {
                for (int j=0;j<c;j++) {
                    if (g[i][j] == 0) continue;
                    int s = 0;
                    int neighbor = 0;
                    int k = i-1;
                    while (k >= 0 && g[k][j] == 0) k--;
                    if (k >= 0) {
                        s += g[k][j];
                        neighbor++;
                    }
                    k = i+1;
                    while (k < r && g[k][j] == 0) k++;
                    if (k < r) {
                        s += g[k][j];
                        neighbor++;
                    }
                    k = j-1;
                    while (k >= 0 && g[i][k] == 0) k--;
                    if (k >= 0) {
                        s += g[i][k];
                        neighbor++;
                    }
                    k = j+1;
                    while (k < c && g[i][k] == 0) k++;
                    if (k < c) {
                        s += g[i][k];
                        neighbor++;
                    }
                    if (neighbor > 0 && s > neighbor * g[i][j]) {
                        hasElim = true;
                        grid[i][j] = 0;
                    }
                }
            }
            if (!hasElim) break;
        }

        System.out.println(String.format("Case #%d: %d", t, ret));

    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) solve(t);
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
