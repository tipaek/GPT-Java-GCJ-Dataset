import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // Read the number of test cases
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            List<TimeSlot> cameronSchedule = new ArrayList<>(activitiesCount);
            List<TimeSlot> jamieSchedule = new ArrayList<>(activitiesCount);
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (canSchedule(start, end, cameronSchedule)) {
                    cameronSchedule.add(new TimeSlot(start, end));
                    schedule.append("C");
                } else if (canSchedule(start, end, jamieSchedule)) {
                    jamieSchedule.add(new TimeSlot(start, end));
                    schedule.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            }
        }
    }

    private static boolean canSchedule(int start, int end, List<TimeSlot> schedule) {
        for (TimeSlot slot : schedule) {
            if (start < slot.end && end > slot.begin) {
                return false;
            }
        }
        return true;
    }

    private static class TimeSlot {
        int begin;
        int end;

        TimeSlot(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}