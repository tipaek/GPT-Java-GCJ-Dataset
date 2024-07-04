import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            List<TimeSlot> cameronSchedule = new ArrayList<>();
            List<TimeSlot> jamieSchedule = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean canAssignToCameron = canAssign(startTime, endTime, cameronSchedule);

                if (canAssignToCameron) {
                    cameronSchedule.add(new TimeSlot(startTime, endTime));
                    schedule.append("C");
                } else {
                    boolean canAssignToJamie = canAssign(startTime, endTime, jamieSchedule);
                    if (canAssignToJamie) {
                        jamieSchedule.add(new TimeSlot(startTime, endTime));
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule);
            }
        }
        scanner.close();
    }

    private static boolean canAssign(int start, int end, List<TimeSlot> schedule) {
        for (TimeSlot slot : schedule) {
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

        boolean overlaps(int startTime, int endTime) {
            return !(endTime <= this.start || startTime >= this.end);
        }
    }
}