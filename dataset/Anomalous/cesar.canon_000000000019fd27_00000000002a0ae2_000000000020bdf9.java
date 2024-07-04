import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int cases = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < cases; i++) {
            int activitiesCount = Integer.parseInt(reader.readLine());
            ArrayList<Activity> activities = new ArrayList<>();
            
            for (int j = 0; j < activitiesCount; j++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities.add(new Activity(start, end, j + 1));
            }
            
            Collections.sort(activities, new StartTimeComparator());
            
            int currentTime = 0;
            boolean assigned = true;
            
            while (assigned) {
                assigned = false;
                
                for (Activity activity : activities) {
                    if (activity.isAssigned() || activity.getStart() < currentTime) continue;
                    activity.setAssigned(true);
                    currentTime = activity.getEnd();
                    assigned = true;
                    activity.setPerson("C");
                }
            }
            
            currentTime = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.isAssigned() || activity.getStart() < currentTime) {
                    possible = false;
                    break;
                }
                currentTime = activity.getEnd();
                activity.setPerson("J");
            }
            
            if (possible) {
                Collections.sort(activities, new OriginalOrderComparator());
                StringBuilder result = new StringBuilder("Case #" + (i + 1) + ": ");
                for (Activity activity : activities) {
                    result.append(activity.getPerson());
                }
                System.out.println(result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}

class Activity {
    private final int start;
    private final int end;
    private final int originalOrder;
    private String person;
    private boolean assigned;

    public Activity(int start, int end, int originalOrder) {
        this.start = start;
        this.end = end;
        this.originalOrder = originalOrder;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getOriginalOrder() {
        return originalOrder;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
}

class StartTimeComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.getStart(), a2.getStart());
    }
}

class OriginalOrderComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.getOriginalOrder(), a2.getOriginalOrder());
    }
}