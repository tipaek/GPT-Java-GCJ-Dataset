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

    public static ArrayList<Integer> activityOrder;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {

            int numActivities = scanner.nextInt();
            Integer[][] activities = new Integer[numActivities][3];
            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
                activities[activityIndex][0] = scanner.nextInt();
                activities[activityIndex][1] = scanner.nextInt();
                activities[activityIndex][2] = activityIndex;
            }

            int attempts = 0;
            String result = "IMPOSSIBLE";
            boolean solutionFound = false;
            while (!solutionFound) {
                Collections.shuffle(Arrays.asList(activities));
                activityOrder = new ArrayList<>();
                result = getActivityAssignment(activities);
                if (attempts > numActivities * 15) solutionFound = true;
                if (!result.equals("IMPOSSIBLE")) solutionFound = true;
                attempts++;
            }
            if (!result.equals("IMPOSSIBLE")) {
                char[] resultArray = result.toCharArray();
                char[] orderedResultArray = new char[resultArray.length];
                for (int i = 0; i < resultArray.length; i++) {
                    orderedResultArray[activityOrder.get(i)] = resultArray[i];
                }
                result = String.valueOf(orderedResultArray);
            }
            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
    }

    public static String getActivityAssignment(Integer[][] activities) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        StringBuilder assignment = new StringBuilder();
        boolean isPossible = true;

        for (Integer[] activity : activities) {
            int start = activity[0];
            int end = activity[1];

            boolean canAssignToCameron = true;
            for (Activity cameronActivity : cameronActivities) {
                if (isOverlapping(cameronActivity, start, end)) {
                    canAssignToCameron = false;
                    break;
                }
            }

            if (canAssignToCameron) {
                assignment.append("C");
                activityOrder.add(activity[2]);
                cameronActivities.add(new Activity(start, end));
            } else {
                boolean canAssignToJamie = true;
                for (Activity jamieActivity : jamieActivities) {
                    if (isOverlapping(jamieActivity, start, end)) {
                        canAssignToJamie = false;
                        break;
                    }
                }
                if (canAssignToJamie) {
                    assignment.append("J");
                    activityOrder.add(activity[2]);
                    jamieActivities.add(new Activity(start, end));
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        return isPossible ? assignment.toString() : "IMPOSSIBLE";
    }

    private static boolean isOverlapping(Activity activity, int start, int end) {
        return (start < activity.end && end > activity.start);
    }
}