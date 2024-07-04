import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static boolean isCompatible(ArrayList<Integer> tasks, int[][] intervals, int start, int end) {
        for (int index : tasks) {
            int startInterval = intervals[index][0];
            int endInterval = intervals[index][1];
            if ((start > startInterval && start < endInterval) || (end > startInterval && end < endInterval)) {
                return false;
            }
        }
        return true;
    }

    static String findSchedule(int n, int[][] intervals) {
        ArrayList<Integer> J = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (isCompatible(C, intervals, start, end)) {
                C.add(i);
                result.append("C");
            } else if (isCompatible(J, intervals, start, end)) {
                J.add(i);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int taskCount = scanner.nextInt();
            int[][] intervals = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String schedule = findSchedule(taskCount, intervals);
            System.out.println("Case #" + i + ": " + schedule);
        }

        scanner.close();
    }
}