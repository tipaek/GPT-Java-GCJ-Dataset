import java.util.*;
import java.io.*;

public class ParentingPartneringReturns {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
            
            int jEnd = 0;
            int cEnd = 0;
            StringBuilder schedule = new StringBuilder();
            
            for (Activity activity : activities) {
                if (activity.start >= jEnd) {
                    schedule.append("J");
                    jEnd = activity.end;
                } else if (activity.start >= cEnd) {
                    schedule.append("C");
                    cEnd = activity.end;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
    }
}

class Activity {
    int start;
    int end;
    
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}