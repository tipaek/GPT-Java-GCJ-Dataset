import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
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
    public static String solve(int[][] activities, int n) {
        StringBuilder output = new StringBuilder();
        int endC = 0;
        int endJ = 0;
        List<String> assignments = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int start = activities[i][0];
            int end = activities[i][1];
            
            if (endC <= start) {
                assignments.add("C");
                endC = end;
            } else if (endJ <= start) {
                assignments.add("J");
                endJ = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        for (String assignment : assignments) {
            output.append(assignment);
        }
        
        return output.toString();
    }
}