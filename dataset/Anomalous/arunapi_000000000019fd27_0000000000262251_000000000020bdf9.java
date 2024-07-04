import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            String[] assignments = new String[activitiesCount];
            String result = "";
            
            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                
                assignments = assignActivity(activities, assignments, i);
                
                if (assignments[i] == null) {
                    result = "IMPOSSIBLE";
                    break;
                }
                result += assignments[i];
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String[] assignActivity(int[][] activities, String[] assignments, int currentIndex) {
        if (currentIndex == 0) {
            assignments[currentIndex] = "J";
            return assignments;
        }
        
        assignments[currentIndex] = null;
        int start = activities[currentIndex][0];
        int end = activities[currentIndex][1];
        boolean jOccupied = false;
        
        for (int i = 0; i < currentIndex; i++) {
            int existingStart = activities[i][0];
            int existingEnd = activities[i][1];
            
            if (!((start < existingStart && end <= existingStart) || start >= existingEnd)) {
                if (jOccupied) {
                    assignments[currentIndex] = null;
                    return assignments;
                } else {
                    if ("J".equals(assignments[i])) {
                        jOccupied = true;
                    }
                }
            }
        }
        
        assignments[currentIndex] = jOccupied ? "C" : "J";
        return assignments;
    }
}