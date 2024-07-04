import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answers = new String[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            int maxEnd = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                maxEnd = Math.max(maxEnd, activities[j][1]);
            }

            int[][] original = Arrays.copyOf(activities, activities.length);
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean isImpossible = false;
            int cEnd = -1, jEnd = -1;
            boolean cBusy = false, jBusy = false;
            char[] schedule = new char[N];
            List<Integer> assignedActivities = new ArrayList<>();

            for (int time = 0; time <= maxEnd; time++) {
                if (time == jEnd) {
                    jBusy = false;
                    schedule[assignedActivities.get(assignedActivities.size() - 1)] = 'J';
                }
                if (time == cEnd) {
                    cBusy = false;
                    schedule[assignedActivities.get(assignedActivities.size() - 1)] = 'C';
                }

                for (int k = 0; k < N; k++) {
                    if (!assignedActivities.contains(k) && time == activities[k][0]) {
                        assignedActivities.add(k);
                        if (cBusy && jBusy) {
                            answers[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        if (cBusy) {
                            jBusy = true;
                            jEnd = activities[k][1];
                        } else {
                            cBusy = true;
                            cEnd = activities[k][1];
                        }
                    }
                }
                if (isImpossible) break;
            }

            if (isImpossible) continue;

            StringBuilder result = new StringBuilder();
            for (int[] activity : original) {
                for (int j = 0; j < N; j++) {
                    if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                        result.append(schedule[j]);
                    }
                }
            }
            answers[i] = result.toString();
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }
}