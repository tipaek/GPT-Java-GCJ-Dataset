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

    public static int maxOverlap(int[] startTimes, int[] endTimes, int n) {
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
            
            Arrays.sort(intervals, Comparator.comparingInt(pair -> pair.start));
            
            if (maxOverlap(startTimes, endTimes, n) > 2) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                List<Pair> cameron = new ArrayList<>();
                List<Pair> jamie = new ArrayList<>();
                cameron.add(new Pair(-1, -1));
                jamie.add(new Pair(-1, -1));
                
                for (Pair interval : intervals) {
                    if (interval.start > cameron.get(cameron.size() - 1).end) {
                        cameron.add(interval);
                    } else if (interval.start > jamie.get(jamie.size() - 1).end) {
                        jamie.add(interval);
                    }
                }
                
                for (Pair interval : intervals) {
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

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}