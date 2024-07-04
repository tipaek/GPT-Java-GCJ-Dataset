import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= testCases; i++) {
            int numberOfActivities = Integer.parseInt(scanner.nextLine());
            Activity[] activities = new Activity[numberOfActivities];
            
            for (int j = 0; j < numberOfActivities; j++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                activities[j] = new Activity(start, end);
            }
            
            ArrayList<Activity> cameronActivities = new ArrayList<>();
            ArrayList<Activity> jamieActivities = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            
            for (Activity activity : activities) {
                if (isNonOverlapping(activity, cameronActivities)) {
                    result.append("C");
                    cameronActivities.add(activity);
                } else if (isNonOverlapping(activity, jamieActivities)) {
                    result.append("J");
                    jamieActivities.add(activity);
                } else {
                    result.setLength(0); // Clear the result
                    result.append("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
    
    public static boolean isNonOverlapping(Activity newActivity, ArrayList<Activity> existingActivities) {
        for (Activity activity : existingActivities) {
            if (!(newActivity.start >= activity.end || newActivity.end <= activity.start)) {
                return false;
            }
        }
        return true;
    }
}

class Activity {
    int start;
    int end;
    
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}