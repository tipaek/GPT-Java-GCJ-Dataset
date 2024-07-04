import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int[][] activities = new int[num][2];
            
            for (int j = 0; j < num; j++) {
                activities[j][0] = sc.nextInt();
                activities[j][1] = sc.nextInt();
            }
            
            results.add(Solver.solve(activities, num));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(int[][] activities, int n) {
        StringBuilder output = new StringBuilder();
        int freeC = 0, freeJ = 0;
        List<String> assignments = new ArrayList<>();
        
        for (int[] activity : activities) {
            if (freeC <= activity[0]) {
                assignments.add("C");
                freeC = activity[1];
            } else if (freeJ <= activity[0]) {
                assignments.add("J");
                freeJ = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;
        
        for (int i = 0; i < n; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }
        
        if (!assignments.get(earliestIndex).equals("C")) {
            for (int i = 0; i < assignments.size(); i++) {
                assignments.set(i, assignments.get(i).equals("C") ? "J" : "C");
            }
        }

        for (String assignment : assignments) {
            output.append(assignment);
        }
        
        return output.toString();
    }
}