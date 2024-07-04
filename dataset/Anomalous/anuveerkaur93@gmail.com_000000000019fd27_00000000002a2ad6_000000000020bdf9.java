import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int k = 1; k <= testCases; k++) {
            int activities = scanner.nextInt();
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder scheduleBuilder = new StringBuilder();
            boolean isPossible = true;
            char currentPerson = 'J';

            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int[] activity = {start, end};

                if (currentPerson == 'J') {
                    if (isOverlapping(start, end, jamieSchedule)) {
                        if (isOverlapping(start, end, cameronSchedule)) {
                            isPossible = false;
                            break;
                        } else {
                            cameronSchedule.add(activity);
                            scheduleBuilder.append('C');
                            currentPerson = 'C';
                        }
                    } else {
                        jamieSchedule.add(activity);
                        scheduleBuilder.append('J');
                    }
                } else {
                    if (isOverlapping(start, end, cameronSchedule)) {
                        if (isOverlapping(start, end, jamieSchedule)) {
                            isPossible = false;
                            break;
                        } else {
                            jamieSchedule.add(activity);
                            scheduleBuilder.append('J');
                            currentPerson = 'J';
                        }
                    } else {
                        cameronSchedule.add(activity);
                        scheduleBuilder.append('C');
                    }
                }
            }

            String result = isPossible ? scheduleBuilder.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + k + ": " + result);
        }
        
        scanner.close();
    }

    private static boolean isOverlapping(int start, int end, List<int[]> schedule) {
        for (int[] activity : schedule) {
            int aStart = activity[0];
            int aEnd = activity[1];
            if ((aStart == start && aEnd == end) || (aStart < end && aStart >= start) || (aEnd > start && aEnd <= end)
                    || (aStart > start && aEnd < end) || (aStart < start && aEnd > end)) {
                return true;
            }
        }
        return false;
    }
}