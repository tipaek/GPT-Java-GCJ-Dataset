import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answer = new String[T];

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
            int cCurrentActivity = -1, jCurrentActivity = -1;
            int cEnd = -1, jEnd = -1;
            boolean cWorks = false, jWorks = false;
            char[] sortedOrder = new char[N];
            Set<Integer> doneActivities = new HashSet<>();

            for (int time = 0; time <= maxEnd; time++) {
                if (time == jEnd) {
                    jWorks = false;
                    sortedOrder[jCurrentActivity] = 'J';
                }
                if (time == cEnd) {
                    cWorks = false;
                    sortedOrder[cCurrentActivity] = 'C';
                }

                for (int k = 0; k < N; k++) {
                    if (!doneActivities.contains(k) && time == activities[k][0]) {
                        doneActivities.add(k);
                        if (cWorks && jWorks) {
                            answer[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        if (cWorks) {
                            jWorks = true;
                            jEnd = activities[k][1];
                            jCurrentActivity = k;
                        } else {
                            cWorks = true;
                            cEnd = activities[k][1];
                            cCurrentActivity = k;
                        }
                    }
                }
                if (isImpossible) break;
            }

            if (!isImpossible) {
                StringBuilder result = new StringBuilder();
                for (int[] activity : original) {
                    for (int j = 0; j < N; j++) {
                        if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                            result.append(sortedOrder[j]);
                            break;
                        }
                    }
                }
                answer[i] = result.toString();
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answer[i]);
        }
    }
}