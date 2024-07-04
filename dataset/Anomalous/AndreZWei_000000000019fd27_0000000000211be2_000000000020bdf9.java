import java.util.*;

class Solution {
    static class IntervalSet {
        private final TreeMap<Integer, Integer> intervals;

        public IntervalSet() {
            intervals = new TreeMap<>();
        }

        public void insert(int l, int r) {
            if (intervals.isEmpty()) {
                intervals.put(l, r);
            } else {
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
        }

        public boolean remove(int l, int r) {
            if (intervals.containsKey(l) && intervals.get(l) == r) {
                intervals.remove(l);
                return true;
            }
            return false;
        }

        public boolean query(int x) {
            Integer low = intervals.floorKey(x);
            return low != null && intervals.get(low) >= x;
        }

        @Override
        public String toString() {
            if (intervals.isEmpty()) return "";
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                sb.append('[').append(entry.getKey()).append(',').append(entry.getValue()).append("],");
            }
            return sb.substring(0, sb.length() - 1);
        }

        public int size() {
            return intervals.size();
        }

        public Iterator<Map.Entry<Integer, Integer>> iterator() {
            return intervals.entrySet().iterator();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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

    public static String solve(int[][] arr) {
        IntervalSet c = new IntervalSet();
        IntervalSet j = new IntervalSet();

        StringBuilder sb = new StringBuilder();
        for (int[] interval : arr) {
            if ((j.query(interval[0]) || j.query(interval[1] - 1)) && (c.query(interval[0]) || c.query(interval[1] - 1))) {
                return "IMPOSSIBLE";
            } else if (!c.query(interval[0]) && !c.query(interval[1] - 1)) {
                c.insert(interval[0], interval[1] - 1);
                sb.append("C");
            } else {
                j.insert(interval[0], interval[1] - 1);
                sb.append("J");
            }
        }
        return sb.toString();
    }
}