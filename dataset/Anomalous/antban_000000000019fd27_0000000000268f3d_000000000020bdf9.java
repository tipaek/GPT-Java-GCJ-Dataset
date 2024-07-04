import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Activity {
        private final int start;
        private final int end;
        private Activity next;
        private String responsible;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }
    }

    public static String getSolution(List<Activity> activities) {
        // Link activities in their original order
        for (int i = 0; i < activities.size() - 1; i++) {
            activities.get(i).next = activities.get(i + 1);
        }
        Activity current = activities.get(0);

        // Sort activities by start time
        activities.sort(Comparator.comparing(Activity::getStart));

        int cTime = 0;
        int jTime = 0;

        for (Activity activity : activities) {
            if (cTime <= activity.start) {
                cTime = activity.end;
                activity.responsible = "C";
            } else if (jTime <= activity.start) {
                jTime = activity.end;
                activity.responsible = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        // Build the result string based on original order
        StringBuilder result = new StringBuilder();
        while (current != null) {
            result.append(current.responsible);
            current = current.next;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            int timeCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(timeCount);
            for (int i = 0; i < timeCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }
            System.out.println("Case #" + test + ": " + getSolution(activities));
        }
    }
}