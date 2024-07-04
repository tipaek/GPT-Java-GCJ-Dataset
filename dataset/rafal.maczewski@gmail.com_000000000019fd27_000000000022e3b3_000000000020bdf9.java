import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(i, in);
        }
    }

    public static class Activity {
        int start;
        int end;
        char who;
//        int idx;
    }

    public static class ActivityList {
        List<Activity> start = new ArrayList<>();
        List<Activity> end = new ArrayList<>();


    }

    private static void solve(int caseNr, Scanner in) {

        int n = in.nextInt();
        List<Activity> list = new ArrayList<>();

        TreeMap<Integer, ActivityList> tree = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            Activity a = new Activity();
            a.start = in.nextInt();
            a.end = in.nextInt();
            list.add(a);

            ActivityList activityList = tree.get(a.start);
            if (activityList == null) {
                activityList = new ActivityList();
                tree.put(a.start, activityList);
            }
            activityList.start.add(a);

            activityList = tree.get(a.end);
            if (activityList == null) {
                activityList = new ActivityList();
                tree.put(a.end, activityList);
            }
            activityList.end.add(a);
        }

        boolean jBusy = false;
        boolean cBusy = false;
        boolean impossible = false;
        for (Integer time : tree.keySet()) {
            ActivityList activityList = tree.get(time);
            if (activityList.end.size() > 0) {
                for (int i = 0; i < activityList.end.size(); i++) {
                    Activity activity =  activityList.end.get(i);
                    if (activity.who == 'J') {
                        if (!jBusy) throw new RuntimeException("Error 1");
                        jBusy = false;
                    } else if (activity.who == 'C') {
                        if (!cBusy) throw new RuntimeException("Error 2");
                        cBusy = false;
                    }
                }
            }
            if (activityList.start.size() > 0) {
                for (int i = 0; i < activityList.start.size(); i++) {
                    Activity activity =  activityList.start.get(i);
                    if (!cBusy) {
                        activity.who = 'C';
                        cBusy = true;
                    } else if (!jBusy) {
                        activity.who = 'J';
                        jBusy = true;
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }
            if (impossible) break;
        }

        if (impossible) {
            System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
        } else {
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                buf.append(list.get(i).who);
            }
            System.out.println("Case #" + caseNr + ": "+ buf);
        }

    }
}