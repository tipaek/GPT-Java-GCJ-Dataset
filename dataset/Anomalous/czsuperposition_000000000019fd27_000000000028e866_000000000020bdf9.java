import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            int maxEndTime = Integer.MIN_VALUE;
            
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                maxEndTime = Math.max(maxEndTime, activities[j][1]);
            }
            
            int[][] originalActivities = activities.clone();
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            boolean isImpossible = false;
            int cCurrentActivity = -1, jCurrentActivity = -1;
            int cEndTime = -1, jEndTime = -1;
            boolean cIsBusy = false, jIsBusy = false;
            char[] sortedOrder = new char[N];
            Set<Integer> completedActivities = new HashSet<>();
            
            for (int time = 0; time <= maxEndTime; time++) {
                if (time == jEndTime) {
                    jIsBusy = false;
                    sortedOrder[jCurrentActivity] = 'J';
                }
                
                if (time == cEndTime) {
                    cIsBusy = false;
                    sortedOrder[cCurrentActivity] = 'C';
                }
                
                for (int k = 0; k < N; k++) {
                    if (!completedActivities.contains(k) && time == activities[k][0]) {
                        completedActivities.add(k);
                        
                        if (cIsBusy && jIsBusy) {
                            results[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        
                        if (cIsBusy) {
                            jIsBusy = true;
                            jEndTime = activities[k][1];
                            jCurrentActivity = k;
                        } else {
                            cIsBusy = true;
                            cEndTime = activities[k][1];
                            cCurrentActivity = k;
                        }
                    }
                }
                
                if (isImpossible) {
                    break;
                }
            }
            
            if (isImpossible) {
                continue;
            }
            
            StringBuilder schedule = new StringBuilder();
            for (int[] activity : originalActivities) {
                for (int j = 0; j < N; j++) {
                    if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                        schedule.append(sortedOrder[j]);
                    }
                }
            }
            results[i] = schedule.toString();
        }
        
        for (String result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}