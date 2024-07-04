import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        for (int n = 0; n < numCases; n++) {
            int activities = input.nextInt();
            List<Activity> cameron = new ArrayList<>(activities);
            List<Activity> jamie = new ArrayList<>(activities);
            StringBuilder sb = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < activities; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                Activity activity = new Activity(start, end);

                if (assignActivity(activity, cameron)) {
                    sb.append('C');
                } else if (assignActivity(activity, jamie)) {
                    sb.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.printf("Case #%d: ", n + 1);
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(sb.toString());
            }
        }
    }

    static boolean assignActivity(Activity activity, List<Activity> schedule) {
        for (int i = 0; i < schedule.size(); i++) {
            Activity current = schedule.get(i);
            if (activity.getEnd() <= current.getStart()) {
                schedule.add(i, activity);
                return true;
            }
        }
        if (schedule.isEmpty() || schedule.get(schedule.size() - 1).getEnd() <= activity.getStart()) {
            schedule.add(activity);
            return true;
        }
        return false;
    }

    static class Activity {
        private final int start;
        private final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }
    }
}