import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<TimeSlot> cActivities = new ArrayList<>();
            List<TimeSlot> jActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (canSchedule(start, end, cActivities)) {
                    cActivities.add(new TimeSlot(start, end));
                    schedule.append("C");
                } else if (canSchedule(start, end, jActivities)) {
                    jActivities.add(new TimeSlot(start, end));
                    schedule.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule);
            }
        }
    }

    private static boolean canSchedule(int start, int end, List<TimeSlot> activities) {
        for (TimeSlot slot : activities) {
            if (slot.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }

    private static class TimeSlot {
        int start;
        int end;

        TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(int newStart, int newEnd) {
            return (newStart < end && newEnd > start);
        }
    }
}