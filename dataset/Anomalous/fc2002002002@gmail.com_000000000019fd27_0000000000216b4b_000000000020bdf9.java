import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
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

        intervals.sort(Comparator.comparingInt(a -> a[0]));
        char[] assignedTasks = new char[intervals.size()];
        Arrays.fill(assignedTasks, 'J');

        List<Integer> cameronTasks = new ArrayList<>();
        int cameronEndTime = -1;
        for (int[] interval : intervals) {
            if (cameronEndTime == -1 || interval[0] >= cameronEndTime) {
                cameronEndTime = interval[1];
                cameronTasks.add(interval[2]);
            }
        }

        for (int index : cameronTasks) {
            assignedTasks[index] = 'C';
        }

        return new String(assignedTasks);
    }
}