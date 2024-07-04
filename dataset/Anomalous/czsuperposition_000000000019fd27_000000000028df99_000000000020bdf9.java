import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            int maxEndTime = Integer.MIN_VALUE;
            
            for (int i = 0; i < N; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                maxEndTime = Math.max(maxEndTime, activities[i][1]);
            }
            
            int[][] originalActivities = activities.clone();
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            boolean impossible = false;
            int cActivity = -1, jActivity = -1;
            int cEndTime = -1, jEndTime = -1;
            List<Integer> completedActivities = new ArrayList<>();
            boolean cBusy = false, jBusy = false;
            char[] activityAssignments = new char[N];
            
            for (int currentTime = 0; currentTime <= maxEndTime; currentTime++) {
                if (currentTime == jEndTime) {
                    jBusy = false;
                    activityAssignments[jActivity] = 'J';
                }
                if (currentTime == cEndTime) {
                    cBusy = false;
                    activityAssignments[cActivity] = 'C';
                }
                
                for (int i = 0; i < N; i++) {
                    if (!completedActivities.contains(i) && currentTime == activities[i][0]) {
                        completedActivities.add(i);
                        
                        if (cBusy && jBusy) {
                            results[t] = "IMPOSSIBLE";
                            impossible = true;
                            break;
                        }
                        
                        if (cBusy) {
                            jBusy = true;
                            jEndTime = activities[i][1];
                            jActivity = i;
                        } else {
                            cBusy = true;
                            cEndTime = activities[i][1];
                            cActivity = i;
                        }
                    }
                }
                
                if (impossible) break;
            }
            
            if (impossible) continue;
            
            StringBuilder assignmentOrder = new StringBuilder();
            for (int[] original : originalActivities) {
                for (int i = 0; i < N; i++) {
                    if (activities[i][0] == original[0] && activities[i][1] == original[1]) {
                        assignmentOrder.append(activityAssignments[i]);
                    }
                }
            }
            results[t] = assignmentOrder.toString();
        }
        
        for (int t = 0; t < T; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }
}