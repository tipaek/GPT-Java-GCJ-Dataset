import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] slices = new long[n];
            for (int j = 0; j < n; ++j) {
                slices[j] = in.nextLong();
            }

            String result = String.format("Case #%d: %s", i, sol.getCutNumber(n, d, slices));
            System.out.println(result);
        }
    }

    private int getCutNumber(int n, int d, long[] slices) {
        Map<Long, Integer> map = new HashMap<>();
        for (long l : slices) {
            int count = map.getOrDefault(l, 0);
            count++;

            if (count >= d) {
                return 0;
            }

            map.put(l, count);
        }

        if (d == 3) {
            for (long l : map.keySet()) {
                if (map.containsKey(l * 2)) {
                    return 1;
                }
            }
        }

        return d - 1;
    }
}
