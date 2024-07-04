import java.util.*;

public class Solution {
    private Scanner sc = new Scanner(System.in);

    class Range implements Comparable<Range> {
        public int start;
        public int end;
        public int idx;

        public Range(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(Range o) {
            if (start == o.start) {
                return end - o.end;
            } else {
                return start - o.start;
            }
        }
    }

    private void solve() {
        int n = sc.nextInt();
        List<Range> ranges = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int st = sc.nextInt();
            int ed = sc.nextInt();

            ranges.add(new Range(st, ed, i));
        }

        Collections.sort(ranges);

        int cEnd = -1;
        int jEnd = -1;

        boolean ok = true;

        char[] result = new char[n];
        for (int i = 0; i < n; ++i) {
            Range r = ranges.get(i);
            if (cEnd <= r.start) {
                cEnd = r.end;
                result[r.idx] = 'C';
            } else if (jEnd <= r.start) {
                jEnd = r.end;
                result[r.idx] = 'J';
            } else {
                ok = false;
                break;
            }
        }

        if (ok) {
            System.out.println(String.valueOf(result));
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
