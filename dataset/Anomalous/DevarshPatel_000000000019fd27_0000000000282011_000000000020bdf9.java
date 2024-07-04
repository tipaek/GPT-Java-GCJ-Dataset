import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            
            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            results.add(Solver.solve(activities, activityCount));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(int[][] activities, int activityCount) {
        StringBuilder result = new StringBuilder();
        int cameronEnd = 0;
        int jamieEnd = 0;
        int cameronStart = 0;
        int jamieStart = 0;
        ArrayList<String> assignments = new ArrayList<>();
        
        for (int i = 0; i < activityCount; i++) {
            int[] activity = activities[i];
            
            if (cameronEnd <= activity[0] || cameronStart >= activity[1]) {
                assignments.add("C");
                cameronStart = activity[0];
                cameronEnd = activity[1];
            } else if (jamieEnd <= activity[0] || jamieStart >= activity[1]) {
                assignments.add("J");
                jamieStart = activity[0];
                jamieEnd = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = 0;
        
        for (int i = 0; i < activityCount; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }
        
        if (assignments.get(earliestIndex).equals("J")) {
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