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

    public static ArrayList<Integer> taskOrder;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {

            int numberOfActivities = scanner.nextInt();
            Integer[][] activities = new Integer[numberOfActivities][3];
            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                activities[activityIndex][0] = scanner.nextInt();
                activities[activityIndex][1] = scanner.nextInt();
                activities[activityIndex][2] = activityIndex;
            }

            int attemptCount = 0;
            String result = "IMPOSSIBLE";
            boolean foundSolution = false;
            while (!foundSolution) {
                Collections.shuffle(Arrays.asList(activities));
                taskOrder = new ArrayList<>();
                result = generateSchedule(activities);
                if (attemptCount > numberOfActivities * 1.5) foundSolution = true;
                if (!result.equals("IMPOSSIBLE")) foundSolution = true;
                attemptCount++;
            }
            if (!result.equals("IMPOSSIBLE")) {
                char[] resultArray = result.toCharArray();
                char[] orderedResult = new char[resultArray.length];
                for (int i = 0; i < resultArray.length; i++) {
                    orderedResult[taskOrder.get(i)] = resultArray[i];
                }
                result = String.valueOf(orderedResult);
            }
            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
    }

    public static String generateSchedule(Integer[][] activities) {
        ArrayList<Activity> cameronActivities = new ArrayList<>();
        ArrayList<Activity> jamieActivities = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();
        boolean isPossible = true;

        for (Integer[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            boolean canAssignToCameron = canAssignActivity(cameronActivities, start, end);
            if (canAssignToCameron) {
                schedule.append("C");
                taskOrder.add(activity[2]);
                cameronActivities.add(new Activity(start, end));
            } else {
                boolean canAssignToJamie = canAssignActivity(jamieActivities, start, end);
                if (canAssignToJamie) {
                    schedule.append("J");
                    taskOrder.add(activity[2]);
                    jamieActivities.add(new Activity(start, end));
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        return isPossible ? schedule.toString() : "IMPOSSIBLE";
    }

    private static boolean canAssignActivity(ArrayList<Activity> activities, int start, int end) {
        for (Activity activity : activities) {
            if ((start >= activity.start && start < activity.end) ||
                (end > activity.start && end <= activity.end) ||
                (start <= activity.start && end >= activity.end)) {
                return false;
            }
        }
        return true;
    }
}