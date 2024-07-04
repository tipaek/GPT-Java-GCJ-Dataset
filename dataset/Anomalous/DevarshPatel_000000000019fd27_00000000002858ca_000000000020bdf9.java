import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int numActivities = sc.nextInt();
            int[][] activities = new int[numActivities][2];
            
            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = sc.nextInt();
                activities[j][1] = sc.nextInt();
            }
            
            results.add(Solver1.solve(activities, numActivities));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver1 {
    public static String solve(int[][] activities, int n) {
        StringBuilder output = new StringBuilder();
        int freeC = 0;
        int freeJ = 0;
        int freeC0 = 0;
        int freeJ0 = 0;
        ArrayList<String> assignments = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int[] activity = activities[i];
            
            if (freeC <= activity[0] || freeC0 >= activity[1]) {
                assignments.add("C");
                freeC0 = activity[0];
                freeC = activity[1];
            } else if (freeJ <= activity[0] || freeJ0 >= activity[1]) {
                assignments.add("J");
                freeJ0 = activity[0];
                freeJ = activity[1];
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