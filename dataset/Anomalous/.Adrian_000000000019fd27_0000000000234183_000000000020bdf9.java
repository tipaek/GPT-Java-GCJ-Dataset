import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] parts = scanner.nextLine().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                activities.add(new Activity(start, end, i));
            }

            String result = assignActivities(activities);
            if (result == null) {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(a -> a.start));

        StringBuilder schedule = new StringBuilder("O".repeat(activities.size()));
        int endC = -1;
        int endJ = -1;

        for (Activity activity : activities) {
            if (activity.start >= endC) {
                endC = activity.end;
                schedule.setCharAt(activity.index, 'C');
            } else if (activity.start >= endJ) {
                endJ = activity.end;
                schedule.setCharAt(activity.index, 'J');
            } else {
                return null;
            }
        }

        return schedule.toString();
    }

    private static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}