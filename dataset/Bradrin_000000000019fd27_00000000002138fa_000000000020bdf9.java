import java.util.*;

public class Solution {

    class Activity {
        int a;
        int b;
        int id;

        Activity(int a, int b, int id) {
            this.a = a;
            this.b = b;
            this.id = id;
        }
    }

    class ActivityComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity a, Activity b) {
            return a.a - b.a;
        }
    }

    private void solve(Scanner scan) {
        int n = scan.nextInt();
        List<Activity> activities = new ArrayList<>();
        List<Activity> orig = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Activity activity = new Activity(scan.nextInt(), scan.nextInt(), i);
            activities.add(activity);
            orig.add(activity);
        }

        ActivityComparator comparator = new ActivityComparator();
        activities.sort(comparator);

        int[] array = new int[24 * 60];
        char[] result = new char[n];

        int end = 0;
        while (true) {
            int index = Collections.binarySearch(activities, new Activity(end, 0, 0), comparator);
            if (index < 0) {
                index = -index - 1;
            }
            if (index == n) {
                break;
            }
            Activity activity = activities.get(index);
            result[activity.id] = 'C';
            for (int i = activity.a; i < activity.b; i++) {
                array[i]++;
            }
            end = activity.b;
        }

        for (int i = 0; i < n; i++) {
            if (result[i] != 'C') {
                result[i] = 'J';
                Activity activity = orig.get(i);
                for (int j = activity.a; j < activity.b; j++) {
                    if (array[j] == 2) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                    array[j]++;
                }
            }
        }

        System.out.println(new String(result));


    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
