import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static String schedule(int[][] intervals) {
        StringBuilder result = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Map<int[], Character> assignmentMap = new HashMap<>();

        int nextJamesFree = -1;
        int nextCameronFree = -1;

        for (int[] interval : intervals) {
            pq.offer(interval);
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[0] < nextCameronFree) {
                if (current[0] < nextJamesFree) {
                    return "IMPOSSIBLE";
                } else {
                    assignmentMap.put(current, 'J');
                    nextJamesFree = current[1];
                }
            } else {
                assignmentMap.put(current, 'C');
                nextCameronFree = current[1];
            }
        }

        for (int[] interval : intervals) {
            result.append(assignmentMap.get(interval));
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();

            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            String result = schedule(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}