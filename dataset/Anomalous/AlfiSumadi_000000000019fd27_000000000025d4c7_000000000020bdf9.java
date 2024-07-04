import java.util.*;

/**
 * Solution
 */
class Activity implements Comparable<Activity> {
    public int start, end, index;

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
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long testCases = scanner.nextLong();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            solve(testCase);
        }
    }

    private static void solve(long testCaseNumber) {
        int numberOfActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end, i));
        }

        Collections.sort(activities); // sort based on start time

        char[] schedule = new char[numberOfActivities];
        boolean isImpossible = false;

        for (int i = 0; i < numberOfActivities - 2; i++) {
            Activity currentActivity = activities.get(i);
            Activity nextActivity = activities.get(i + 2);

            if (currentActivity.end > nextActivity.end) {
                isImpossible = true;
                break;
            } else {
                schedule[currentActivity.index] = (i % 2 == 0) ? 'C' : 'J';
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        } else {
            if (numberOfActivities % 2 == 0) {
                schedule[activities.get(numberOfActivities - 2).index] = 'C';
                schedule[activities.get(numberOfActivities - 1).index] = 'J';
            } else {
                schedule[activities.get(numberOfActivities - 2).index] = 'J';
                schedule[activities.get(numberOfActivities - 1).index] = 'C';
            }
            System.out.println("Case #" + testCaseNumber + ": " + new String(schedule));
        }
    }
}