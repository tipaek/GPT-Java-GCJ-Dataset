import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(bufferedReader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            boolean[] cameronSchedule = new boolean[1440];
            boolean[] jamieSchedule = new boolean[1440];
            boolean isPossible = true;
            
            int activitiesCount = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Activity> activities = new ArrayList<>();
            
            for (int j = 0; j < activitiesCount; j++) {
                String[] timeLimits = bufferedReader.readLine().split(" ");
                int startTime = Integer.parseInt(timeLimits[0]);
                int endTime = Integer.parseInt(timeLimits[1]);
                activities.add(new Activity(startTime, endTime, j + 1));
            }
            
            Collections.sort(activities, new ActivityStartComparator());
            
            for (Activity activity : activities) {
                boolean cameronConflict = false;
                boolean jamieConflict = false;
                
                for (int t = activity.start; t < activity.end; t++) {
                    if (cameronSchedule[t]) {
                        cameronConflict = true;
                        break;
                    }
                }
                
                if (cameronConflict) {
                    for (int t = activity.start; t < activity.end; t++) {
                        if (jamieSchedule[t]) {
                            jamieConflict = true;
                            break;
                        }
                    }
                }
                
                if (!cameronConflict) {
                    for (int t = activity.start; t < activity.end; t++) {
                        cameronSchedule[t] = true;
                    }
                    activity.assignedPerson = "C";
                } else if (!jamieConflict) {
                    for (int t = activity.start; t < activity.end; t++) {
                        jamieSchedule[t] = true;
                    }
                    activity.assignedPerson = "J";
                } else {
                    isPossible = false;
                    break;
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
}

class ActivityStartComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.start, a2.start);
    }
}

class ActivityIndexComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.index, a2.index);
    }
}