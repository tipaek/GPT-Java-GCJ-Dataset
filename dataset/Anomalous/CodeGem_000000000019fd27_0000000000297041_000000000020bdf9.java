import java.util.*;

public class Solution {

    class Activity implements Comparable<Activity> {
        int start, end;
        String assignedTo;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return this.end - other.end;
        }
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Activity> originalOrder = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Activity activity = new Activity(start, end);
                activities.add(activity);
                originalOrder.add(activity);
            }

            Collections.sort(activities);

            List<Activity> jActivities = new ArrayList<>();
            List<Activity> cActivities = new ArrayList<>();
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (jActivities.isEmpty() || jActivities.get(jActivities.size() - 1).end <= activity.start) {
                    jActivities.add(activity);
                    activity.assignedTo = "J";
                } else if (cActivities.isEmpty() || cActivities.get(cActivities.size() - 1).end <= activity.start) {
                    cActivities.add(activity);
                    activity.assignedTo = "C";
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                StringBuilder result = new StringBuilder();
                for (Activity activity : originalOrder) {
                    result.append(activity.assignedTo);
                }
                System.out.println("Case #" + caseNum + ": " + result.toString());
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}