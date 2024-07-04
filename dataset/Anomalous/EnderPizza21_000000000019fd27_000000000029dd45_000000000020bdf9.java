import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numIntervals = Integer.parseInt(br.readLine());
            ArrayList<int[]> intervals = new ArrayList<>();
            
            for (int i = 0; i < numIntervals; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals.add(new int[] { start, end, i });
            }
            
            String result = scheduleIntervals(intervals);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static String scheduleIntervals(ArrayList<int[]> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        String[] assignments = new String[intervals.size()];
        int[] cCurrent = { 0, 0, -1 };
        int[] jCurrent = { 0, 0, -1 };

        for (int[] interval : intervals) {
            if (cCurrent[1] <= interval[0]) {
                cCurrent = interval;
                assignments[interval[2]] = "C";
            } else if (jCurrent[1] <= interval[0]) {
                jCurrent = interval;
                assignments[interval[2]] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (String assignment : assignments) {
            result.append(assignment);
        }

        return result.toString();
    }

    public static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] interval1, int[] interval2) {
            return Integer.compare(interval1[0], interval2[0]);
        }
    }
}