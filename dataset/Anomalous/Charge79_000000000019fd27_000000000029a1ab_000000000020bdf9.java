import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

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

            results[i] = scheduleActivities(numActivities, activities);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static String scheduleActivities(int numActivities, String[] activities) {
        boolean[] cTime = new boolean[1441];
        boolean[] jTime = new boolean[1441];
        StringBuilder output = new StringBuilder();

        for (String activity : activities) {
            String[] timeRange = activity.split(" ");
            int start = Integer.parseInt(timeRange[0]);
            int end = Integer.parseInt(timeRange[1]);

            if (isTimeSlotAvailable(cTime, start, end)) {
                markTimeSlot(cTime, start, end);
                output.append("C");
            } else if (isTimeSlotAvailable(jTime, start, end)) {
                markTimeSlot(jTime, start, end);
                output.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }

    private static boolean isTimeSlotAvailable(boolean[] timeArray, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (timeArray[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markTimeSlot(boolean[] timeArray, int start, int end) {
        Arrays.fill(timeArray, start, end + 1, true);
    }
}