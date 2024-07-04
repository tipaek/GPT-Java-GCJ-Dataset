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

            int[][] originalActivities = Arrays.copyOf(activities, activities.length);
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean impossible = false;
            int currentCActivity = -1, currentJActivity = -1;
            int endC = -1, endJ = -1;
            boolean cBusy = false, jBusy = false;
            String[] assignments = new String[N];
            Set<Integer> completedActivities = new HashSet<>();

            for (int time = 0; time <= 1440; time++) {
                if (impossible) break;

                if (time == endJ) {
                    jBusy = false;
                    assignments[currentJActivity] = "J";
                }
                if (time == endC) {
                    cBusy = false;
                    assignments[currentCActivity] = "C";
                }

                for (int k = 0; k < N; k++) {
                    if (completedActivities.contains(k)) continue;

                    if (time >= activities[k][0] && time <= activities[k][1]) {
                        if (cBusy && jBusy) {
                            results[i] = "IMPOSSIBLE";
                            impossible = true;
                            break;
                        }

                        completedActivities.add(k);
                        if (cBusy) {
                            jBusy = true;
                            endJ = activities[k][1];
                            currentJActivity = k;
                        } else {
                            cBusy = true;
                            endC = activities[k][1];
                            currentCActivity = k;
                        }
                    }
                }
            }

            if (impossible) continue;

            StringBuilder schedule = new StringBuilder();
            for (int[] activity : originalActivities) {
                for (int j = 0; j < N; j++) {
                    if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                        schedule.append(assignments[j]);
                    }
                }
            }
            results[i] = schedule.toString();
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}