import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int intervalCount = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int j = 0; j < intervalCount; j++) {
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }

            String result = scheduleIntervals(intervals);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String scheduleIntervals(List<int[]> intervals) {
        PriorityQueue<Integer> startTimes = new PriorityQueue<>();
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (int[] interval : intervals) {
            startTimes.offer(interval[0]);
            endTimes.offer(interval[1]);
        }

        int concurrentIntervals = 0;
        while (!startTimes.isEmpty()) {
            if (startTimes.peek() < endTimes.peek()) {
                concurrentIntervals++;
                startTimes.poll();
            } else {
                concurrentIntervals--;
                endTimes.poll();
            }

            if (concurrentIntervals > 2) {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        int lastEnd = -1;
        char currentChar = 'C';

        for (int[] interval : intervals) {
            if (lastEnd == -1) {
                lastEnd = interval[1];
                result.append(currentChar);
            } else if (interval[0] < lastEnd) {
                currentChar = (currentChar == 'C') ? 'J' : 'C';
                result.append(currentChar);
            } else {
                lastEnd = interval[1];
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}