import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            final int N = in.nextInt();
            final int[][] activities = new int[N][3];
            for (int i = 0; i < N; i ++) {
                activities[i][0] = i;
                activities[i][1] = in.nextInt();
                activities[i][2] = in.nextInt();
            }
            solve(t, N, activities);
        }
    }

    private static void solve(final int T, final int N, final int[][] activities) {
        Arrays.sort(activities, (x, y) -> {
            return x[1] == y[1] ? x[2] - y[2] : x[1] - y[1];
        });

        int C = 0;
        int J = 0;
        final int[] taken = new int[N];
        for (int i = 0; i < N; i ++) {
            if (activities[i][1] >= C) {
                taken[activities[i][0]] = 1;
                C = activities[i][2];
            }
        }
        for (int i = 0; i < N; i ++) {
            if (taken[activities[i][0]] == 1) {
                continue;
            }
            if (activities[i][1] < J) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", T);
                return;
            }
            taken[activities[i][0]] = 2;
            J = activities[i][2];
        }
        final StringBuilder r = new StringBuilder();
        for (int i = 0; i < N; i ++) {
            if (taken[i] == 0) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", T);
                return;
            }
            final char c = taken[i] == 1 ? 'C' : 'J';
            r.append(c);
        }
        System.out.printf("Case #%d: %s\n", T, r.toString());
    }
}
