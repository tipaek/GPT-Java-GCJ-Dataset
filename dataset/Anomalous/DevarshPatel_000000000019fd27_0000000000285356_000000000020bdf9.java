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
        StringBuilder result = new StringBuilder();
        int freeC = 0, freeJ = 0;
        int freeC0 = 0, freeJ0 = 0;
        List<String> assignments = new ArrayList<>();
        
        for (int[] activity : activities) {
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
        
        int earliestStart = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                index = i;
            }
        }
        
        if (!assignments.get(index).equals("C")) {
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