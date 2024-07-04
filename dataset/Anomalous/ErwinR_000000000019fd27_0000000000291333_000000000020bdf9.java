import java.util.*;

class Activity {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    private static List<Activity> activityJ;
    private static List<Activity> activityC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        for (int i = 0; i < testcases; i++) {
            int testcase = i + 1;
            StringBuilder output = new StringBuilder();
            activityJ = new ArrayList<>();
            activityC = new ArrayList<>();

            int n = sc.nextInt();
            int[][] schedule = new int[n][2];
            for (int k = 0; k < n; k++) {
                schedule[k][0] = sc.nextInt();
                schedule[k][1] = sc.nextInt();
            }

            for (int k = 0; k < n; k++) {
                String ret = scheduleActivity(schedule[k][0], schedule[k][1]);
                if (ret.equals("IMPOSSIBLE")) {
                    output = new StringBuilder(ret);
                    break;
                }
                output.append(ret);
            }

            System.out.println("Case #" + testcase + ": " + output);
        }

        sc.close();
    }

    private static String scheduleActivity(int start, int end) {
        if (isSchedulable(activityC, start, end)) {
            activityC.add(new Activity(start, end));
            return "C";
        }

        if (isSchedulable(activityJ, start, end)) {
            activityJ.add(new Activity(start, end));
            return "J";
        }

        return "IMPOSSIBLE";
    }

    private static boolean isSchedulable(List<Activity> activities, int start, int end) {
        for (Activity activity : activities) {
            if (end > activity.start && activity.end > start) {
                return false;
            }
        }
        return true;
    }
}