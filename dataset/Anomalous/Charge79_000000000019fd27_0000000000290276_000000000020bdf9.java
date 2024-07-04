import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] activities = new String[n];
            for (int j = 0; j < n; j++) {
                activities[j] = scanner.nextLine();
            }
            results[i] = scheduleActivities(n, activities);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static String scheduleActivities(int n, String[] activities) {
        boolean[] cTime = new boolean[1440];
        boolean[] jTime = new boolean[1440];
        StringBuilder output = new StringBuilder();

        for (String activity : activities) {
            String[] times = activity.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            boolean cAvailable = isAvailable(cTime, start, end);
            boolean jAvailable = isAvailable(jTime, start, end);

            if (cAvailable) {
                output.append("C");
                markTime(cTime, start, end);
            } else if (jAvailable) {
                output.append("J");
                markTime(jTime, start, end);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }

    private static boolean isAvailable(boolean[] timeSlots, int start, int end) {
        for (int i = start; i < end; i++) {
            if (timeSlots[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markTime(boolean[] timeSlots, int start, int end) {
        for (int i = start; i < end; i++) {
            timeSlots[i] = true;
        }
    }
}