import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            if (isPossible(intervals)) {
                System.out.println("Case #" + testCase + ": " + assignTasks(intervals));
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int[][] intervals) {
        int[] timeSlots = new int[1441];

        for (int[] interval : intervals) {
            for (int time = interval[0] + 1; time <= interval[1]; time++) {
                timeSlots[time]++;
                if (timeSlots[time] > 2) {
                    return false;
                }
            }
        }

        return true;
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> taskMap = new HashMap<>();

        for (int[] interval : intervals) {
            boolean isOverlap = false;

            for (Map.Entry<Integer, Integer> entry : taskMap.entrySet()) {
                if (Math.max(entry.getKey(), interval[0]) < Math.min(entry.getValue(), interval[1])) {
                    result.append("J");
                    isOverlap = true;
                    break;
                }
            }

            if (!isOverlap) {
                taskMap.put(interval[0], interval[1]);
                result.append("C");
            }
        }

        return result.toString();
    }
}