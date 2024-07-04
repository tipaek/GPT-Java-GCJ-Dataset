import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answers = new String[T];
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            int maxEndTime = Integer.MIN_VALUE;
            
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                maxEndTime = Math.max(maxEndTime, activities[j][1]);
            }
            
            int[][] originalActivities = Arrays.copyOf(activities, activities.length);
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            boolean isImpossible = false;
            int cCurrentActivity = -1, jCurrentActivity = -1;
            int cEndTime = -1, jEndTime = -1;
            List<Integer> doneActivities = new ArrayList<>();
            boolean cIsBusy = false, jIsBusy = false;
            char[] sortedOrder = new char[N];
            
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
                    if (!doneActivities.contains(k) && time == activities[k][0]) {
                        doneActivities.add(k);
                        
                        if (cIsBusy && jIsBusy) {
                            answers[i] = "IMPOSSIBLE";
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
                
                if (isImpossible) break;
            }
            
            if (isImpossible) continue;
            
            StringBuilder result = new StringBuilder();
            for (int[] activity : originalActivities) {
                for (int j = 0; j < N; j++) {
                    if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                        result.append(sortedOrder[j]);
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