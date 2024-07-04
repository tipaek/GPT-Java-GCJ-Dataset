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
                ranges.add(new Range(s, e));
            }
            ranges.sort(Comparator.comparing(r -> r.s));
            Range jrange = null;
            Range crange = null;
            boolean valid = true;
            StringBuilder sb = new StringBuilder();
            for (Range range : ranges) {
                if (jrange == null || jrange.e <= range.s) {
                    jrange = range;
                    sb.append("J");
                } else if (crange == null || crange.e <= range.s) {
                    crange = range;
                    sb.append("C");
                } else {
                    valid = false;
                    break;
                }
            }
            String y = valid ? sb.toString() : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    public static class Range {
        // [s,e)
        int s;
        int e;

        public Range(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}