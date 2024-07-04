import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int rows = in.nextInt();
            int[][] time = new int[rows][2];
            for (int l = 0; l < rows; l++) {
                for (int m = 0; m < 2; m++) {
                    time[l][m] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + assignTasks(time));
        }
        in.close();
    }

    public static String assignTasks(int[][] intervals) {
        int[][] time = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(time, Comparator.comparingInt(itv -> itv[0]));

        PriorityQueue<Integer> cameronEndTimes = new PriorityQueue<>();
        PriorityQueue<Integer> jamieEndTimes = new PriorityQueue<>();
        Map<Integer, Character> assignments = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int[] interval : time) {
            if (cameronEndTimes.isEmpty() || interval[0] >= cameronEndTimes.peek()) {
                if (!cameronEndTimes.isEmpty()) {
                    cameronEndTimes.poll();
                }
                cameronEndTimes.offer(interval[1]);
                assignments.put(interval[0], 'C');
            } else if (jamieEndTimes.isEmpty() || interval[0] >= jamieEndTimes.peek()) {
                if (!jamieEndTimes.isEmpty()) {
                    jamieEndTimes.poll();
                }
                jamieEndTimes.offer(interval[1]);
                assignments.put(interval[0], 'J');
            } else {
                return new StringBuilder("IMPOSSIBLE").toString();
            }
        }

        for (int[] interval : intervals) {
            result.append(assignments.get(interval[0]));
        }

        return result.toString();
    }
}