import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            int numActivities = Integer.parseInt(scanner.nextLine());

            boolean isPossible = true;

            for (int i = 0; i < numActivities; i++) {
                String[] intervalStr = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalStr[0]);
                int end = Integer.parseInt(intervalStr[1]);
                int[] interval = {start, end};

                if (isOverlapping(interval, cameronSchedule)) {
                    if (isOverlapping(interval, jamieSchedule)) {
                        result = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    } else {
                        jamieSchedule.add(interval);
                        result.append("J");
                    }
                } else {
                    cameronSchedule.add(interval);
                    result.append("C");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static boolean isOverlapping(int[] interval, List<int[]> schedule) {
        for (int[] scheduledInterval : schedule) {
            if (overlaps(interval[0], interval[1], scheduledInterval[0], scheduledInterval[1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (end1 > start2) && (start1 < end2);
    }
}