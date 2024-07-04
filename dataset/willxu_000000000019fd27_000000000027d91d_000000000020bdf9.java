
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static class Interval {
        int idx;
        int start;
        int end;
        int assignId;
    }

    public String solve(Interval[] intervals) {
        List<List<Interval>> queues = assignIntervals(intervals);
        if (queues == null) {
            return IMPOSSIBLE;
        }
        return buildAssignment(intervals);
    }

    private String buildAssignment(Interval[] intervals) {
        Arrays.sort(intervals, (Interval a, Interval b) -> {
            return a.idx - b.idx;
        });
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            char assignee = (interval.assignId == 0 ? 'C' : 'J');
            sb.append(assignee);
        }
        return sb.toString();
    }

    private List<List<Interval>> assignIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (Interval a, Interval b) -> {
            return a.end - b.end;
        });
        List<List<Interval>> queues = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Interval curr = intervals[i];
            boolean found = false;
            for (int k = 0; k < queues.size(); k++) {
                List<Interval> lastQueue = queues.get(k);
                Interval last = lastQueue.get(lastQueue.size() - 1);
                if (curr.start >= last.end) {
                    found = true;
                    curr.assignId = k;
                    lastQueue.add(curr);
                    break;
                }
            }
            if (!found) {
                if (queues.size() >= 2) {
                    return null;
                }
                List<Interval> queue = new ArrayList<>();
                curr.assignId = queues.size();
                queue.add(curr);
                queues.add(queue);
            }
        }
        return queues;
    }

    public static void main(String[] args) {
        processInputStream(System.in);
    }

    public static void processInputStream(InputStream in) {
        Scanner scanner = new Scanner(in);
        try {
            int T = scanner.nextInt();
            for (int t = 1; t <= T; t++) {
                Interval[] intervals = readTestCase(scanner);
                Solution s = new Solution();
                String result = s.solve(intervals);
                System.out.printf("Case #%d: %s\n", t, result);
            }
        } finally {
            scanner.close();
        }
    }

    private static Interval[] readTestCase(Scanner scanner) {
        int n = scanner.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval();
            intervals[i].idx = i;
            intervals[i].start = scanner.nextInt();
            intervals[i].end = scanner.nextInt();
        }
        return intervals;
    }
}
