
import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        int N = sc.nextInt();
        int D = sc.nextInt();
        long[] A = new long[N];

        Map<Long, Integer> c = new HashMap<>();
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
            c.put(A[i], c.getOrDefault(A[i], 0) + 1);
        }

        for (int v : c.values()) {
            if (v >= D) {
                System.out.println("0");
                return;
            }
        }

        if (D == 2) {
            System.out.println("1");
            return;
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(A[j] == A[i] * 2) {
                    System.out.println("1");
                    return;
                }
            }
        }

        for (int i = 1; i < N - 1; ++i) {
            if (A[i] == A[i - 1]) {
                System.out.println("1");
                return;
            }
        }

        System.out.println("2");
    }

    private void run() {
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            System.out.print(String.format("Case #%d: ", t));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}