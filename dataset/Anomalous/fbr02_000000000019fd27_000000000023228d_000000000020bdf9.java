import java.util.*;

public class Solution {

    private Scanner sc;
    private TreeMap<Integer, List<Interval>> delta;

    private static class Interval {
        int start;
        int end;
        int val;

        public Interval(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    private void solve() {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            delta = new TreeMap<>();
            StringBuilder res = new StringBuilder();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                book(start, end);
            }
            int active = 0;
            int cEnd = -1;
            int jEnd = -1;
            for (Map.Entry<Integer, List<Interval>> entry : delta.entrySet()) {
                int time = entry.getKey();
                List<Interval> intervals = entry.getValue();
                int deltaChange = 0;
                for (Interval interval : intervals) {
                    deltaChange += interval.val;
                    if (interval.val == -1) {
                        if (cEnd == interval.end) cEnd = -1;
                        if (jEnd == interval.end) jEnd = -1;
                    }
                }
                active += deltaChange;
                if (active >= 3) {
                    res.setLength(0);
                    res.append("IMPOSSIBLE");
                    break;
                } else {
                    for (Interval interval : intervals) {
                        if (interval.val == 1) {
                            if (jEnd == -1) {
                                res.append('J');
                                jEnd = interval.end;
                            } else {
                                res.append('C');
                                cEnd = interval.end;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + t + ": " + res.toString());
        }
    }

    private void book(int start, int end) {
        delta.computeIfAbsent(start, k -> new ArrayList<>()).add(new Interval(start, end, 1));
        delta.computeIfAbsent(end, k -> new ArrayList<>()).add(new Interval(start, end, -1));
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}