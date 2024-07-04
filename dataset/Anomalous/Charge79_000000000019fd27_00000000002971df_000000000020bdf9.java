import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            String[] activities = new String[numActivities];

            for (int j = 0; j < numActivities; j++) {
                activities[j] = scanner.nextLine();
            }

            results[i] = scheduleActivities(activities);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static String scheduleActivities(String[] activities) {
        boolean[] cTime = new boolean[1441];
        boolean[] jTime = new boolean[1441];
        StringBuilder output = new StringBuilder();

        for (String activity : activities) {
            String[] times = activity.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            boolean cAvailable = isTimeSlotAvailable(cTime, start, end);
            boolean jAvailable = isTimeSlotAvailable(jTime, start, end);

            if (cAvailable) {
                output.append("C");
                Arrays.fill(cTime, start, end, true);
            } else if (jAvailable) {
                output.append("J");
                Arrays.fill(jTime, start, end, true);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }

    private static boolean isTimeSlotAvailable(boolean[] timeSlots, int start, int end) {
        for (int i = start; i < end; i++) {
            if (timeSlots[i]) {
                return false;
            }
        }
        return true;
    }
}