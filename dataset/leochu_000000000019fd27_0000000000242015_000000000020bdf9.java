import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int[][] input = new int[size][2];
            for (int j = 0; j < size; j++) {
                input[j][0] = in.nextInt();
                input[j][1] = in.nextInt();
            }
            ParentingPartneringReturn solution = new ParentingPartneringReturn(input);
            System.out.println("Case #" + i + ": " + solution.getParentingSchedule());
        }
    }
    private static class ParentingPartneringReturn {

        private static final char[] parents = new char[]{'C', 'J'};
        private int[][] interval;
        private TreeMap<Integer, Integer> delta;
        private Map<Integer, Integer> table;
        private int[] order;

        ParentingPartneringReturn(int[][] interval) {
            order = new int[interval.length];
            delta = new TreeMap<>();
            table = new HashMap<>();
            this.interval = new int[interval.length][2];
            for (int i = 0; i < interval.length; i++) {
                if (interval[i][0] >= interval[i][1] || interval[i][0] < 0 || interval[i][1] < 0) {
                    throw new IllegalStateException();
                }
                this.interval[i][0] = interval[i][0];
                this.interval[i][1] = interval[i][1];
                table.put(interval[i][0], interval[i][1]);
                order[i] = interval[i][0];
            }
            Arrays.sort(this.interval, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
        }

        String getParentingSchedule() {
            for (int[] ints : interval) {
                int start = ints[0];
                int end = ints[1];

                delta.put(start, delta.getOrDefault(start, 0) + 1);
                delta.put(end, delta.getOrDefault(end, 0) - 1);
            }


            int prefixSum = 0;
            Map<Integer, Character> map = new HashMap<>();
            int[] available = new int[]{-1, -1};
            for (Map.Entry<Integer, Integer> entry: delta.entrySet()) {
                prefixSum += entry.getValue();
                if (prefixSum >= 3) {
                    return "IMPOSSIBLE";
                }
                if (table.containsKey(entry.getKey())) {
                    int start = entry.getKey();
                    int end = table.get(entry.getKey());
                    for (int i = 0; i < 2; i++) {
                        if (start >= available[i]) {
                            map.put(start, parents[i]);
                            available[i] = end;
                            break;
                        }
                    }
                }
            }

            StringBuilder schedule = new StringBuilder();
            for (int num: order) {
                schedule.append(map.get(num));
            }
            return schedule.toString();
        }
    }
}