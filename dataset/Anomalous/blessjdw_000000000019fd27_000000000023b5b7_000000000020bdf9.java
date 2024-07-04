import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] cameronSchedule = new int[60 * 24];
            int[] jamieSchedule = new int[60 * 24];
            int activitiesCount = scanner.nextInt();
            StringBuilder resultBuilder = new StringBuilder();

            for (int i = 1; i <= activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (resultBuilder.length() > 0) continue;

                if (isAvailable(jamieSchedule, start, end)) {
                    scheduleActivity(jamieSchedule, start, end, i);
                } else if (isAvailable(cameronSchedule, start, end)) {
                    scheduleActivity(cameronSchedule, start, end, i);
                } else {
                    resultBuilder.append("IMPOSSIBLE");
                }
            }

            if (resultBuilder.length() == 0) {
                Set<Integer> cameronSet = new HashSet<>();
                Set<Integer> jamieSet = new HashSet<>();

                for (int activity : cameronSchedule) cameronSet.add(activity);
                for (int activity : jamieSchedule) jamieSet.add(activity);

                for (int i = 1; i <= activitiesCount; i++) {
                    if (cameronSet.contains(i)) resultBuilder.append("C");
                    if (jamieSet.contains(i)) resultBuilder.append("J");
                }

                if (resultBuilder.length() != activitiesCount) {
                    throw new RuntimeException("Scheduling error");
                }
            }

            System.out.println("Case #" + t + ": " + resultBuilder.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) return false;
        }
        return true;
    }

    private static void scheduleActivity(int[] schedule, int start, int end, int activityNumber) {
        for (int i = start; i < end; i++) {
            schedule[i] = activityNumber;
        }
    }
}