import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            
            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
                activities[activityIndex][0] = scanner.nextInt();
                activities[activityIndex][1] = scanner.nextInt();
            }
            
            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
            
            int endTimeJ = 0;
            int endTimeC = 0;
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            
            for (int[] activity : activities) {
                if (activity[0] >= endTimeJ) {
                    endTimeJ = activity[1];
                    schedule.append("J");
                } else if (activity[0] >= endTimeC) {
                    endTimeC = activity[1];
                    schedule.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseIndex + ": " + schedule.toString());
            }
        }
        
        scanner.close();
    }
}