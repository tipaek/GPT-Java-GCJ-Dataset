import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            ArrayList<Activity> activitiesForJ = new ArrayList<>(activitiesCount);
            ArrayList<Activity> activitiesForC = new ArrayList<>(activitiesCount);
            ArrayList<Activity> remainingActivities = new ArrayList<>(activitiesCount);

            for (int j = 0; j < activitiesCount; j++) {
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                activitiesForJ.add(activity);
                activitiesForC.add(activity);
                remainingActivities.add(activity);
            }

            String schedule = "";
            while (!remainingActivities.isEmpty()) {
                Activity currentActivity = remainingActivities.remove(0);
                
                if (activitiesForJ.contains(currentActivity)) {
                    schedule += "J";
                    activitiesForJ.remove(currentActivity);
                    removeOverlappingActivities(activitiesForJ, currentActivity);
                } else if (activitiesForC.contains(currentActivity)) {
                    schedule += "C";
                    activitiesForC.remove(currentActivity);
                    removeOverlappingActivities(activitiesForC, currentActivity);
                } else {
                    schedule = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", caseNumber, schedule);
        }
        scanner.close();
    }

    private static void removeOverlappingActivities(ArrayList<Activity> activities, Activity currentActivity) {
        Iterator<Activity> iterator = activities.iterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            if (activity.overlapsWith(currentActivity)) {
                iterator.remove();
            }
        }
    }
}

class Activity {
    private final int start;
    private final int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean overlapsWith(Activity other) {
        return (other.start > this.start && other.start < this.end) ||
               (this.start > other.start && this.start < other.end);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Activity activity = (Activity) obj;
        return start == activity.start && end == activity.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}