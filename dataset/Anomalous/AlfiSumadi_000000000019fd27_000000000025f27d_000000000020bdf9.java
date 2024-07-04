import java.util.*;

class Activity implements Comparable<Activity> {
    int start, end, index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long testCases = scanner.nextLong();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            processTestCase(testCase);
        }
    }

    private static void processTestCase(long testCaseNumber) {
        int numActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end, i));
        }

        Collections.sort(activities);

        char[] schedule = new char[numActivities];
        boolean isImpossible = false;
        Activity cActivity = null, jActivity = null;

        for (Activity activity : activities) {
            if (cActivity == null) {
                cActivity = activity;
                schedule[activity.index] = 'C';
            } else if (jActivity == null) {
                jActivity = activity;
                schedule[activity.index] = 'J';
            } else {
                if (activity.start >= cActivity.end) {
                    cActivity = activity;
                    schedule[activity.index] = 'C';
                } else if (activity.start >= jActivity.end) {
                    jActivity = activity;
                    schedule[activity.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCaseNumber + ": " + new String(schedule));
        }
    }
}