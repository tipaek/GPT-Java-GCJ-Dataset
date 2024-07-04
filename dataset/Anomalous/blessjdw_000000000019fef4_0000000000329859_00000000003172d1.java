import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in); 
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {
            solve(in, out);
        }
    }

    static void solve(Scanner in, PrintWriter out) {
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int D = in.nextInt();
            long[] slices = new long[N];
            for (int n = 0; n < N; n++) {
                slices[n] = in.nextLong();
            }

            int ans = 0;

            if (D == 1) {
                out.println("Case #" + (t + 1) + ": " + ans);
                continue;
            }

            if (slices.length == 1) {
                ans = D - 1;
                out.println("Case #" + (t + 1) + ": " + ans);
                continue;
            }

            Map<Long, Integer> counter = new HashMap<>();
            for (long slice : slices) {
                counter.put(slice, counter.getOrDefault(slice, 0) + 1);
            }

            if (hasMuch(counter, D)) {
                out.println("Case #" + (t + 1) + ": " + ans);
                continue;
            }

            boolean NK = false;
            for (Map.Entry<Long, Integer> entry : counter.entrySet()) {
                if (entry.getValue() >= 2) {
                    for (long slice : slices) {
                        if (entry.getKey().equals(slice)) {
                            NK = true;
                            break;
                        }
                    }
                }
            }

            Arrays.sort(slices);
            outerLoop:
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (slices[j] % slices[i] == 0 && (slices[j] / slices[i]) == 2) {
                        NK = true;
                        break outerLoop;
                    }
                }
            }

            if (NK) {
                out.println("Case #" + (t + 1) + ": " + 1);
            } else {
                out.println("Case #" + (t + 1) + ": " + (D - 1));
            }
        }
    }

    static boolean hasMuch(Map<Long, Integer> counter, int d) {
        for (int count : counter.values()) {
            if (count >= d) return true;
        }
        return false;
    }
}