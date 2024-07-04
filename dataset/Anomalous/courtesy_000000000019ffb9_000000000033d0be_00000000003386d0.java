import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = scanner.nextInt();
            long[][] P = new long[N][2];
            for (int i = 0; i < N; i++) {
                P[i][0] = scanner.nextLong();
                P[i][1] = scanner.nextLong();
            }
            int ans = calculateMaxPairs(N, P);
            System.out.println("Case #" + cs + ": " + ans);
        }
        writer.close();
    }

    private static int calculateMaxPairs(int N, long[][] P) {
        int maxPairs = 1;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean[] visited = new boolean[N];
                int pairs = 0;
                int remainder = 0;

                for (int k = 0; k < N; k++) {
                    if (visited[k]) continue;
                    visited[k] = true;
                    int count = 1;

                    for (int kk = 0; kk < N; kk++) {
                        if (visited[kk]) continue;
                        if (areCollinear(i, j, k, kk, P)) {
                            visited[kk] = true;
                            count++;
                        }
                    }

                    pairs += count / 2;
                    if (count > 1 && count % 2 == 1) remainder++;
                }

                int total = pairs * 2;
                if (remainder % 2 == 0) {
                    total += remainder;
                } else {
                    total += remainder - 1;
                }
                total = Math.min(total + 2, N);
                maxPairs = Math.max(maxPairs, total);
            }
        }
        return maxPairs;
    }

    private static boolean areCollinear(int p11, int p12, int p21, int p22, long[][] points) {
        if (points[p11][1] > points[p12][1]) {
            int temp = p11;
            p11 = p12;
            p12 = temp;
        }
        if (points[p21][1] > points[p22][1]) {
            int temp = p21;
            p21 = p22;
            p22 = temp;
        }

        long x1d = points[p12][0] - points[p11][0];
        long y1d = points[p12][1] - points[p11][1];
        long x2d = points[p22][0] - points[p21][0];
        long y2d = points[p22][1] - points[p21][1];

        return y1d * x2d == y2d * x1d;
    }
}