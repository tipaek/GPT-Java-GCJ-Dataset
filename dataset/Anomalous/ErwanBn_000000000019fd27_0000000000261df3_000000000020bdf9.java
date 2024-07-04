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

    public static List<Integer> restT;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numberOfCases = scanner.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = scanner.nextInt();
            Integer[][] activities = new Integer[numberOfActivities][3];
            for (int j = 0; j < numberOfActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }

            int attempts = 0;
            String result = "IMPOSSIBLE";
            boolean foundSolution = false;
            while (!foundSolution) {
                Collections.shuffle(Arrays.asList(activities));
                restT = new ArrayList<>();
                result = getSchedule(activities);
                if (attempts > numberOfActivities * 150 || !result.equals("IMPOSSIBLE")) {
                    foundSolution = true;
                }
                attempts++;
            }
            
            if (!result.equals("IMPOSSIBLE")) {
                char[] finalResult = new char[result.length()];
                for (int k = 0; k < result.length(); k++) {
                    finalResult[restT.get(k)] = result.charAt(k);
                }
                result = new String(finalResult);
            }
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    public static String getSchedule(Integer[][] activities) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        StringBuilder schedule = new StringBuilder();
        boolean isPossible = true;

        for (Integer[] activity : activities) {
            int start = activity[0];
            int end = activity[1];

            boolean canAssignToCameron = canAssignActivity(cameronActivities, start, end);
            if (canAssignToCameron) {
                schedule.append("C");
                restT.add(activity[2]);
                cameronActivities.add(new Activity(start, end));
            } else {
                boolean canAssignToJamie = canAssignActivity(jamieActivities, start, end);
                if (canAssignToJamie) {
                    schedule.append("J");
                    restT.add(activity[2]);
                    jamieActivities.add(new Activity(start, end));
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        return isPossible ? schedule.toString() : "IMPOSSIBLE";
    }

    private static boolean canAssignActivity(List<Activity> activities, int start, int end) {
        for (Activity activity : activities) {
            if ((start < activity.end && end > activity.start) || 
                (start < activity.start && end > activity.end)) {
                return false;
            }
        }
        return true;
    }
}