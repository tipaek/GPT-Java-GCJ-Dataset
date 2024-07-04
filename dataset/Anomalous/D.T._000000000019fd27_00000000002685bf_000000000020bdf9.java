import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int ks = 1; ks <= testCases; ks++) {
            int n = scanner.nextInt();
            processTestCase(ks, scanner, n);
        }
    }

    private static void processTestCase(int caseNumber, Scanner scanner, int n) {
        List<Activity> activities = new ArrayList<>();
        int[] cameronSchedule = new int[1440];
        int[] jamieSchedule = new int[1440];

        boolean isImpossible = false;
        for (int i = 0; i < n; i++) {
            Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
            activities.add(activity);

            if (isAvailable(activity, cameronSchedule)) {
                activity.setOwner("C");
            } else if (isAvailable(activity, jamieSchedule)) {
                activity.setOwner("J");
            } else {
                isImpossible = true;
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

    private static boolean isAvailable(Activity activity, int[] schedule) {
        for (int time = activity.getStart(); time < activity.getEnd(); time++) {
            if (schedule[time] == 1) {
                return false;
            }
        }
        for (int time = activity.getStart(); time < activity.getEnd(); time++) {
            schedule[time] = 1;
        }
        return true;
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