import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

public class Solution {
    private static final int WORKERS = 2;
    BufferedReader rd;

    Solution() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() throws IOException {
        int n = pint();
        for (int i = 1; i <= n; i++) {
            out("Case #" + i + ": " + solve());
        }
    }

    private String solve() throws IOException {
        int n = pint();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = intarr();
        }
        return solve(a);
    }

    private String solve(int[][] activityTimes) {
        int n = activityTimes.length;
        PriorityQueue<Activity> activities = new PriorityQueue<>(
                comparingInt(Activity::getStartTime)
                        .thenComparingInt(Activity::getEndTime)
                        .thenComparingInt(Activity::getIndex));
        for (int i = 0; i < n; i++) {
            int[] a = activityTimes[i];
            activities.add(new Activity(a[0], a[1], i));
        }

        int[] assignments = new int[n];
        boolean pos = true;
        int[] availableStartingAt = new int[WORKERS];
        while (!activities.isEmpty()) {
            Activity activity = activities.poll();
            int i = 0;
            while (i < WORKERS) {
                if (availableStartingAt[i] <= activity.startTime) {
                    assignments[activity.index] = i;
                    availableStartingAt[i] = activity.endTime;
                    break;
                }
                i++;
            }
            if (i == WORKERS) {
                pos = false;
                break;
            }
        }
        return pos ? encode(assignments) : "IMPOSSIBLE";
    }

    private String encode(int[] assignments) {
        int n = assignments.length;
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = assignments[i] == 0 ? 'C' : 'J';
        }
        return new String(res);
    }

    private static class Activity {
        final int startTime;
        final int endTime;
        final int index;

        public Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getIndex() {
            return index;
        }
    }

    private int pint() throws IOException {
        return pint(rd.readLine());
    }

    private int pint(String s) {
        return Integer.parseInt(s);
    }

    private int[] intarr() throws IOException {
        return intarr(rd.readLine());
    }

    private int[] intarr(String s) {
        String[] q = split(s);
        int n = q.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(q[i]);
        }
        return a;
    }

    public String[] split(String s) {
        if (s == null) {
            return new String[0];
        }
        int n = s.length();
        int start = -1;
        int end = 0;
        int sp = 0;
        boolean lastWhitespace = true;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isWhitespace(c)) {
                lastWhitespace = true;
            } else {
                if (lastWhitespace) {
                    sp++;
                }
                if (start == -1) {
                    start = i;
                }
                end = i;
                lastWhitespace = false;
            }
        }
        if (start == -1) {
            return new String[0];
        }
        String[] res = new String[sp];
        int last = start;
        int x = 0;
        lastWhitespace = true;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            boolean w = isWhitespace(c);
            if (w && !lastWhitespace) {
                res[x++] = s.substring(last, i);
            } else if (!w && lastWhitespace) {
                last = i;
            }
            lastWhitespace = w;
        }
        res[x] = s.substring(last, end + 1);
        return res;
    }

    private boolean isWhitespace(char c) {
        return c == ' ' || c == '\t';
    }

    private static void out(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
