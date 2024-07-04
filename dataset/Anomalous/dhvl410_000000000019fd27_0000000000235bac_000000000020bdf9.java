import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][4];
            
            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt(); // start time
                activities[i][1] = scanner.nextInt(); // end time
                activities[i][2] = i; // original index
                activities[i][3] = 0; // assigned person (0: unassigned, 1: C, 2: J)
            }
            
            assignActivities(activities, t);
        }
    }

    private static void assignActivities(int[][] activities, int testCaseNumber) {
        StringBuilder result = new StringBuilder();
        result.append("Case #").append(testCaseNumber + 1).append(": ");
        
        Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
        
        int endTimeC = 0, endTimeJ = 0;
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (start >= endTimeC) {
                endTimeC = end;
                activity[3] = 1; // assign to C
            } else if (start >= endTimeJ) {
                endTimeJ = end;
                activity[3] = 2; // assign to J
            } else {
                System.out.println("Case #" + (testCaseNumber + 1) + ": IMPOSSIBLE");
                return;
            }
        }
        
        Arrays.sort(activities, (a, b) -> Integer.compare(a[2], b[2]));
        
        for (int[] activity : activities) {
            if (activity[3] == 1) {
                result.append("C");
            } else {
                result.append("J");
            }
        }
        
        System.out.println(result.toString());
    }
}