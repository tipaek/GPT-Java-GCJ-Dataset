import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = input.nextInt();

            if (n <= 1 || n >= 8) {
                System.out.printf("Case #%d: %d\n", caseNum, n);
                continue;
            }

            long[][] points = new long[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = input.nextInt();
                points[i][1] = input.nextInt();
            }

            List<int[]> whs = new ArrayList<>();
            int[] twh = new int[n];
            for (int i = 0; i < n; i++)
                twh[i] = -1;
            solve(0, twh, whs);

            int max = 0;
            for (int pi = 0; pi < n; pi++)
                for (int pj = pi + 1; pj < n; pj++) {
                    if (pi == pj)
                        continue;

                    long dx1 = points[pi][0] - points[pj][0];
                    long dy1 = points[pi][1] - points[pj][1];

                    int[] next = new int[n];
                    double[] dist = new double[n];
                    for (int i = 0; i < n; i++) {
                        next[i] = -1;
                        dist[i] = Double.MAX_VALUE / 3;
                    }
                    // find next point on slope (pi, pj)
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            if (j != i) {
                                long dx2 = points[i][0] - points[j][0];
                                long dy2 = points[i][1] - points[j][1];
                                if (dx1 * dy2 == dx2 * dy1) {
                                    if (Math.signum(dx1) == Math.signum(dx2) && Math.signum(dy1) == Math.signum(dy2)) {
                                        if (Math.hypot(dx2, dy2) < dist[i]) {
                                            next[i] = j;
                                            dist[i] = Math.hypot(dx2, dy2);
                                        }
                                    }
                                }
                            }

                    // simulate golf
                    for (int[] wh : whs) {
                        for (int start = 0; start < n; start++) {
                            boolean[] used = new boolean[n];
                            int x = start;
                            used[x] = true;
                            for (int xx = 0; xx <= n; xx++) {
                                if (wh[x] == -1)
                                    break;
                                x = wh[x];
                                used[x] = true;
                                if (next[x] == -1)
                                    break;
                                x = next[x];
                                used[x] = true;
                            }
                            int count = 0;
                            for (int i = 0; i < n; i++)
                                if (used[i])
                                    count++;
                            if (count > max)
                                max = count;
                        }
                    }
                }

            System.out.printf("Case #%d: %d\n", caseNum, max);
        }
    }

    static void solve(int index, int[] wh, List<int[]> whs) {
        if (index == wh.length) {
            whs.add(Arrays.copyOf(wh, wh.length));
            return;
        }

        solve(index + 1, wh, whs);

        if (wh[index] == -1) {
            for (int i = index + 1; i < wh.length; i++)
                if (wh[i] == -1) {
                    wh[index] = i;
                    wh[i] = index;
                    solve(index + 1, wh, whs);
                    wh[index] = wh[i] = -1;
                }
        }
    }
}
