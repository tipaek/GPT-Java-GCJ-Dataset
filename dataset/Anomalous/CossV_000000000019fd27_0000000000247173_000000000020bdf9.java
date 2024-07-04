import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder output = new StringBuilder();
            int activities = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < activities; i++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);
                int[] interval = {start, end};

                if (isOverlapping(interval, cameronSchedule)) {
                    if (isOverlapping(interval, jamieSchedule)) {
                        output = new StringBuilder("IMPOSSIBLE");
                    } else {
                        jamieSchedule.add(interval);
                        if (!"IMPOSSIBLE".contentEquals(output)) {
                            output.append("J");
                        }
                    }
                } else {
                    cameronSchedule.add(interval);
                    if (!"IMPOSSIBLE".contentEquals(output)) {
                        output.append("C");
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + output);
        }
    }

    private static boolean isOverlapping(int[] interval, List<int[]> schedule) {
        for (int[] scheduledInterval : schedule) {
            if (scheduledInterval != null && scheduledInterval.length == 2) {
                if (overlaps(interval[0], interval[1], scheduledInterval[0], scheduledInterval[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && start2 < end1) || (start1 == end1 && start2 == end2 && end1 == start2);
    }
}