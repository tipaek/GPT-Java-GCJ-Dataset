import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            List<Range> ranges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                ranges.add(new Range(i, s, e));
            }
            ranges.sort(Comparator.comparing(r -> r.s));
            Range jrange = null;
            Range crange = null;
            boolean valid = true;
            char[] sol = new char[n];
            for (Range range : ranges) {
                if (crange == null || crange.e <= range.s) {
                    crange = range;
                    sol[range.idx] = 'C';
                } else if (jrange == null || jrange.e <= range.s) {
                    jrange = range;
                    sol[range.idx] = 'J';
                } else {
                    valid = false;
                    break;
                }
            }
            String y = valid ? new String(sol) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    public static class Range {
        // [s,e)
        int s;
        int e;
        int idx;

        public Range(int i, int s, int e) {
            this.idx = i;
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d)", s, e);
        }
    }
}