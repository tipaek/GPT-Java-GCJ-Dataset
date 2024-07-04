import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            
            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            results.add(new ActivityScheduler().schedule(activities, numActivities));
        }
        
        int caseNumber = 1;
        for (String result : results) {
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}

class ActivityScheduler {
    public String schedule(int[][] activities, int numActivities) {
        StringBuilder result = new StringBuilder();
        int endTimeC = 0;
        int endTimeJ = 0;
        int startTimeC = 0;
        int startTimeJ = 0;
        
        ArrayList<String> assignments = new ArrayList<>();
        
        for (int i = 0; i < numActivities; i++) {
            int[] activity = activities[i];
            
            if (endTimeC <= activity[0] || startTimeC >= activity[1]) {
                assignments.add("C");
                startTimeC = activity[0];
                endTimeC = activity[1];
            } else if (endTimeJ <= activity[0] || startTimeJ >= activity[1]) {
                assignments.add("J");
                startTimeJ = activity[0];
                endTimeJ = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;
        
        for (int i = 0; i < numActivities; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }
        
        if (!assignments.get(earliestIndex).equals("C")) {
            for (int i = 0; i < assignments.size(); i++) {
                if (assignments.get(i).equals("J")) {
                    assignments.set(i, "C");
                } else {
                    assignments.set(i, "J");
                }
            }
        }
        
        for (String assignment : assignments) {
            result.append(assignment);
        }
        
        return result.toString();
    }
}