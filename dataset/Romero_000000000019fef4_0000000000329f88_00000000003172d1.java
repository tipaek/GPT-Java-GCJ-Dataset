import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long cases = in.nextInt();
        for (long i = 1; i <= cases; ++i) {
            long slices = in.nextInt();
            long diners = in.nextInt();
            // size -> count
            Map<Long, Long> map = new HashMap<>();
            for (long j = 0; j < slices; j++) {
                long sliceSize = in.nextLong();
                if (map.containsKey(sliceSize)) {
                    map.put(sliceSize, map.get(sliceSize) + 1);
                } else {
                    map.put(sliceSize, 1L);
                }
            }
            if (diners == 2) {
                boolean duplicated = map.values().stream().anyMatch(v -> v >= 2);
                if (duplicated) {
                    System.out.println(String.format("Case #%d: %s", i, 0));
                } else {
                    System.out.println(String.format("Case #%d: %s", i, 1));
                }
            } else {
                boolean triplicated = map.values().stream().anyMatch(v -> v >= 3);
                boolean duplicated = map.values().stream().anyMatch(v -> v >= 2);
                boolean hasDouble = map.keySet().stream().anyMatch(curSliceSize -> map.containsKey(curSliceSize * 2));

                if (triplicated) {
                    System.out.println(String.format("Case #%d: %s", i, 0));
                } else if (duplicated || hasDouble) {
                    System.out.println(String.format("Case #%d: %s", i, 1));
                } else {
                    System.out.println(String.format("Case #%d: %s", i, 2));
                }
            }

        }
    }
}
