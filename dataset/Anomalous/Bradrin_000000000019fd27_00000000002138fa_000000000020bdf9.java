import java.util.*;

public class Solution {

    static class Activity {
        int start;
        int end;
        int id;

        Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }

    static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return Integer.compare(a1.start, a2.start);
        }
    }

    private void solve(Scanner scanner) {
        int n = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();
        List<Activity> originalActivities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Activity activity = new Activity(scanner.nextInt(), scanner.nextInt(), i);
            activities.add(activity);
            originalActivities.add(activity);
        }

        activities.sort(new ActivityComparator());

        int[] timeSlots = new int[24 * 60];
        char[] result = new char[n];
        Arrays.fill(result, 'J'); // Default all to 'J' initially

        int currentTime = 0;
        for (Activity activity : activities) {
            int index = Collections.binarySearch(activities, new Activity(currentTime, 0, 0), new ActivityComparator());
            if (index < 0) {
                index = -index - 1;
            }
            if (index == n) {
                break;
            }
            activity = activities.get(index);
            result[activity.id] = 'C';
            for (int i = activity.start; i < activity.end; i++) {
                timeSlots[i]++;
            }
            currentTime = activity.end;
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == 'J') {
                Activity activity = originalActivities.get(i);
                for (int j = activity.start; j < activity.end; j++) {
                    if (timeSlots[j] == 2) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                    timeSlots[j]++;
                }
            }
        }

        System.out.println(new String(result));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int count = 1; count <= testCases; count++) {
            System.out.print("Case #" + count + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}