import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answers = new String[T];
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            int[][] original = activities.clone();
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            boolean isImpossible = false;
            int currentCActivity = -1, currentJActivity = -1;
            int endC = -1, endJ = -1;
            List<Integer> completedActivities = new ArrayList<>();
            boolean isCWorking = false, isJWorking = false;
            String[] sortedOrder = new String[N];
            
            for (int time = 0; time <= 1440; time++) {
                if (time == endJ) {
                    isJWorking = false;
                    sortedOrder[currentJActivity] = "J";
                }
                if (time == endC) {
                    isCWorking = false;
                    sortedOrder[currentCActivity] = "C";
                }
                
                for (int k = 0; k < N; k++) {
                    if (completedActivities.contains(k)) continue;
                    if (time == activities[k][0]) {
                        if (isCWorking && isJWorking) {
                            answers[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        completedActivities.add(k);
                        if (isCWorking) {
                            isJWorking = true;
                            endJ = activities[k][1];
                            currentJActivity = k;
                        } else {
                            isCWorking = true;
                            endC = activities[k][1];
                            currentCActivity = k;
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
                        }
                    }
                }
                answers[i] = result.toString();
            }
        }
        
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }
}