import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
            }
            
            Arrays.sort(activities);
            
            StringBuilder result = new StringBuilder();
            int cameronEnd = 0;
            int jamieEnd = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    result.append("C");
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    result.append("J");
                    jamieEnd = activity.end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
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