import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
            
            int endJ = 0;
            int endC = 0;
            StringBuilder schedule = new StringBuilder();
            
            for (Activity activity : activities) {
                if (activity.start >= endJ) {
                    schedule.append('J');
                    endJ = activity.end;
                } else if (activity.start >= endC) {
                    schedule.append('C');
                    endC = activity.end;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + caseIndex + ": " + schedule.toString());
        }
    }

    static class Activity {
        int start;
        int end;
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}