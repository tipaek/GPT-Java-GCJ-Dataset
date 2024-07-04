import java.util.*;
import java.io.*;

class Solution {
    static class IntervalSet {
        private final TreeMap<Integer, Integer> intervals;

        public IntervalSet() {
            intervals = new TreeMap<>();
        }

        // Insert an interval [l, r]
        public void insert(int l, int r) {
            if (intervals.isEmpty()) {
                intervals.put(l, r);
                return;
            }

            Integer low = intervals.floorKey(l);
            Integer cur = low;
            if (low == null || intervals.get(low) < l) {
                low = l;
                cur = intervals.higherKey(low);
            }

            while (cur != null && intervals.get(cur) < r) {
                intervals.remove(cur);
                cur = intervals.higherKey(cur);
            }

            if (cur == null || cur > r) {
                intervals.put(low, r);
            } else {
                int high = intervals.get(cur);
                intervals.remove(cur);
                intervals.put(low, high);
            }
        }

        // Remove an interval [l, r], returns true if exists
        public boolean remove(int l, int r) {
            if (intervals.containsKey(l) && intervals.get(l) == r) {
                intervals.remove(l);
                return true;
            }
            return false;
        }

        // Query a point [l, r], returns true if exists an interval [l, r] such that l <= x <= r
        public boolean query(int l, int r) {
            Integer low = intervals.lowerKey(r);
            return low != null && intervals.get(low) > l;
        }

        // Returns a string representation of the intervals
        @Override
        public String toString() {
            if (intervals.isEmpty()) return "";
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                sb.append('[').append(entry.getKey()).append(',').append(entry.getValue()).append("],");
            }
            return sb.substring(0, sb.length() - 1);
        }

        // Returns the number of intervals
        public int size() {
            return intervals.size();
        }

        // Returns an iterator of the set
        public Iterator<Map.Entry<Integer, Integer>> iterator() {
            return intervals.entrySet().iterator();
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                int d = in.nextInt();
                int[][] arr = new int[d][2];
                for (int j = 0; j < d; j++) {
                    arr[j][0] = in.nextInt();
                    arr[j][1] = in.nextInt();
                }
                System.out.println("Case #" + i + ": " + solve(arr));
            }
        }
    }

    public static String solve(int[][] arr) {
        IntervalSet c = new IntervalSet();
        IntervalSet j = new IntervalSet();

        StringBuilder sb = new StringBuilder();
        for (int[] interval : arr) {
            if (j.query(interval[0], interval[1]) && c.query(interval[0], interval[1])) {
                return "IMPOSSIBLE";
            } else if (!c.query(interval[0], interval[1])) {
                c.insert(interval[0], interval[1]);
                sb.append("C");
            } else {
                j.insert(interval[0], interval[1]);
                sb.append("J");
            }
        }
        return sb.toString();
    }
}