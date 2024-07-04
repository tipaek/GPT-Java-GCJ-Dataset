import java.util.*;

class Solution {
    static class IntervalSet {
        private TreeMap<Integer, Integer> intervals;

        public IntervalSet() {
            intervals = new TreeMap<>();
        }

        // Insert an interval [l, r]
        public void insert(int l, int r) {
            intervals.put(l, r);
        }

        // Remove an interval [l, r]
        // returns true if exists
        public boolean remove(int l, int r) {
            if (intervals.containsKey(l) && intervals.get(l) == r) {
                intervals.remove(l);
                return true;
            }
            return false;
        }

        // Query a point x.
        // returns true if exists an interval [l, r] such that l <= x <= r
        // returns false otherwise
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
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
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
        Integer[] indices = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(i -> arr[i][0]));
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        IntervalSet c = new IntervalSet();
        IntervalSet j = new IntervalSet();

        char[] ans = new char[arr.length];
        for (int cnt = 0; cnt < arr.length; cnt++) {
            int[] interval = arr[cnt];
            int index = indices[cnt];
            if (j.query(interval[0], interval[1]) && c.query(interval[0], interval[1])) {
                return "IMPOSSIBLE";
            } else if (!c.query(interval[0], interval[1])) {
                c.insert(interval[0], interval[1]);
                ans[index] = 'C';
            } else {
                j.insert(interval[0], interval[1]);
                ans[index] = 'J';
            }
        }
        return new String(ans);
    }
}