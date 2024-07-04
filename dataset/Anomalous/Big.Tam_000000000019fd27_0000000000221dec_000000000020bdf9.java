import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int intervalCount = scanner.nextInt();
            int[][] intervals = new int[intervalCount][2];
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < intervalCount; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                priorityQueue.offer(new int[]{intervals[i][0], intervals[i][1], i});
            }

            int cEnd = -1, jEnd = -1;
            char[] result = new char[intervalCount];
            boolean isImpossible = false;

            while (!priorityQueue.isEmpty()) {
                int[] currentInterval = priorityQueue.poll();
                if (currentInterval[0] >= cEnd) {
                    result[currentInterval[2]] = 'C';
                    cEnd = currentInterval[1];
                } else if (currentInterval[0] >= jEnd) {
                    result[currentInterval[2]] = 'J';
                    jEnd = currentInterval[1];
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
        }
    }
}