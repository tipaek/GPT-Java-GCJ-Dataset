import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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
            boolean isSolved = false;
            while (!isSolved) {
                Collections.shuffle(Arrays.asList(activities));
                taskOrder = new ArrayList<>();
                result = getSchedule(activities);
                if (attemptCount > numberOfActivities * 15) isSolved = true;
                if (!result.equals("IMPOSSIBLE")) isSolved = true;
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

    public static String getSchedule(Integer[][] activities) {
        ArrayList<Activity> cameronActivities = new ArrayList<>();
        ArrayList<Activity> jamieActivities = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();
        boolean isPossible = true;

        for (Integer[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            boolean canAssignToCameron = true;

            for (Activity act : cameronActivities) {
                if ((end > act.start && end < act.end) || (start > act.start && start < act.end) || (start < act.start && end > act.end)) {
                    canAssignToCameron = false;
                    break;
                }
            }

            if (canAssignToCameron) {
                schedule.append("C");
                taskOrder.add(activity[2]);
                cameronActivities.add(new Activity(start, end));
            } else {
                boolean canAssignToJamie = true;
                for (Activity act : jamieActivities) {
                    if ((end > act.start && end < act.end) || (start > act.start && start < act.end) || (start < act.start && end > act.end)) {
                        canAssignToJamie = false;
                        break;
                    }
                }
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
}