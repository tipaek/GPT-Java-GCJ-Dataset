import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> cActivities = new ArrayList<>();
            List<Activity> jActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int a = 0; a < activityCount; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignC = isAssignable(start, end, cActivities);

                if (canAssignC) {
                    cActivities.add(new Activity(start, end));
                    schedule.append("C");
                } else {
                    boolean canAssignJ = isAssignable(start, end, jActivities);
                    if (canAssignJ) {
                        jActivities.add(new Activity(start, end));
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + schedule.toString());
            }
        }
    }

    private static boolean isAssignable(int start, int end, List<Activity> activities) {
        for (Activity activity : activities) {
            if (activity.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(int start, int end) {
            return !(end <= this.start || start >= this.end);
        }
    }
}