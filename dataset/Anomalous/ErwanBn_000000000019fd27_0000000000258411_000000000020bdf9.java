import java.io.*;
import java.util.*;

class Activity {
    public int start;
    public int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numberOfLines = scanner.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            int numberOfActivities = scanner.nextInt();

            List<Activity> cameronActivities = new ArrayList<>();
            List<Activity> jamieActivities = new ArrayList<>();

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < numberOfActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                boolean canAssignToCameron = isAssignable(cameronActivities, start, end);
                if (canAssignToCameron) {
                    result.append("C");
                    cameronActivities.add(new Activity(start, end));
                } else {
                    boolean canAssignToJamie = isAssignable(jamieActivities, start, end);
                    if (canAssignToJamie) {
                        result.append("J");
                        jamieActivities.add(new Activity(start, end));
                    } else {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isAssignable(List<Activity> activities, int start, int end) {
        for (Activity activity : activities) {
            if (start < activity.end && end > activity.start) {
                return false;
            }
        }
        return true;
    }
}