import java.util.*;
import java.io.*;

public class Solution {

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return Math.max(interval1[0], interval2[0]) < Math.min(interval1[1], interval2[1]);
    }

    private static String getOrder(int[][] intervals) {
        char[] result = new char[intervals.length];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> cIntervals = new ArrayList<>();
        List<int[]> jIntervals = new ArrayList<>();
        
        for (int[] interval : intervals) {
            if (cIntervals.isEmpty() || !isOverlapping(cIntervals.get(cIntervals.size() - 1), interval)) {
                cIntervals.add(Arrays.copyOf(interval, 3));
                result[interval[2]] = 'C';
            } else if (jIntervals.isEmpty() || !isOverlapping(jIntervals.get(jIntervals.size() - 1), interval)) {
                jIntervals.add(Arrays.copyOf(interval, 3));
                result[interval[2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                intervals[j][2] = j;
            }
            
            String result = getOrder(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}