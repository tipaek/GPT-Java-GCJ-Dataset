import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);

        int T = scanIn.nextInt();
        String[] results = new String[T];

        for (int x=0; x<T; x++) {
            int N = scanIn.nextInt();

            Activity[] activities = new Activity[N];
            boolean impossible = false;

            for (int i=0; i<N; i++) {
                int start = scanIn.nextInt();
                int end = scanIn.nextInt();
                Activity currentActivity = new Activity();
                currentActivity.start = start;
                currentActivity.end = end;
                activities[i] = currentActivity;
            }

            for (int i=0; i<N; i++) {
                if (!isBusy('C', activities[i].start, activities[i].end, activities)) {
                    activities[i].person = 'C';
                } else if (!isBusy('J', activities[i].start, activities[i].end, activities)) {
                    activities[i].person = 'J';
                } else {
                    //both busy
                    impossible = true;
                    break;
                }
            }

            if (impossible) results[x] = "IMPOSSIBLE";
            else {
                String rtn = "";
                for (int i=0; i<N; i++) {
                    rtn += activities[i].person;
                }
                results[x] = rtn;
            }
        }

        for (int x=1; x<=T; x++) {
            System.out.printf("Case #%d: %s\n", x, results[x-1]);
        }
    }

    public static boolean isBusy(Character initial, int start, int end, Activity[] allActivities) {
        for (int i=0; i<allActivities.length; i++) {
            if (allActivities[i].person != initial) continue;
            if (start > allActivities[i].start && start < allActivities[i].end) return true;
            if (end > allActivities[i].start && end < allActivities[i].end) return true;
        }
        return false;
    }

    static class Activity {
        Character person;
        int start;
        int end;
    }
}
