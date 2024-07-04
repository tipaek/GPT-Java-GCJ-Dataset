import java.util.*;

/**
 * Solution
 */
class Activity implements Comparable<Activity> {
    int start, end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
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
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            processTestCase(caseNum);
        }
    }

    private static void processTestCase(long caseNum) {
        int numActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end));
        }

        Collections.sort(activities);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numActivities - 2; i++) {
            Activity current = activities.get(i);
            Activity nextNext = activities.get(i + 2);

            if (current.end > nextNext.end) {
                result.append("IMPOSSIBLE");
                break;
            } else {
                result.append(i % 2 == 0 ? "C" : "J");
            }
        }

        if (!result.toString().contains("IMPOSSIBLE")) {
            if (result.length() % 2 == 0) {
                result.append("CJ");
            } else {
                result.append("JC");
            }
        }

        System.out.println("Case #" + caseNum + ": " + result);
    }
}