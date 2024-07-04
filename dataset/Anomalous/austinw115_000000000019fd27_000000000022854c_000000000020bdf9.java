import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] intervals = new int[N][2];
            int[][] originalIntervals = new int[N][2];
            
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals[j][0] = start;
                intervals[j][1] = end;
                originalIntervals[j][0] = start;
                originalIntervals[j][1] = end;
            }

            int[][] sortedIntervals = sortIntervals(intervals);
            int[][] reSortedIntervals = reSortIntervals(sortedIntervals);
            String schedule = assignSchedule(reSortedIntervals, N);
            String result = reconstructOriginalOrder(schedule, originalIntervals, reSortedIntervals, N);
            
            if (isImpossible(reSortedIntervals, N)) {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                pw.println("Case #" + i + ": " + result);
            }
        }
        
        pw.close();
    }

    private static int[][] sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        return intervals;
    }

    private static int[][] reSortIntervals(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i - 1][0] && intervals[i][1] < intervals[i - 1][1]) {
                int temp = intervals[i][1];
                intervals[i][1] = intervals[i - 1][1];
                intervals[i - 1][1] = temp;
            }
        }
        return intervals;
    }

    private static String assignSchedule(int[][] intervals, int N) {
        StringBuilder schedule = new StringBuilder("C");
        String currentPerson = "C";
        
        for (int i = 1; i < N; i++) {
            if (isOverlap(intervals[i - 1], intervals[i])) {
                currentPerson = currentPerson.equals("C") ? "J" : "C";
            }
            schedule.append(currentPerson);
        }
        
        return schedule.toString();
    }

    private static String reconstructOriginalOrder(String schedule, int[][] originalIntervals, int[][] sortedIntervals, int N) {
        StringBuilder result = new StringBuilder();
        
        for (int[] originalInterval : originalIntervals) {
            for (int j = 0; j < N; j++) {
                if (Arrays.equals(originalInterval, sortedIntervals[j])) {
                    result.append(schedule.charAt(j));
                }
            }
        }
        
        return result.toString();
    }

    private static boolean isImpossible(int[][] intervals, int N) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isOverlap(intervals[i], intervals[j]) && hasTripleOverlap(intervals, i, j, N)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }

    private static boolean hasTripleOverlap(int[][] intervals, int i, int j, int N) {
        for (int k = 0; k < N; k++) {
            if (k != i && k != j && isOverlap(intervals[k], intervals[i]) && isOverlap(intervals[k], intervals[j])) {
                return true;
            }
        }
        return false;
    }
}