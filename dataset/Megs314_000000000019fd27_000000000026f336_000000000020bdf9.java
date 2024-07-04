import java.util.Arrays;
import java.util.Comparator;
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
            int recoveryPoint = -1;
            for (int i=0; i<N; i++) {
                boolean Cbusy = isBusy('C', activities[i].start, activities[i].end, activities);
                boolean Jbusy = isBusy('J', activities[i].start, activities[i].end, activities);
                if (activities[i].person != null) {
                    //do nothing as already set
                }
                else if (!Cbusy && !Jbusy) {
                    recoveryPoint = i;
                    activities[i].person = 'C';
                }
                else if (!Cbusy) {
                    activities[i].person = 'C';
                } else if (!Jbusy) {
                    activities[i].person = 'J';
                } else {
                    //both busy
                    if (recoveryPoint == -1) {
                        impossible = true;
                        break;
                    } else {
                        for (int j = 0; j < N; j++) {
                           activities[i].person = null;
                        }
                        activities[recoveryPoint].person = 'J';
                        i = -1;
                        recoveryPoint = -1;
                    }
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
            if (allActivities[i].person == initial) {
                if (start > allActivities[i].start && start < allActivities[i].end) return true;
                if (end > allActivities[i].start && end < allActivities[i].end) return true;
            }
        }
        return false;
    }

    static class Activity {
        Character person;
        int start;
        int end;
    }

    static class SortByStart implements Comparator<Activity> {
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.start - o2.start;
        }
    }
}
