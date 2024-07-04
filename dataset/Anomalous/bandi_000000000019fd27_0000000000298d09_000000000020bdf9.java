import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];
            
            for (int j = 0; j < numIntervals; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            String result = "Case #" + i + ": " + assignIntervals(intervals);
            System.out.println(result);
        }
    }

    private static String assignIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return "IMPOSSIBLE";
        }
        
        if (intervals.length == 1) {
            return "C";
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        
        StringBuilder sequence = new StringBuilder();
        int cameronEndTime = 0;
        int jamieEndTime = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int overlapCount = 0;

        for (int[] interval : intervals) {
            if (minHeap.isEmpty()) {
                sequence.append("C");
                cameronEndTime = interval[1];
                overlapCount++;
                minHeap.offer(interval[1]);
            } else {
                if (interval[0] >= minHeap.peek()) {
                    if (cameronEndTime <= interval[0]) {
                        sequence.append("C");
                        cameronEndTime = interval[1];
                    } else if (jamieEndTime <= interval[0]) {
                        sequence.append("J");
                        jamieEndTime = interval[1];
                    }
                    minHeap.poll();
                } else {
                    if (jamieEndTime == 0) {
                        sequence.append("J");
                        jamieEndTime = interval[1];
                    } else if (cameronEndTime == 0) {
                        sequence.append("C");
                        cameronEndTime = interval[1];
                    }
                    overlapCount++;
                    if (overlapCount > 2) {
                        return "IMPOSSIBLE";
                    }
                }
                minHeap.offer(interval[1]);
            }
        }
        
        return sequence.toString();
    }
}