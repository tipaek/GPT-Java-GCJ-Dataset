import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            boolean isPossible = true;

            int activityCount = Integer.parseInt(reader.readLine());
            ArrayList<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities.add(new Activity(start, end, j + 1));
            }

            Collections.sort(activities, new ActivityDurationComparator());

            for (Activity activity : activities) {
                boolean cameronConflict = false;
                boolean jamieConflict = false;

                for (int k = activity.start; k <= activity.end; k++) {
                    if (cameronSchedule[k] && k != activity.start && k != activity.end) {
                        cameronConflict = true;
                        for (int l = k - 1; l >= activity.start; l--) cameronSchedule[l] = false;
                        break;
                    } else {
                        cameronSchedule[k] = true;
                    }
                }

                if (cameronConflict) {
                    for (int k = activity.start; k <= activity.end; k++) {
                        if (jamieSchedule[k] && k != activity.start && k != activity.end) {
                            jamieConflict = true;
                            for (int l = k - 1; l >= activity.start; l--) cameronSchedule[l] = false;
                            break;
                        } else {
                            jamieSchedule[k] = true;
                        }
                    }
                }

                if (!cameronConflict) {
                    activity.assignedPerson = "C";
                } else if (!jamieConflict) {
                    activity.assignedPerson = "J";
                } else {
                    isPossible = false;
                }
            }

            if (isPossible) {
                Collections.sort(activities, new ActivityIndexComparator());
                StringBuilder result = new StringBuilder("Case #" + (i + 1) + ": ");
                for (Activity activity : activities) {
                    result.append(activity.assignedPerson);
                }
                System.out.println(result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}

class Activity {
    int start, end, index;
    String assignedPerson;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getDuration() {
        return end - start;
    }
}

class ActivityDurationComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return a2.getDuration() - a1.getDuration();
    }
}

class ActivityIndexComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return a1.index - a2.index;
    }
}