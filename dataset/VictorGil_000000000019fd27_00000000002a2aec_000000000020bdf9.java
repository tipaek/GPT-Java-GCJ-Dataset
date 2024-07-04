import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Victor Gil
 *
 * since April 2020
 */
class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int numOfActivities = scanner.nextInt();
                List<Activity> activities = new ArrayList<Activity>(numOfActivities);

                for (int i = 0; i < numOfActivities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    activities.add(new Activity(start, end, i));
                }

                String result = calculate(activities);
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
    }

    static String calculate(List<Activity> activities) {
        if (activities.size() == 2) {
            return "CJ";
        }

        Collections.sort(activities);

        Ongoing ongoing = new Ongoing();
        for (Activity activity : activities) {
            if (!ongoing.add(activity)) {
                return "IMPOSSIBLE";
            }
        }

        Collections.sort(activities,  new OriginalOrder());
        StringBuilder sb = new StringBuilder();
        for (Activity activity : activities) {
            sb.append(activity.owner);
        }
        return sb.toString();
    }
}


class Ongoing {
    private Set<Activity> cActivities = new HashSet<Activity>();
    private Set<Activity> jActivities = new HashSet<Activity>();

    boolean add(Activity activity) {
        remove(activity.start);

        if (cActivities.size() == 0) {
            activity.owner = 'C';
            this.cActivities.add(activity);
            return true;
        }

        if (jActivities.size() == 0) {
            activity.owner = 'J';
            this.jActivities.add(activity);
            return true;
        }

        return false;
    }

    void remove(int time) {
        List<Activity> toBeRemoved = new LinkedList<Activity>();
        for (Activity activity : cActivities) {
            if (!activity.isOn(time)) {
                toBeRemoved.add(activity);
            }
        }
        cActivities.removeAll(toBeRemoved);

        List<Activity> toBeRemoved2 = new LinkedList<Activity>();
        for (Activity activity : jActivities) {
            if (!activity.isOn(time)) {
                toBeRemoved2.add(activity);
            }
        }
        jActivities.removeAll(toBeRemoved2);
    }
}


class Activity implements Comparable<Activity>{
    int start;
    int end;
    char owner;
    int originalOrder;

    Activity(int start, int end, int originalOrder) {
        this.start = start;
        this.end = end;
        this.originalOrder = originalOrder;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + originalOrder;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Activity other = (Activity) obj;
        if (originalOrder != other.originalOrder)
            return false;
        return true;
    }

    boolean isOn(int time) {
        // return time > start && time < end;
        return time < end;
    }

    @Override
    public int compareTo(Activity other) {
        return this.start - other.start;
    }

    @Override
    public String toString() {
        return "Activity [start=" + start + ", end=" + end + ", owner=" + owner + ", originalOrder=" + originalOrder + "]";
    }
}

class OriginalOrder implements Comparator<Activity> { 
    public int compare(Activity a1, Activity a2) { 
        return a1.originalOrder - a2.originalOrder; 
    } 
}
