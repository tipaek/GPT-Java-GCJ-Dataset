
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Activity {
        private int start;
        private int end;
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
        for (int i = 0; i < activities.size() - 1; ++i) {
            activities.get(i).next = activities.get(i + 1);
        }
        Activity cur = activities.get(0);
        activities.sort(Comparator.comparing(Activity::getStart));
        int c = 0;
        int j = 0;
        for (Activity a : activities) {
            if (c <= a.start) {
                c = a.end;
                a.responsible = "C";
            } else if (j <= a.start) {
                j = a.end;
                a.responsible = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        final StringBuilder result = new StringBuilder();

        while (cur != null) {
            result.append(cur.responsible);
            cur = cur.next;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            final int timeCount = scanner.nextInt();
            final List<Activity> activities = new ArrayList<>(timeCount);
            for (int i = 0; i < timeCount; ++i) {
                final int start = scanner.nextInt();
                final int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }
            System.out.println("Case #" + test + ": " + getSolution(activities));
        }
    }

}
