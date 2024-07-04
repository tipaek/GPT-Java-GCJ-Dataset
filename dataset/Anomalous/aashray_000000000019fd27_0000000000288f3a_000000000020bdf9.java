import java.util.*;
import java.io.*;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][3];
            
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int[] assignedTo = new int[numActivities];
            int[] endTimes = new int[2]; // endTimes[0] for Cameron, endTimes[1] for Jamie
            
            boolean isPossible = true;
            
            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];
                
                if (start >= endTimes[0]) {
                    endTimes[0] = end;
                    assignedTo[index] = 0; // Cameron
                } else if (start >= endTimes[1]) {
                    endTimes[1] = end;
                    assignedTo[index] = 1; // Jamie
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (isPossible) {
                for (int i : assignedTo) {
                    result.append(i == 0 ? 'C' : 'J');
                }
            } else {
                result.append("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}