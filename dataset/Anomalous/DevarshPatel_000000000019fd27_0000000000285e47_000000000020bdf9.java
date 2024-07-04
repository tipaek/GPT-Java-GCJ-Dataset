import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < numCases; i++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            
            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            results.add(Solver.solve(activities, numActivities));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(int[][] activities, int numActivities) {
        StringBuilder result = new StringBuilder();
        int endC = 0, endJ = 0;
        ArrayList<String> assignments = new ArrayList<>();
        
        for (int[] activity : activities) {
            if (endC <= activity[0]) {
                assignments.add("C");
                endC = activity[1];
            } else if (endJ <= activity[0]) {
                assignments.add("J");
                endJ = activity[1];
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
                assignments.set(i, assignments.get(i).equals("J") ? "C" : "J");
            }
        }
        
        for (String assignment : assignments) {
            result.append(assignment);
        }
        
        return result.toString();
    }
}