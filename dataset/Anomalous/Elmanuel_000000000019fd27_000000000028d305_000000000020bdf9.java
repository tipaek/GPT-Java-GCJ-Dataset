import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            System.out.println("Case #" + t + ": " + assignActivities(activities, N));
        }
        scanner.close();
    }

    private static String assignActivities(List<Activity> activities, int N) {
        activities.sort(Comparator.comparingInt(a -> a.start));
        String[] result = new String[N];
        List<Activity> cameron = new ArrayList<>();
        List<Activity> jamie = new ArrayList<>();

        for (Activity activity : activities) {
            if (cameron.isEmpty() || activity.start >= cameron.get(cameron.size() - 1).end) {
                cameron.add(activity);
                result[activity.index] = "C";
            } else if (jamie.isEmpty() || activity.start >= jamie.get(jamie.size() - 1).end) {
                jamie.add(activity);
                result[activity.index] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", result);
    }

    static class Activity {
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