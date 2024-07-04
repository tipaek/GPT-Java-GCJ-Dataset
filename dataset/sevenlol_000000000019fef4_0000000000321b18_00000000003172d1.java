import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            long[] A = new long[N];
            for (int j = 0; j < N; j++) {
                A[j] = sc.nextLong();
            }

            solve(i, N, D, A);
        }
    }

    private static void solve(int T, int N, int D, long[] A) {
        System.out.format("Case #%d: ", T);

        if (D == 2) {
            Set<Long> vs = new HashSet<>();
            int res = 1;
            for (long v : A) {
                if (!vs.add(v)) {
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(res);
            return;
        } else if (D == 3) {
            Set<Long> vs = new HashSet<>();
            Arrays.sort(A);
            int res = 2;
            for (int i = A.length - 1; i >= 0; i--) {
                if (vs.contains(A[i] * 2)) {
                    res = Math.min(res, 1);
                }
                int cnt = 1;
                while (i > 0 && A[i - 1] == A[i]) {
                    cnt++;
                    i--;
                }
                if (cnt == 3) {
                    System.out.println(0);
                    return;
                } else if (cnt == 2) {
                    if (i < N - 2) {
                        res = Math.min(res, 1);
                    }
                }
                vs.add(A[i]);
            }
            System.out.println(res);
            return;
        }
        System.out.println(-1);
    }
}