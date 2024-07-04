import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= numberOfTestCases; ++testCase) {
            ArrayList<int[]> cameronSchedule = new ArrayList<>();
            ArrayList<int[]> jamieSchedule = new ArrayList<>();
            int numberOfTasks = Integer.parseInt(scanner.nextLine());
            StringBuilder scheduleResult = new StringBuilder();

            for (int i = 0; i < numberOfTasks; i++) {
                int[] timeSlot = parseTimeSlot(scanner.nextLine());
                if (!hasOverlap(jamieSchedule, timeSlot)) {
                    jamieSchedule.add(timeSlot);
                    scheduleResult.append("J");
                } else if (!hasOverlap(cameronSchedule, timeSlot)) {
                    cameronSchedule.add(timeSlot);
                    scheduleResult.append("C");
                } else {
                    scheduleResult = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + testCase + ": " + scheduleResult);
        }
    }

    private static int[] parseTimeSlot(String timeSlot) {
        String[] times = timeSlot.split(" ");
        return new int[]{Integer.parseInt(times[0]), Integer.parseInt(times[1])};
    }

    private static boolean hasOverlap(ArrayList<int[]> schedule, int[] timeSlot) {
        for (int[] scheduledSlot : schedule) {
            if (isOverlapping(scheduledSlot, timeSlot)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(int[] slot1, int[] slot2) {
        return (slot1[0] < slot2[1] && slot1[1] > slot2[0]);
    }
}