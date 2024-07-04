import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            Activity[] activities = new Activity[activitiesCount];
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
            }
            
            Arrays.sort(activities);
            StringBuilder result = new StringBuilder();
            int cEndTime = 0;
            int jEndTime = 0;
            boolean impossible = false;
            
            for (Activity activity : activities) {
                if (activity.start >= cEndTime) {
                    result.append("C");
                    cEndTime = activity.end;
                } else if (activity.start >= jEndTime) {
                    result.append("J");
                    jEndTime = activity.end;
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
        
        scanner.close();
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "[" + start + " " + end + "]";
    }
}