import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            
            String[] result = new String[n];
            Arrays.fill(result, "");
            
            if (assignActivities(activities)) {
                for (Activity activity : activities) {
                    result[activity.id] = activity.assignedPerson;
                }
                System.out.println("Case #" + t + ": " + String.join("", result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
    
    private static boolean assignActivities(Activity[] activities) {
        Arrays.sort(activities);
        int cEnd = 0, jEnd = 0;
        
        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                cEnd = activity.end;
                activity.assignedPerson = "C";
            } else if (activity.start >= jEnd) {
                jEnd = activity.end;
                activity.assignedPerson = "J";
            } else {
                return false;
            }
        }
        return true;
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int id;
        String assignedPerson = "";
        
        public Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
        
        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}