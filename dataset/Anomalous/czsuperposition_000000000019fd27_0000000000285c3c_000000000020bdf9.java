import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            int[][] originalActivities = activities.clone();
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean isImpossible = false;
            int cEnd = -1, jEnd = -1;
            char[] schedule = new char[N];
            Set<Integer> processedActivities = new HashSet<>();

            for (int time = 0; time <= 24 * 60; time++) {
                if (time == cEnd) {
                    schedule[findActivityIndex(activities, cEnd, processedActivities)] = 'C';
                }
                if (time == jEnd) {
                    schedule[findActivityIndex(activities, jEnd, processedActivities)] = 'J';
                }

                for (int k = 0; k < N; k++) {
                    if (processedActivities.contains(k)) continue;
                    if (time == activities[k][0]) {
                        if (cEnd > time && jEnd > time) {
                            results[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        processedActivities.add(k);
                        if (cEnd <= time) {
                            cEnd = activities[k][1];
                        } else {
                            jEnd = activities[k][1];
                        }
                    }
                }
                if (isImpossible) break;
            }

            if (!isImpossible) {
                StringBuilder result = new StringBuilder();
                for (int[] act : originalActivities) {
                    for (int j = 0; j < N; j++) {
                        if (activities[j][0] == act[0] && activities[j][1] == act[1]) {
                            result.append(schedule[j]);
                            break;
                        }
                    }
                }
                results[i] = result.toString();
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static int findActivityIndex(int[][] activities, int endTime, Set<Integer> processedActivities) {
        for (int i = 0; i < activities.length; i++) {
            if (activities[i][1] == endTime && !processedActivities.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}