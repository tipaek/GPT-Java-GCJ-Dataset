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
        
        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            int numActivities = scanner.nextInt();

            List<Activity> activitiesC = new ArrayList<>();
            List<Activity> activitiesJ = new ArrayList<>();

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                boolean canAssignToC = true;
                for (Activity activity : activitiesC) {
                    if ((start < activity.end && start >= activity.start) || 
                        (end > activity.start && end <= activity.end)) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    result.append("C");
                    activitiesC.add(new Activity(start, end));
                } else {
                    boolean canAssignToJ = true;
                    for (Activity activity : activitiesJ) {
                        if ((start < activity.end && start >= activity.start) || 
                            (end > activity.start && end <= activity.end)) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        result.append("J");
                        activitiesJ.add(new Activity(start, end));
                    } else {
                        isPossible = false;
                        break;
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
}