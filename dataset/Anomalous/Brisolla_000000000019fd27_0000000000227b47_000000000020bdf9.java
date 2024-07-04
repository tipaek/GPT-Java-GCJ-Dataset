import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            Collections.sort(activities);

            int cameronEnd = 0;
            int jamieEnd = 0;
            char[] result = new char[activitiesCount];
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    result[activity.originalIndex] = 'C';
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    result[activity.originalIndex] = 'J';
                    jamieEnd = activity.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %s\n", t, new String(result));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }
        scanner.close();
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