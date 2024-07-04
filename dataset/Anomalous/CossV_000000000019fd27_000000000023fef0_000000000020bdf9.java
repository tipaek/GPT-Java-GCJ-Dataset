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
            String result = "";
            int activities = Integer.parseInt(scanner.nextLine());

            for (int activity = 0; activity < activities; activity++) {
                // Add logic to process each activity
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    public static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (end1 > start2) && (start1 < end2);
    }

    public static boolean doesListContainOverlap(int[] interval, List<int[]> schedule) {
        for (int[] scheduledInterval : schedule) {
            if (scheduledInterval != null && scheduledInterval.length == 2) {
                if (isOverlapping(interval[0], interval[1], scheduledInterval[0], scheduledInterval[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}