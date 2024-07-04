import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int t = 0; t < testCases; t++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[activitiesCount][2];
            
            for (int i = 0; i < activitiesCount; i++) {
                String[] times = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(times[0]);
                activities[i][1] = Integer.parseInt(times[1]);
            }
            
            scheduleActivities(activities, t);
        }
        
        scanner.close();
    }

    private static void scheduleActivities(int[][] activities, int testCase) {
        StringBuilder schedule = new StringBuilder();
        Set<Integer> cSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();
        
        for (int[] activity : activities) {
            boolean canAssignToC = true;
            
            for (int time = activity[0]; time < activity[1]; time++) {
                if (cSet.contains(time)) {
                    if (jSet.contains(time)) {
                        System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
                        return;
                    }
                    canAssignToC = false;
                }
            }
            
            for (int time = activity[0]; time < activity[1]; time++) {
                if (canAssignToC) {
                    cSet.add(time);
                } else {
                    jSet.add(time);
                }
            }
            
            if (canAssignToC) {
                schedule.append("C");
            } else {
                schedule.append("J");
            }
        }
        
        System.out.println("Case #" + (testCase + 1) + ": " + schedule.toString());
    }
}