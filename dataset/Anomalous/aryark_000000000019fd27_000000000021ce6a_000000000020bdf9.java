import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            ArrayList<Activity> cameronActivities = new ArrayList<>();
            ArrayList<Activity> jamieActivities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);

                if (!isPossible) continue;

                if (i == 0) {
                    cameronActivities.add(activity);
                    schedule.append("C");
                } else {
                    if (doesActivityOverlap(activity, cameronActivities)) {
                        if (jamieActivities.isEmpty()) {
                            jamieActivities.add(activity);
                            schedule.append("J");
                        } else {
                            if (doesActivityOverlap(activity, jamieActivities)) {
                                isPossible = false;
                            } else {
                                jamieActivities.add(activity);
                                schedule.append("J");
                            }
                        }
                    } else {
                        cameronActivities.add(activity);
                        schedule.append("C");
                    }
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (isPossible) {
                System.out.println(schedule.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private boolean doesActivityOverlap(Activity newActivity, ArrayList<Activity> existingActivities) {
        for (Activity activity : existingActivities) {
            if (newActivity.overlapsWith(activity)) {
                return true;
            }
        }
        return false;
    }

    private static class Activity {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Activity other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}