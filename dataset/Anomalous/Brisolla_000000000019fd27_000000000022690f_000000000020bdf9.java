import java.util.*;

public class ParentingPartneringReturns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();

        for (int caseNum = 1; caseNum <= caseCount; caseNum++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(activities);

            StringBuilder result = new StringBuilder();
            int jamieFreeAt = 0;
            int cameronFreeAt = 0;

            for (Activity activity : activities) {
                if (activity.start >= jamieFreeAt) {
                    result.append('J');
                    jamieFreeAt = activity.end;
                } else if (activity.start >= cameronFreeAt) {
                    result.append('C');
                    cameronFreeAt = activity.end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                result = normalizeActivities(activities, result.toString());
            }

            System.out.printf("Case #%d: %s\n", caseNum, result);
        }
    }

    private static StringBuilder normalizeActivities(List<Activity> activities, String result) {
        char[] normalizedResult = new char[activities.size()];

        for (int i = 0; i < activities.size(); i++) {
            normalizedResult[activities.get(i).originalIndex] = result.charAt(i);
        }

        return new StringBuilder(new String(normalizedResult));
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int originalIndex;

    Activity(int start, int end, int originalIndex) {
        this.start = start;
        this.end = end;
        this.originalIndex = originalIndex;
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