import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static final int MOD = 1000000007;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static class Wrapper {
        int start;
        int end;

        Wrapper(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Wrapper wrapper = (Wrapper) o;
            return start == wrapper.start && end == wrapper.end;
        }

        @Override
        public int hashCode() {
            return 31 * start + end;
        }
    }

    public static void main(String[] args) throws Exception {
        int testCases = Integer.parseInt(in.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(in.readLine());
            int[][] intervals = new int[n][2];
            List<Wrapper> cList = new ArrayList<>();
            List<Wrapper> jList = new ArrayList<>();
            List<Wrapper> wList = new ArrayList<>();
            Map<Wrapper, Character> schedule = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] parts = in.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
                wList.add(new Wrapper(intervals[i][0], intervals[i][1]));
            }

            wList.sort(Comparator.comparingInt((Wrapper w) -> w.start).thenComparingInt(w -> w.end));

            boolean possible = true;
            for (Wrapper w : wList) {
                if (isAllowed(cList, w.start, w.end)) {
                    cList.add(new Wrapper(w.start, w.end));
                    schedule.put(w, 'C');
                } else if (isAllowed(jList, w.start, w.end)) {
                    jList.add(new Wrapper(w.start, w.end));
                    schedule.put(w, 'J');
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    Wrapper w = new Wrapper(intervals[i][0], intervals[i][1]);
                    result.append(schedule.get(w));
                }
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
        in.close();
    }

    private static boolean isAllowed(List<Wrapper> list, int start, int end) {
        for (Wrapper w : list) {
            if (w.end <= start || w.start >= end) continue;
            return false;
        }
        return true;
    }
}