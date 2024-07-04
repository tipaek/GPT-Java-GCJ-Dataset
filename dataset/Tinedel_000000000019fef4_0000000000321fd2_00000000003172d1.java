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
        Map<Long, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            counts.compute(in.nextLong(), (next, cnt) -> {
                if (cnt == null) return 1;
                return cnt + 1;
            });
        }

        int maxPieces = counts.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        if(d == 2) {
            if(maxPieces > 1) {
                return 0;
            } else {
                return 1;
            }
        } else if(d == 3) {
           if(maxPieces > 2) {
               return 0;
           }
           if(canSplit1(counts)) {
               return 1;
           } else {
               return 2;
           }
        }

        return maxPieces - d;
    }

    private static boolean canSplit1(Map<Long, Integer> counts) {
        for (Map.Entry<Long, Integer> pieces : counts.entrySet()) {
            if(counts.containsKey(pieces.getKey()/2)) {
                return true;
            }
        }
        return false;
    }
}