import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        aaaaa:
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            TreeMap<Integer, List<Activity>> activityMap = new TreeMap<>();
            for (int actv = 0; actv < n; actv++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Activity activity = new Activity();
                activity.id = actv;
                activity.start = start;
                activity.end = end;
                if (!activityMap.containsKey(start)) {
                    activityMap.put(start, new ArrayList<>());
                }
                if (!activityMap.containsKey(end)) {
                    activityMap.put(end, new ArrayList<>());
                }
                activityMap.get(start).add(activity);
                activityMap.get(end).add(activity);
            }
            boolean CBusy = false;
            boolean JBusy = false;
            for (Integer key : activityMap.navigableKeySet()) {
                List<Activity> activities = activityMap.get(key);
                if (activities.size() > 1) {
                    Activity startActivity = activities.get(0);
                    Activity endActivity = activities.get(0);
                    if (key.intValue() == activities.get(0).end) {
                        startActivity = activities.get(1);
                    }
                    else {
                        endActivity = activities.get(1);
                    }
                    // process first the end activity
                    if (endActivity.parent == 'C') {
                        CBusy = false;
                    }
                    else {
                        JBusy = false;
                    }
                    // now the start activity
                    if (!CBusy) {
                        CBusy = true;
                        startActivity.parent = 'C';
                    }
                    else if (!JBusy) {
                        JBusy = true;
                        startActivity.parent = 'J';
                    }
                    else {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        continue aaaaa;
                    }
                }
                else {
                    Activity activity = activities.get(0);
                    if (activity.start == key.intValue()) {
                        if (!CBusy) {
                            CBusy = true;
                            activity.parent = 'C';
                        }
                        else if (!JBusy) {
                            JBusy = true;
                            activity.parent = 'J';
                        }
                        else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            continue aaaaa;
                        }
                    }
                    else {
                        if (activity.parent == 'C') {
                            CBusy = false;
                        }
                        else {
                            JBusy = false;
                        }
                    }

                }
            }
            Set<Activity> activitiesSet = new HashSet<>();
            for (List<Activity> activities : activityMap.values()) {
                activitiesSet.addAll(activities);
            }
            List<Activity> allActivities = new ArrayList<>(activitiesSet);
            allActivities.sort((Activity a1, Activity a2) -> a1.id - a2.id);
            StringBuffer schedule = new StringBuffer();
            for (Activity activity : allActivities) {
                schedule.append(activity.parent);
            }
            System.out.println("Case #" + i + ": " + schedule.toString());
        }
    }

    static class Activity {
        int id = 0;
        int start = 0;
        int end = 0;
        char parent = 'x';
    }
}

