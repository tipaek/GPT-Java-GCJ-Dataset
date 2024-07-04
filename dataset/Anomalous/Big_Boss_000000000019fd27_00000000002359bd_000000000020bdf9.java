import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];

            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

            PriorityQueue<Integer> cameronQueue = new PriorityQueue<>();
            PriorityQueue<Integer> jamieQueue = new PriorityQueue<>();
            StringBuilder result = new StringBuilder();

            for (int[] interval : intervals) {
                if (cameronQueue.isEmpty()) {
                    cameronQueue.offer(interval[1]);
                    result.append('C');
                } else if (jamieQueue.isEmpty()) {
                    jamieQueue.offer(interval[1]);
                    result.append('J');
                } else {
                    if (interval[0] >= cameronQueue.peek()) {
                        cameronQueue.poll();
                        cameronQueue.offer(interval[1]);
                        result.append('C');
                    } else if (interval[0] >= jamieQueue.peek()) {
                        jamieQueue.poll();
                        jamieQueue.offer(interval[1]);
                        result.append('J');
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}