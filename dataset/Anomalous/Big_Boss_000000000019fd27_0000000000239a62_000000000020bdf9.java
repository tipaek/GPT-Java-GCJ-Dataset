import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int rows = scanner.nextInt();
            int[][] intervals = new int[rows][2];
            
            for (int j = 0; j < rows; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            System.out.println("Case #" + i + ": " + scheduleIntervals(intervals));
        }
    }

    public static StringBuilder scheduleIntervals(int[][] intervals) {
        int[][] sortedIntervals = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(sortedIntervals, Comparator.comparingInt(interval -> interval[0]));

        PriorityQueue<Integer> cameronQueue = new PriorityQueue<>();
        PriorityQueue<Integer> jamieQueue = new PriorityQueue<>();
        HashMap<Integer, Character> assignmentMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int[] interval : sortedIntervals) {
            if (cameronQueue.isEmpty()) {
                cameronQueue.offer(interval[1]);
                assignmentMap.put(interval[0], 'C');
            } else if (jamieQueue.isEmpty()) {
                jamieQueue.offer(interval[1]);
                assignmentMap.put(interval[0], 'J');
            } else {
                if (interval[0] >= cameronQueue.peek()) {
                    cameronQueue.poll();
                    cameronQueue.offer(interval[1]);
                    assignmentMap.put(interval[0], 'C');
                } else if (interval[0] >= jamieQueue.peek()) {
                    jamieQueue.poll();
                    jamieQueue.offer(interval[1]);
                    assignmentMap.put(interval[0], 'J');
                } else {
                    return new StringBuilder("IMPOSSIBLE");
                }
            }
        }

        for (int[] interval : intervals) {
            result.append(assignmentMap.get(interval[0]));
        }

        return result;
    }
}