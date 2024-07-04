import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        solve(in, out);
        out.close();
    }

    static void solve(Scanner in, PrintWriter out) {
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt(), D = in.nextInt();
            long[] slices = new long[N];
            for (int n = 0; n < N; n++) {
                 slices[n] = in.nextLong();
            }

            int ans = 0;

            // # D == 1
            if (D == 1) {
                ans = 0;
                out.println("Case #" + (t+1) + ": " + ans);
                continue;
            }
            // # size == 1
            if (slices.length == 1) {
                ans = D-1;
                out.println("Case #" + (t+1) + ": " + ans);
                continue;
            }

            // # counter
            Map<Long, Integer> counter = new HashMap<>();
            for (long n : slices) {
                counter.put(n, counter.getOrDefault(n, 0)+1);
            }
            if (hasMuch(counter, D)) {
                ans = 0;
                out.println("Case #" + (t+1) + ": " + ans);
                continue;
            }

            // # N-KN case
            boolean NK = false;
            Arrays.sort(slices);
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if (slices[j] % slices[i] == 0
                            && ((slices[j] / slices[i]) == 2)) {
                        NK = true;
                        break;
                    }
                }
            }
            if (NK) {
                out.println("Case #" + (t+1) + ": " + 1);
                continue;
            }


            out.println("Case #" + (t+1) + ": " + (D-1));
        }
    }

    static boolean hasMuch(Map<Long, Integer> counter, int d) {
        for (Map.Entry<Long, Integer> entry : counter.entrySet()) {
            if (entry.getValue() >= d) return true;
        }
        return false;
    }
}
