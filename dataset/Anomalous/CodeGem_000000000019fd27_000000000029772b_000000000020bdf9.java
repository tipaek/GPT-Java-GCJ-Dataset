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
            return Integer.compare(this.end, other.end);
        }
    }

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Activity> originalActivities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);
                activities.add(activity);
                originalActivities.add(activity);
            }

            Collections.sort(activities);

            List<Activity> cameronActivities = new ArrayList<>();
            List<Activity> jamieActivities = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (cameronActivities.isEmpty() || cameronActivities.get(cameronActivities.size() - 1).end <= activity.start) {
                    cameronActivities.add(activity);
                    activity.assignedTo = "C";
                } else if (jamieActivities.isEmpty() || jamieActivities.get(jamieActivities.size() - 1).end <= activity.start) {
                    jamieActivities.add(activity);
                    activity.assignedTo = "J";
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (Activity activity : originalActivities) {
                    result.append(activity.assignedTo);
                }
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            }

            caseNumber++;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}