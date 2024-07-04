import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bf.readLine());

        for (int i = 0; i < cases; i++) {
            boolean[] availableC = new boolean[1441];
            boolean[] availableJ = new boolean[1441];
            boolean isPossible = true;

            int activitiesCount = Integer.parseInt(bf.readLine());
            ArrayList<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                String[] times = bf.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities.add(new Activity(start, end, j + 1));
            }

            Collections.sort(activities, new ActivityStartComparator());

            for (Activity activity : activities) {
                boolean conflictC = false;
                boolean conflictJ = false;

                for (int k = activity.start; k < activity.end; k++) {
                    if (availableC[k]) {
                        conflictC = true;
                        break;
                    }
                }

                if (conflictC) {
                    for (int k = activity.start; k < activity.end; k++) {
                        if (availableJ[k]) {
                            conflictJ = true;
                            break;
                        }
                    }
                }

                if (!conflictC) {
                    for (int k = activity.start; k < activity.end; k++) {
                        availableC[k] = true;
                    }
                    activity.assignee = "C";
                } else if (!conflictJ) {
                    for (int k = activity.start; k < activity.end; k++) {
                        availableJ[k] = true;
                    }
                    activity.assignee = "J";
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Collections.sort(activities, new ActivityOrderComparator());
                StringBuilder result = new StringBuilder("Case #" + (i + 1) + ": ");
                for (Activity activity : activities) {
                    result.append(activity.assignee);
                }
                System.out.println(result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}

class Activity {
    int start, end, order;
    String assignee;

    public Activity(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }
}

class ActivityStartComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.start, a2.start);
    }
}

class ActivityOrderComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.order, a2.order);
    }
}