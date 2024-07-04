import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solveCase(in, i);
        }
    }

    private static void solveCase(Scanner in, int caseNb) {
        final int activityNumber = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        final TreeSet<Activity> cameron = new TreeSet<>();
        final TreeSet<Activity> jamie = new TreeSet<>();

        final Set<Activity> all = new TreeSet<>();

        for (int i = 0; i < activityNumber; i++) {
            final String[] elements =  in.nextLine().split(" ");
            all.add(new Activity(Integer.parseInt(elements[0]),Integer.parseInt(elements[1]),i));
        }

        boolean guard = false;
        for(Activity activity : all)
        {

            Activity cameronActivity = cameron.size()==0 ? null : cameron.last();
            Activity jamieActivity = jamie.size()==0 ? null : jamie.last();
            if(cameronActivity == null || cameronActivity.end <= activity.start) {
                cameron.add(activity);
                activity.owner = "C";
            }else if(jamieActivity == null || jamieActivity.end <= activity.start){
                jamie.add(activity);
                activity.owner = "J";
            } else {
                guard = true;
                break;
            }
        }
//
        if(guard) {
            System.out.println("Case #" + caseNb + ": IMPOSSIBLE");
        }else{
            final StringBuilder sb = new StringBuilder();
            Set<Activity> newSet = new TreeSet(Comparator.comparing((Activity e) -> e.order));
            newSet.addAll(all);
            newSet.forEach(e->sb.append(e.owner));
            System.out.println("Case #" + caseNb + ": "+sb.toString());
        }
    }
}

class Activity implements Comparable<Activity> {
    public Integer start, end, order;
    public String owner;

    public Activity(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }


    @Override
    public int compareTo(Activity activity) {
        if(this.start.compareTo(activity.start) != 0){
            return this.start.compareTo(activity.start);
        } else if(this.end.compareTo(activity.end) != 0){
            return this.end.compareTo(activity.end);
        } else {
            return this.order.compareTo(activity.order);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(start, activity.start) &&
                Objects.equals(end, activity.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                ", order=" + order +
                '}';
    }
}

