import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt(), j});
            }
            
            String result = assignTasks(intervals);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
    
    private static String assignTasks(List<int[]> intervals) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>();
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        
        for (int[] interval : intervals) {
            startTimes.offer(interval[0]);
            endTimes.offer(interval[1]);
        }
        
        int concurrentTasks = 0;
        while (!startTimes.isEmpty()) {
            if (startTimes.peek() < endTimes.peek()) {
                concurrentTasks++;
                startTimes.poll();
            } else {
                concurrentTasks--;
                endTimes.poll();
            }
            if (concurrentTasks > 2) return "IMPOSSIBLE";
        }
        
        intervals.sort(Comparator.comparingInt(a -> a[2]));
        char[] result = new char[intervals.size()];
        int currentEnd = -1;
        char currentTask = 'C';
        
        for (int[] interval : intervals) {
            if (currentEnd == -1) {
                currentEnd = interval[1];
                result[interval[2]] = currentTask;
            } else if (interval[0] < currentEnd) {
                currentTask = currentTask == 'C' ? 'J' : 'C';
                result[interval[2]] = currentTask;
            } else {
                currentEnd = interval[1];
                result[interval[2]] = currentTask;
            }
        }
        
        return new String(result);
    }
}