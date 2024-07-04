import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            // Read the number of activities
            int activities = scanner.nextInt();
            String result = "";
            
            // Create arrays to keep track of Jamie's and Cameron's schedules
            boolean[] jamieSchedule = new boolean[1441];
            boolean[] cameronSchedule = new boolean[1441];
            
            boolean possible = true;
            
            for (int j = 0; j < activities; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                // Check if Jamie can take the activity
                boolean jamieAvailable = true;
                for (int k = startTime; k < endTime; k++) {
                    if (jamieSchedule[k]) {
                        jamieAvailable = false;
                        break;
                    }
                }
                
                if (jamieAvailable) {
                    result += "J";
                    for (int k = startTime; k < endTime; k++) {
                        jamieSchedule[k] = true;
                    }
                } else {
                    // Check if Cameron can take the activity
                    boolean cameronAvailable = true;
                    for (int k = startTime; k < endTime; k++) {
                        if (cameronSchedule[k]) {
                            cameronAvailable = false;
                            break;
                        }
                    }
                    
                    if (cameronAvailable) {
                        result += "C";
                        for (int k = startTime; k < endTime; k++) {
                            cameronSchedule[k] = true;
                        }
                    } else {
                        result = "IMPOSSIBLE";
                        possible = false;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}