import java.util.*;

public class Solution {

    static class Interval {
        int start;
        int end;
        int idx;

        public Interval(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Interval interval = new Interval(in.nextInt(), in.nextInt(), i);
                intervals.add(interval);
            }

            String result = createAssignments(intervals);

            if (result.isEmpty()) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", (t+1)));
            } else {
                System.out.println(String.format("Case #%d: %s", (t+1), result));
            }
        }
    }

    private static String createAssignments(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        Map<Integer, String> solution = new HashMap<>();
        Interval cameron = intervals.get(0);
        solution.put(cameron.idx, "C");
        Interval jamie = null;

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            boolean assigned = false;
            if (cameron.end <= curr.start) { // cameron can take it.
                solution.put(curr.idx, "C");
                cameron = curr;
                assigned = true;
            } else if (jamie == null) {
                solution.put(curr.idx, "J");
                jamie = curr;
                assigned = true;
            } else if (jamie.end <= curr.start) {
                solution.put(curr.idx, "J");
                jamie = curr;
                assigned = true;
            }

            if (!assigned) {
                return "";
            }
        }

        String result = "";
        for (int i = 0; i < intervals.size(); i++) {
            result += solution.get(i);
        }

        return result;
    }
}