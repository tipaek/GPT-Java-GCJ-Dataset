import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int cases = scan.nextInt();

        for (int i = 0; i < cases; i++) {
            int activities = scan.nextInt();
            Activity[] activitiesArray = new Activity[activities];
            List<Activity> cameronActivities = new ArrayList<>();
            List<Activity> jamieActivities = new ArrayList<>();
            String result = "";

            for (int j = 0; j < activities; j++) {
                activitiesArray[j] = new Activity(scan.nextInt(), scan.nextInt());
                if (j == 0) {
                    cameronActivities.add(activitiesArray[j]);
                    result += "C";
                } else {
                    if (canAddActivity(cameronActivities, activitiesArray[j])) {
                        cameronActivities.add(activitiesArray[j]);
                        result += "C";
                    } else if (canAddActivity(jamieActivities, activitiesArray[j])) {
                        jamieActivities.add(activitiesArray[j]);
                        result += "J";
                    } else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            }

            if (result.equals("IMPOSSIBLE")) {
                result = tryAssigningToJamieFirst(activitiesArray);
            }

            results.add(result);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static boolean canAddActivity(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (overlap(activity, newActivity)) {
                return false;
            }
        }
        return true;
    }

    private static String tryAssigningToJamieFirst(Activity[] activitiesArray) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        String result = "";

        for (int j = 0; j < activitiesArray.length; j++) {
            if (j == 0) {
                jamieActivities.add(activitiesArray[j]);
                result += "J";
            } else {
                if (canAddActivity(cameronActivities, activitiesArray[j])) {
                    cameronActivities.add(activitiesArray[j]);
                    result += "C";
                } else if (canAddActivity(jamieActivities, activitiesArray[j])) {
                    jamieActivities.add(activitiesArray[j]);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
        }

        return result;
    }

    public static boolean overlap(Activity a1, Activity a2) {
        return (a1.start < a2.end && a1.end > a2.start);
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