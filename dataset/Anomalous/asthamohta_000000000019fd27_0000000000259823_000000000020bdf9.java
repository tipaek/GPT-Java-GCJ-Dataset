import java.util.*;

class Solution {

    public static class Node {
        int start, end, index;

        Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static HashMap<String, String> memo = new HashMap<>();

    public static String findSchedule(int ct, int jt, int idx, Node[] intervals) {
        String key = idx + " " + ct + " " + jt;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (idx >= intervals.length) {
            return "";
        }
        if (ct > intervals[idx].start && jt > intervals[idx].start) {
            memo.put(key, "IMPOSSIBLE");
            return "IMPOSSIBLE";
        }

        String scheduleC = "IMPOSSIBLE";
        String scheduleJ = "IMPOSSIBLE";

        if (ct <= intervals[idx].start) {
            scheduleC = findSchedule(intervals[idx].end, jt, idx + 1, intervals);
        }
        if (jt <= intervals[idx].start) {
            scheduleJ = findSchedule(ct, intervals[idx].end, idx + 1, intervals);
        }

        if (!scheduleC.equals("IMPOSSIBLE")) {
            memo.put(key, "C" + scheduleC);
            return "C" + scheduleC;
        }
        if (!scheduleJ.equals("IMPOSSIBLE")) {
            memo.put(key, "J" + scheduleJ);
            return "J" + scheduleJ;
        }

        memo.put(key, "IMPOSSIBLE");
        return "IMPOSSIBLE";
    }

    public static class TimeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            Node[] intervals = new Node[n];
            Node[] original = new Node[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i] = new Node(start, end, i);
                original[i] = new Node(start, end, i);
            }

            Arrays.sort(intervals, new TimeComparator());

            memo.clear();
            String solution = findSchedule(-1, -1, 0, intervals);

            if (solution.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (t + 1) + ": " + solution);
                continue;
            }

            char[] result = new char[solution.length()];
            for (int i = 0; i < intervals.length; i++) {
                result[intervals[i].index] = solution.charAt(i);
            }

            System.out.println("Case #" + (t + 1) + ": " + new String(result));
        }
    }
}