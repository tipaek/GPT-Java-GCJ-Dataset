import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }
            String result = determineSchedule(intervals);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String determineSchedule(List<int[]> intervals) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>();
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        
        for (int[] interval : intervals) {
            startTimes.offer(interval[0]);
            endTimes.offer(interval[1]);
        }

        int currentOverlaps = 0;
        while (!startTimes.isEmpty()) {
            if (startTimes.peek() < endTimes.peek()) {
                currentOverlaps++;
                startTimes.poll();
            } else {
                currentOverlaps--;
                endTimes.poll();
            }
            if (currentOverlaps > 2) {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder schedule = new StringBuilder();
        int currentEnd = -1;
        char currentChar = 'C';

        for (int[] interval : intervals) {
            if (currentEnd == -1) {
                currentEnd = interval[1];
                schedule.append(currentChar);
            } else if (interval[0] < currentEnd) {
                currentChar = currentChar == 'C' ? 'J' : 'C';
                schedule.append(currentChar);
            } else {
                currentEnd = interval[1];
                schedule.append(currentChar);
            }
        }

        return schedule.toString();
    }
}