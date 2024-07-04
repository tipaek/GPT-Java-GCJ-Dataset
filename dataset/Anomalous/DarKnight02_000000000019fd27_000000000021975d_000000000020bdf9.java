import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static class Interval {

        public int start;
        public int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int findMaxOverlap(int[] startTimes, int[] endTimes, int n) {
        int maxStart = Arrays.stream(startTimes).max().getAsInt();
        int maxEnd = Arrays.stream(endTimes).max().getAsInt();
        int maxTime = Math.max(maxStart, maxEnd);
        int[] timeline = new int[maxTime + 2];
        Arrays.fill(timeline, 0);

        for (int i = 0; i < n; i++) {
            timeline[startTimes[i]]++;
            timeline[endTimes[i] + 1]--;
        }

        int currentOverlap = 0, maxOverlap = 0;
        for (int i = 0; i <= maxTime; i++) {
            currentOverlap += timeline[i];
            if (currentOverlap > maxOverlap) {
                maxOverlap = currentOverlap;
            }
        }
        return maxOverlap;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(nextToken());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(nextToken());
            Interval[] intervals = new Interval[N];
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                int start = Integer.parseInt(nextToken());
                int end = Integer.parseInt(nextToken()) - 1;
                startTimes[i] = start;
                endTimes[i] = end;
                intervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

            if (findMaxOverlap(startTimes, endTimes, N) > 2) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                List<Interval> cameron = new ArrayList<>();
                List<Interval> jamie = new ArrayList<>();
                cameron.add(new Interval(-1, -1));
                jamie.add(new Interval(-1, -1));

                for (Interval interval : intervals) {
                    if (interval.start > cameron.get(cameron.size() - 1).end) {
                        cameron.add(interval);
                    } else if (interval.start > jamie.get(jamie.size() - 1).end) {
                        jamie.add(interval);
                    }
                }

                for (Interval interval : intervals) {
                    if (cameron.contains(interval)) {
                        schedule.append("C");
                    } else if (jamie.contains(interval)) {
                        schedule.append("J");
                    }
                }

                System.out.println("Case #" + t + ": " + schedule.toString());
            }
        }
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}