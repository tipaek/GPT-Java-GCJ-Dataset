
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        
        for (int i = 1; i <= n; i++) {
            // char to range
                    final int u = in.nextInt();
            final Map<String, int[]> ranges = new HashMap<>();
            final Set<String> all = new HashSet<>();
            for (int j = 0; j < 10_000; j++) {
                final long qi = in.nextLong();
                final int max = Integer.parseInt((qi + "").charAt(0) + "");
                final int length = (int) (Math.log10(qi) + 1);
                final String ri = in.next();
                if (length == ri.length()) {
                    final String target = ri.charAt(0) + "";
                    if (length == 1) {
                        // 0~max
                        ranges.compute(target, (s, current) -> {
                            if (current == null) {
                                return new int[]{0, max};
                            } else {
                                return new int[]{Math.max(current[0], 0), Math.min(current[1], max)};
                            }
                        });
                    } else {
                        // target range is 1 ~ max
                        ranges.compute(target, (s, current) -> {
                            if (current == null) {
                                return new int[]{1, max};
                            } else {
                                return new int[]{Math.max(current[0], 1), Math.min(current[1], max)};
                            }
                        });
                    }
                }
                // check right most digit
                for (char c : ri.toCharArray()) {
                    all.add(c + "");
                }
            }
            final List<Map.Entry<String, int[]>> result = ranges.entrySet().stream().sorted((o1, o2) -> {
                final int[] range2 = o2.getValue();
                final int[] range1 = o1.getValue();
                if (range1[0] != range2[0]) {
                    return Integer.compare(range1[0], range2[0]);
                }
                return Integer.compare(range1[1], range2[1]);
            }).collect(Collectors.toList());
            all.removeAll(ranges.keySet());
            final List<String> temps = new ArrayList<>(all);
            final StringBuilder r = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                if (result.isEmpty()) {
                    r.append(temps.remove(0));
                    continue;
                }
                final Map.Entry<String, int[]> entry = result.get(0);
                if (j >= entry.getValue()[0] && j <= entry.getValue()[1]) {
                    result.remove(0);
                    r.append(entry.getKey());
                } else {
                    r.append(temps.remove(0));
                }
            }
            System.out.println("Case #" + i + ": " + r);
        }
    }
}
