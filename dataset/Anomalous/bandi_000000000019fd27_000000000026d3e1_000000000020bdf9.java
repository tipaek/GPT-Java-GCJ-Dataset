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
            int numberOfIntervals = scanner.nextInt();
            int[][] intervals = new int[numberOfIntervals][2];
            
            for (int j = 0; j < numberOfIntervals; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            String result = "Case #" + i + ": " + assignTasks(intervals);
            System.out.println(result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder sequence = new StringBuilder();
        int cEndTime = 0;
        int jEndTime = 0;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        PriorityQueue<Integer> endTimeHeap = new PriorityQueue<>();
        int concurrentTasks = 0;
        
        for (int[] interval : intervals) {
            if (endTimeHeap.isEmpty()) {
                sequence.append("C");
                cEndTime = interval[1];
                concurrentTasks++;
                endTimeHeap.offer(interval[1]);
            } else {
                if (interval[0] >= endTimeHeap.peek()) {
                    if (cEndTime <= interval[0]) {
                        sequence.append("C");
                        cEndTime = interval[1];
                    } else if (jEndTime <= interval[0]) {
                        sequence.append("J");
                        jEndTime = interval[1];
                    }
                    endTimeHeap.poll();
                } else {
                    if (jEndTime == 0) {
                        sequence.append("J");
                        jEndTime = interval[1];
                    }
                    concurrentTasks++;
                }
                if (concurrentTasks > 2) {
                    return "IMPOSSIBLE";
                }
                endTimeHeap.offer(interval[1]);
            }
        }
        return sequence.toString();
    }
}