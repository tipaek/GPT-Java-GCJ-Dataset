import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            int cameronFreeAt = -1;
            int jamieFreeAt = -1;
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), j));
            }

            Collections.sort(activities);

            String result = "";
            for (Activity activity : activities) {
                if (activity.start >= cameronFreeAt) {
                    activity.assignedTo = "C";
                    cameronFreeAt = activity.end;
                } else if (activity.start >= jamieFreeAt) {
                    activity.assignedTo = "J";
                    jamieFreeAt = activity.end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = getFinalResult(activities);
            }

            System.out.printf("Case #%d: %s\n", i, result);
        }
    }

    private static String getFinalResult(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(a -> a.originalIndex));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.assignedTo);
        }
        return result.toString();
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int originalIndex;
    String assignedTo;

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