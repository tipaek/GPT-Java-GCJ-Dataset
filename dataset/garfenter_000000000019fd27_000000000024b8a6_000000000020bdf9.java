import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int activitiesCount = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Activity> unsortedActivity = new ArrayList<>();
            for (int a = 0; a < activitiesCount; a++) {
                Activity activity = new Activity(in.nextInt(), in.nextInt());
                activities.add(activity);
                unsortedActivity.add(activity);
            }
            Activity cLastActivity = null;
            Activity jLastActivity = null;
            Collections.sort(activities);
            for (Activity activity : activities) {
                if (cLastActivity == null || cLastActivity.getEnd() <= activity.getStart()) {
                    activity.setAssigned("C");
                    cLastActivity = activity;
                } else if (jLastActivity == null || jLastActivity.getEnd() <= activity.getStart()) {
                    activity.setAssigned("J");
                    jLastActivity = activity;
                } else {
                    activity.setAssigned(null);
                    break;
                }
            }
            String schedule = "";
            for (Activity activity : unsortedActivity) {
                if (activity.getAssigned() != null) {
                    schedule += activity.getAssigned();
                } else {
                    schedule = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + c + ": " + schedule);

        }
    }

    static class Activity implements Comparable<Activity> {

        Integer start;
        Integer end;
        String assigned;

        public Activity(Integer start, Integer end) {
            this.start = start;
            this.end = end <= start ? 24 * 60 + end : end;
        }

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public String getAssigned() {
            return assigned;
        }

        public void setAssigned(String assigned) {
            this.assigned = assigned;
        }

        @Override
        public int compareTo(Activity o) {
            if (this.end == o.getEnd()) {
                return this.start.compareTo(o.getStart());
            }
            return this.end.compareTo(o.getEnd());
        }

        @Override
        public String toString() {
            return "Activity{" + "start=" + start + ", end=" + end + ", assigned=" + assigned + '}';
        }

    }
}
