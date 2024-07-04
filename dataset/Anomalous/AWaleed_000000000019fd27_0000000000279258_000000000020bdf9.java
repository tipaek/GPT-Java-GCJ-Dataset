import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][3];
            int[][] sortedActivities = new int[activitiesCount][3];
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i][0] = start;
                activities[i][1] = end;
                activities[i][2] = i;
                sortedActivities[i][0] = start;
                sortedActivities[i][1] = end;
                sortedActivities[i][2] = i;
            }
            
            sortActivities(sortedActivities);
            
            int cameronEnd = 0, jamieEnd = 0;
            activities[sortedActivities[0][2]][2] = 1; // Cameron is 1, Jamie is 2
            cameronEnd = sortedActivities[0][1];
            boolean isImpossible = false;
            
            for (int i = 1; i < activitiesCount; i++) {
                int start = sortedActivities[i][0];
                if (start >= cameronEnd) {
                    cameronEnd = sortedActivities[i][1];
                    activities[sortedActivities[i][2]][2] = 1;
                } else if (start >= jamieEnd) {
                    jamieEnd = sortedActivities[i][1];
                    activities[sortedActivities[i][2]][2] = 2;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < activitiesCount; i++) {
                    result.append(activities[i][2] == 1 ? "C" : "J");
                }
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
        
        scanner.close();
    }

    private static void sortActivities(int[][] activities) {
        int n = activities.length;
        for (int i = 1; i < n; i++) {
            int[] key = activities[i];
            int j = i - 1;
            
            while (j >= 0 && activities[j][0] > key[0]) {
                activities[j + 1] = activities[j];
                j--;
            }
            activities[j + 1] = key;
        }
    }
}