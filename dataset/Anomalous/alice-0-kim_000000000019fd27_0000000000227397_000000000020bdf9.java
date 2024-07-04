import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[] lastEndTime = new int[2]; // To track the end time for Cameron and Jamie
            String initials = "CJ";
            int currentPerson = 0; // Start with Cameron
            int assignedActivities = 0;
            char[] result = new char[numActivities];
            int[][] activities = new int[numActivities][3];
            
            for (int i = 0; i < numActivities; i++) {
                activities[i] = new int[]{scanner.nextInt(), scanner.nextInt(), i};
            }
            
            // Sort activities by end time
            Arrays.sort(activities, Comparator.comparingInt(activity -> activity[1]));
            
            // Assign first activity to Cameron
            result[activities[0][2]] = 'C';
            assignedActivities++;
            lastEndTime[0] = activities[0][1];
            
            for (int i = 1; i < numActivities; i++) {
                int[] currentActivity = activities[i];
                int[] previousActivity = activities[i - 1];
                
                if (previousActivity[1] <= currentActivity[0]) {
                    // No overlap, assign current activity to the same person
                    result[currentActivity[2]] = initials.charAt(currentPerson);
                    assignedActivities++;
                    lastEndTime[currentPerson] = currentActivity[1];
                } else {
                    // Switch to the other person
                    currentPerson = (currentPerson + 1) % 2;
                    if (lastEndTime[currentPerson] <= currentActivity[0]) {
                        result[currentActivity[2]] = initials.charAt(currentPerson);
                        assignedActivities++;
                        lastEndTime[currentPerson] = currentActivity[1];
                    }
                }
            }
            
            // Check if all activities are assigned
            String output = assignedActivities == numActivities ? new String(result) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", t, output);
        }
        
        scanner.close();
    }
}