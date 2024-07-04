import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void solve(int caseNumber, Scanner scanner, int activityCount) {
        List<Activity> activities = new ArrayList<>();
        int[] cameronSchedule = new int[1440];
        int[] jamieSchedule = new int[1440];
        boolean isImpossible = false;

        for (int i = 0; i < activityCount; i++) {
            Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
            activities.add(activity);

            if (isTimeSlotAvailable(activity, cameronSchedule)) {
                activity.setOwner("C");
            } else if (isTimeSlotAvailable(activity, jamieSchedule)) {
                activity.setOwner("J");
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            StringBuilder result = new StringBuilder();
            for (Activity activity : activities) {
                result.append(activity.getOwner());
            }
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static boolean isTimeSlotAvailable(Activity activity, int[] schedule) {
        for (int i = activity.getStart(); i < activity.getEnd(); i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }

        for (int i = activity.getStart(); i < activity.getEnd(); i++) {
            schedule[i] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            solve(caseNumber, scanner, activityCount);
        }
    }

    public static class Activity {
        private final int start;
        private final int end;
        private String owner;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}