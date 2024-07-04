import java.util.*;

class Activity {
    private int startMin;
    private int endMin;

    public Activity(int startMin, int endMin) {
        this.startMin = startMin;
        this.endMin = endMin;
    }

    public boolean isValid(Activity activity) {
        return (endMin <= activity.getStartMin() || startMin >= activity.getEndMin()) &&
               !(startMin == activity.getStartMin() && endMin == activity.getEndMin());
    }

    public int getStartMin() {
        return startMin;
    }

    public int getEndMin() {
        return endMin;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            StringBuilder actvStrb = new StringBuilder();
            int nActv = in.nextInt();
            List<Activity> cActivities = new ArrayList<>();
            List<Activity> jActivities = new ArrayList<>();

            for (int j = 0; j < nActv; j++) {
                Activity activity = new Activity(in.nextInt(), in.nextInt());
                boolean cJob = isValidForAll(cActivities, activity);
                boolean jJob = isValidForAll(jActivities, activity);

                if (cJob) {
                    actvStrb.append("C");
                    cActivities.add(activity);
                } else if (jJob) {
                    actvStrb.append("J");
                    jActivities.add(activity);
                } else {
                    actvStrb.setLength(0);
                    actvStrb.append("IMPOSSIBLE");
                    while (++j < nActv) {
                        in.nextInt();
                        in.nextInt();
                    }
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + actvStrb.toString());
        }
    }

    private static boolean isValidForAll(List<Activity> activities, Activity activity) {
        for (Activity a : activities) {
            if (!a.isValid(activity)) {
                return false;
            }
        }
        return true;
    }
}