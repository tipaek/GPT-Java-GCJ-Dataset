import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int caseNo = 1; caseNo <= T; caseNo++) {
            int N = scan.nextInt();
            long D = scan.nextLong();
            long[] A = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = scan.nextLong();
            }
            Arrays.sort(A);
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                long cut = 0;
                long total = 1;
                long remain = D-1;
                for (int j = i + 1; j < N && 0 < remain; j++) {
                    if (A[i] == A[j]) {
                        remain -= 1;
                        total += 1;
                        continue;
                    }
                    if (A[j] % A[i] == 0) {
                        long x = A[j] / A[i];
                        if (remain + 1 < x) {
                            total += remain;
                            cut += remain;
                            remain -= remain;
                        } else {
                            total += Math.min(remain, x);
                            cut += x - 1;
                            remain -= Math.min(remain, x);
                        }
                    } else {
                        long x = A[j] / A[i];
                        if (remain < x) {
                            total += remain;
                            cut += remain;
                            remain -= remain;
                        } else {
                            total += x;
                            cut += x;
                            remain -= x;
                        }
                    }
                }
                if (remain == 0) {
                    ans = Math.min(ans, cut);
                    continue;
                }
                if (total == 1) {
                    ans = Math.min(ans, D - 1);
                    continue;
                }
                if (D % total == 0) {
                    cut += (D/total - 1) * total;
                    ans = Math.min(ans, cut);
                } else {
                    ans = Math.min(ans, cut + D);
                }
            }
            System.out.printf("Case #%d: %s\n", caseNo, ans);
        }
    }
}
