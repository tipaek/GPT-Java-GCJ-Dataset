import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            Set<Interval> cameron = new HashSet<>();
            Set<Interval> jamie = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < n; i++) {
                String[] intervalStr = sc.nextLine().split(" ");
                int start = Integer.parseInt(intervalStr[0]);
                int end = Integer.parseInt(intervalStr[1]);
                Interval interval = new Interval(start, end);
                int cSize = cameron.size();
                int jSize = jamie.size();
                jamie.add(interval);
                if (jamie.size() == jSize) {
                    cameron.add(interval);
                    if (cSize == cameron.size()) {
                        sb.setLength(0);
                        sb.append("IMPOSSIBLE");
                    } else {
                        if (!"IMPOSSIBLE".equals(sb.toString())) {
                            sb.append("C");
                        }
                    }
                } else {
                    if (!"IMPOSSIBLE".equals(sb.toString())) {
                        sb.append("J");
                    }
                }
            }

            System.out.println("Case #" + k + ": " + sb);
        }
    }

    public static boolean overlaps(Interval i1, Interval i2) {
        return (i1.end > i2.start) && (i1.start < i2.end);
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return overlaps(this, interval);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
