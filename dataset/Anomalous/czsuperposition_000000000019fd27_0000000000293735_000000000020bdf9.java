import java.util.*;

public class Solution {
    private static int[][] activities;
    private static int[] endTimes;
    private static int numActivities;
    private static List<Integer> jActivities;
    private static List<Integer> cActivities;

    public static boolean scheduleActivities(int nextActivity) {
        if (nextActivity == numActivities) {
            return true;
        }

        int activityIndex = activities[nextActivity][1];
        boolean canJDo = jActivities.isEmpty() || endTimes[jActivities.get(jActivities.size() - 1)] <= activities[nextActivity][0];
        boolean canCDo = cActivities.isEmpty() || endTimes[cActivities.get(cActivities.size() - 1)] <= activities[nextActivity][0];

        if (!canJDo && !canCDo) {
            return false;
        }

        if (canCDo) {
            cActivities.add(activityIndex);
            if (scheduleActivities(nextActivity + 1)) {
                return true;
            }
            cActivities.remove(cActivities.size() - 1);
        }

        if (canJDo) {
            jActivities.add(activityIndex);
            if (scheduleActivities(nextActivity + 1)) {
                return true;
            }
            jActivities.remove(jActivities.size() - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            numActivities = scanner.nextInt();
            activities = new int[numActivities][2];
            endTimes = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = j;
                endTimes[j] = scanner.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(x -> x[0]));
            jActivities = new ArrayList<>();
            cActivities = new ArrayList<>();

            if (scheduleActivities(0)) {
                Collections.sort(jActivities);
                StringBuilder schedule = new StringBuilder();
                int currentIndex = 0;

                for (int activity : jActivities) {
                    while (currentIndex < activity) {
                        schedule.append("C");
                        currentIndex++;
                    }
                    schedule.append("J");
                    currentIndex++;
                }

                while (currentIndex < numActivities) {
                    schedule.append("C");
                    currentIndex++;
                }

                results[i] = schedule.toString();
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}