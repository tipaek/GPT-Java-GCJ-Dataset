import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private Scanner sc = new Scanner(System.in);

    private void solve() {
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = sc.nextInt();
            }
        }

        int rCnt = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            boolean hasRepeat = false;
            for (int j = 0; j < n; ++j) {
                if (set.contains(a[i][j])) {
                    hasRepeat = true;
                    break;
                }
                set.add(a[i][j]);
            }

            if (hasRepeat) {
                ++rCnt;
            }
        }

        int cCnt = 0;
        for (int j = 0; j < n; ++j) {
            Set<Integer> set = new HashSet<>();
            boolean hasRepeat = false;
            for (int i = 0; i < n; ++i) {
                if (set.contains(a[i][j])) {
                    hasRepeat = true;
                    break;
                }
                set.add(a[i][j]);
            }

            if (hasRepeat) {
                ++cCnt;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += a[i][i];
        }

        System.out.println(String.format("%d %d %d", sum, rCnt, cCnt));
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            System.out.println(String.format("Case #%d: ", i + 1));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
