import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][2];
            
            for (int j = 0; j < numberOfActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            results.add(new ActivityScheduler().schedule(activities, numberOfActivities));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class ActivityScheduler {
    public String schedule(int[][] activities, int numberOfActivities) {
        StringBuilder output = new StringBuilder();
        int endTimeC = 0;
        int endTimeJ = 0;
        int startTimeC = 0;
        int startTimeJ = 0;
        
        ArrayList<String> assignments = new ArrayList<>();
        
        for (int i = 0; i < numberOfActivities; i++) {
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
        
        for (String assignment : assignments) {
            output.append(assignment);
        }
        
        return output.toString();
    }
}