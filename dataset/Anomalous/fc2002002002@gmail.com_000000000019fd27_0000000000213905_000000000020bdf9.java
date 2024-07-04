import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }
            
            String result = assignTasks(intervals);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String assignTasks(List<int[]> intervals) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>();
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        
        for (int[] interval : intervals) {
            startTimes.offer(interval[0]);
            endTimes.offer(interval[1]);
        }
        
        int ongoingTasks = 0;
        
        while (!startTimes.isEmpty()) {
            if (startTimes.peek() < endTimes.peek()) {
                ongoingTasks++;
                startTimes.poll();
            } else {
                ongoingTasks--;
                endTimes.poll();
            }
            
            if (ongoingTasks > 2) {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder schedule = new StringBuilder();
        int currentEnd = -1;
        char currentWorker = 'C';
        
        for (int[] interval : intervals) {
            if (currentEnd == -1 || interval[0] >= currentEnd) {
                currentEnd = interval[1];
                schedule.append(currentWorker);
            } else {
                currentWorker = (currentWorker == 'C') ? 'J' : 'C';
                currentEnd = interval[1];
                schedule.append(currentWorker);
            }
        }
        
        return schedule.toString();
    }
}