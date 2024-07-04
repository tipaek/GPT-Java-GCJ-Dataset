import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= numberOfTestCases; testCaseNumber++) {
            int numberOfActivities = scanner.nextInt();

            List<Activity> activityList = new ArrayList<>();

            for (int j = 0; j < numberOfActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activityList.add(new Activity(start, end));
            }

            String answer = solve(activityList);
            System.out.printf("Case #%d: %s\n", testCaseNumber, answer);
        }
    }

    private static String solve(List<Activity> activityList) {
        Parent cameron = new Parent();
        Parent jamie = new Parent();

        String assignResult1 = assign(cameron, jamie, "C", activityList, 0);
        String assignResult2 = assign(cameron, jamie, "J", activityList, 0);

        if (!assignResult1.equals("IMPOSSIBLE")) {
            return assignResult1;
        }

        if (!assignResult2.equals("IMPOSSIBLE")) {
            return assignResult2;
        }

        return "IMPOSSIBLE";
    }

    private static String assign(Parent cameron, Parent jamie, String s, List<Activity> activityList, int i) {
        if (i == activityList.size()) {
            return "";
        }

        boolean assignSuccessfully = s.equals("C")
                ? cameron.assign(activityList.get(i))
                : jamie.assign(activityList.get(i));

        if (assignSuccessfully) {
            String assignResult1 = assign(cameron, jamie, "C", activityList, i + 1);
            String assignResult2 = assign(cameron, jamie, "J", activityList, i + 1);

            if (!assignResult1.equals("IMPOSSIBLE")) {
                return s + assignResult1;
            }

            if (!assignResult2.equals("IMPOSSIBLE")) {
                return s + assignResult2;
            }
        }

        return "IMPOSSIBLE";
    }
}

class Activity {
    private int start;
    private int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean isOverlapWith(Activity anotherActivity) {
        return this.start < anotherActivity.end && this.end > anotherActivity.start;
    }
}

class Parent {
    private List<Activity> activities;

    Parent() {
        this.activities = new ArrayList<>();
    }

    boolean assign(Activity newActivity) {
        for (Activity activity : activities) {
            if (activity.isOverlapWith(newActivity)) {
                return false;
            }
        }

        activities.add(newActivity);
        return true;
    }
}