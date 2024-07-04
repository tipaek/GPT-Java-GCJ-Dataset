import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();

            System.out.println("Case #" + i + ": " + solve(n, d, in));
        }
    }

    private static int solve(int n, int d, Scanner in) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            counts.compute(in.nextInt(), (next, cnt) -> {
                if (cnt == null) return 1;
                return cnt + 1;
            });
        }

        int maxCount = counts.values().stream().mapToInt(i -> i).max().getAsInt();

        if (maxCount >= d)
            return 0;


        return Math.min(d - 1, d - maxCount);
    }
}