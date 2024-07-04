
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int n = in.nextInt();
            int cC = 0;
            int rC = 0;
            int sum = 0;
            Map<Integer, Set<Integer>> cols = new HashMap<>();
            for (int r = 0; r < n; r++) {
                Set<Integer> cache = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    final int value = in.nextInt();
                    cache.add(value);
                    if (r == c) {
                        sum += value;
                    }
                    cols.compute(c, (key, set) -> {
                        if (set == null) {
                            set = new HashSet<>();
                        }
                        set.add(value);
                        return set;
                    });
                }
                if (cache.size() != n) {
                    rC += 1;
                }
            }
            for (Set<Integer> value : cols.values()) {
                if (value.size() != n) {
                    cC += 1;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sum + " " + rC + " " + cC + "");
        }
    }
}
