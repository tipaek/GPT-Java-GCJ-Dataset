import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            Collections.sort(activities);

            StringBuilder result = new StringBuilder();
            int jamieEnd = 0, cameronEnd = 0;

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    result.append("C");
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    result.append("J");
                    jamieEnd = activity.end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", caseNum, result);
        }
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "[" + start + " - " + end + "]";
    }
}