import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mattia D'ambrosio
 * Created on 04/04/2020.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte testCases = scanner.nextByte();

        for (byte i = 1; i <= testCases; i++){
            LinkedList<Activity> activities = new LinkedList<>();
            int n = scanner.nextInt();

            for (int j = 0; j < n; j++) {
                Activity a = new Activity(j, scanner.nextInt(), scanner.nextInt());
                activities.add(a);
            }

            System.out.println("Case #"+i+": "+scheduleActivities(activities));
        }
    }

    private static String scheduleActivities(LinkedList<Activity> activities){
        Activity Cameron = null;
        Activity Jamie = null;
        char[] out = new char[activities.size()];
        List<Activity> sortedActivities = activities.stream().sorted().collect(Collectors.toList());

        for (Activity a: sortedActivities) {
            if(Cameron == null || !Cameron.doesOverlap(a)){
                Cameron = a;
                out[a.getId()] = 'C';
            }else if (Jamie == null || !Jamie.doesOverlap(a)){
                Jamie = a;
                out[a.getId()] = 'J';
            } else {
                return "Impossible";
            }
        }

        return String.copyValueOf(out);
    }
}

class Activity implements Comparable<Activity> {
    private int id;
    private int start;
    private int end;

    public Activity(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public boolean doesOverlap(Activity a) {
        if (this.end == a.end && this.start == a.start)
            return true;
        if (this.end > a.start && this.start < a.start)
            return true;
        if (a.end > this.start && a.start < this.start)
            return true;
        if (this.end > a.end && this.start < a.end)
            return true;
        if (a.end > this.end && a.start < this.end)
            return true;

        return false;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Activity o) {
        int compare = Integer.compare(this.start, o.start);

        return compare != 0 ? compare : Integer.compare(this.end, o.end);
    }
}
