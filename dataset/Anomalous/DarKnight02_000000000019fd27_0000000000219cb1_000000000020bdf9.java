import java.util.*;
import java.io.*;

public class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static class Pair {
        public int start;
        public int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int maxOverlap(int[] start, int[] end, int n) {
        int maxStart = Arrays.stream(start).max().orElse(0);
        int maxEnd = Arrays.stream(end).max().orElse(0);
        int maxRange = Math.max(maxStart, maxEnd);
        int[] timeline = new int[maxRange + 2];

        for (int i = 0; i < n; i++) {
            timeline[start[i]]++;
            timeline[end[i] + 1]--;
        }

        int currentOverlap = 0;
        int maxOverlap = 0;
        for (int i = 0; i <= maxRange; i++) {
            currentOverlap += timeline[i];
            if (currentOverlap > maxOverlap) {
                maxOverlap = currentOverlap;
            }
        }
        return maxOverlap;
    }

    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(next());
        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(next());
            Pair[] intervals = new Pair[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int i = 0; i < n; i++) {
                int start = Integer.parseInt(next());
                int end = Integer.parseInt(next()) - 1;
                startTimes[i] = start;
                endTimes[i] = end;
                intervals[i] = new Pair(start, end);
            }

            Pair[] originalIntervals = Arrays.copyOf(intervals, n);
            Arrays.sort(intervals, Comparator.comparingInt(p -> p.start));

            if (maxOverlap(startTimes, endTimes, n) > 2) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                ArrayList<Pair> cSchedule = new ArrayList<>();
                ArrayList<Pair> jSchedule = new ArrayList<>();
                cSchedule.add(new Pair(-1, -1));
                jSchedule.add(new Pair(-1, -1));

                for (Pair interval : intervals) {
                    if (interval.start > cSchedule.get(cSchedule.size() - 1).end) {
                        cSchedule.add(interval);
                    } else if (interval.start > jSchedule.get(jSchedule.size() - 1).end) {
                        jSchedule.add(interval);
                    }
                }

                for (Pair interval : originalIntervals) {
                    if (cSchedule.contains(interval)) {
                        schedule.append("C");
                    } else if (jSchedule.contains(interval)) {
                        schedule.append("J");
                    }
                }

                System.out.println("Case #" + t + ": " + schedule.toString());
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}