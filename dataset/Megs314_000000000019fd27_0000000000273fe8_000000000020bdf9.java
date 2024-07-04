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

            for (int i = 0; i < N; i++) {
                int start = scanIn.nextInt();
                int end = scanIn.nextInt();
                Activity currentActivity = new Activity();
                currentActivity.start = start;
                currentActivity.end = end;
                activities[i] = currentActivity;
            }
            //solve1(activities, results, x);
            solve2(activities,results,x);
        }
        for (int y=1; y<=results.length; y++) {
            System.out.printf("Case #%d: %s\n", y, results[y-1]);
        }
    }

    public static void solve2(Activity[] activities, String[] results, int x) {
        boolean impossible = false;
        for (int i=0; i<activities.length; i++) {
            if (activities[i].person != null) {
                // do nothing as already assigned
            } else {
                int overlap = checkOverlap(activities, activities[i], i);
                if (overlap == -1) {
                } //no overlap so leave for now
                else {
                    boolean Cbusy = isBusy('C', activities[i].start, activities[i].end, activities);
                    boolean Jbusy = isBusy('J', activities[i].start, activities[i].end, activities);
                    if (!Cbusy && !Jbusy) {

                        boolean Cbusy2 = isBusy('C', activities[overlap].start, activities[overlap].end, activities);
                        boolean Jbusy2 = isBusy('J', activities[overlap].start, activities[overlap].end, activities);
                        if (!Cbusy2 && !Jbusy2) {
                            activities[i].person = 'C';
                            activities[overlap].person = 'J';
                        } else if (!Cbusy2) {
                            activities[i].person = 'J';
                            activities[overlap].person = 'C';
                        } else if (!Jbusy2) {
                            activities[i].person = 'C';
                            activities[overlap].person = 'J';
                        } else {
                            //both busy
                            impossible = true;
                            break;
                        }

                    } else if (!Cbusy) {
                        activities[i].person = 'C';
                        if (isBusy('J', activities[overlap].start, activities[overlap].end, activities)) {
                            impossible = true;
                            break;
                        } else {
                            activities[overlap].person = 'J';
                        }
                    } else if (!Jbusy) {
                        activities[i].person = 'J';
                        if (isBusy('C', activities[overlap].start, activities[overlap].end, activities)) {
                            impossible = true;
                            break;
                        } else {
                            activities[overlap].person = 'C';
                        }
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }
        }

        for (int i=0; i<activities.length; i++) {
            boolean Cbusy = isBusy('C', activities[i].start, activities[i].end, activities);
            boolean Jbusy = isBusy('J', activities[i].start, activities[i].end, activities);
            if (activities[i].person != null) {
                //do nothing as already set
            }
            else if (!Cbusy && !Jbusy) {
                activities[i].person = 'C';
            }
            else if (!Cbusy) {
                activities[i].person = 'C';
            } else if (!Jbusy) {
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
            for (int j=0; j<activities.length; j++) {
                rtn += activities[j].person;
            }
            results[x] = rtn;
        }

    }

    public static int checkOverlap(Activity[] activities, Activity activity, int index) {
        for (int i=index+1; i<activities.length; i++) {
            if (activity.start > activities[i].start && activity.start < activities[i].end) return i;
            if (activity.end > activities[i].start && activity.end < activities[i].end) return i;
        }
        return -1;
    }

    public static void solve1(Activity[] activities, String[] results, int x) {
        boolean impossible = false;
        int recoveryPoint = -1;
        for (int i=0; i<activities.length; i++) {
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
                    for (int j = 0; j < activities.length; j++) {
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
            for (int i=0; i<activities.length; i++) {
                rtn += activities[i].person;
            }
            results[x] = rtn;
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
        Character person = null;
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
