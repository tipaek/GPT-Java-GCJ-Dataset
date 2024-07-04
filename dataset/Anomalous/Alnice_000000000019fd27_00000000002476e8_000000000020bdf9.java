import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }
            
            activities.sort(Comparator.comparingInt(a -> a.start));
            
            boolean[] assignedToJamie = new boolean[activityCount];
            Activity cameron = new Activity(-1, -1, -1);
            Activity jamie = new Activity(-1, -1, -1);
            boolean isImpossible = false;
            
            for (Activity activity : activities) {
                if (!activity.overlaps(cameron)) {
                    cameron = activity;
                } else if (!activity.overlaps(jamie)) {
                    jamie = activity;
                    assignedToJamie[activity.index] = true;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (boolean assigned : assignedToJamie) {
                    result.append(assigned ? "J" : "C");
                }
            }
            
            System.out.println("Case #" + (testCase + 1) + ": " + result);
        }
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        boolean overlaps(Activity other) {
            return this.end > other.start && this.start < other.end;
        }
    }
}