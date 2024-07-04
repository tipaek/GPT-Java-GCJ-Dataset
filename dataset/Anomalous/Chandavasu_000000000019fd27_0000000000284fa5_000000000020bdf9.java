import java.util.ArrayList;
import java.util.Scanner;

class Activity {
    private int startMin;
    private int endMin;

    public Activity(int startMin, int endMin) {
        this.startMin = startMin;
        this.endMin = endMin;
    }

    public boolean isValid(Activity activity) {
        return (endMin <= activity.getStartMin() || activity.getEndMin() <= startMin) &&
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
            ArrayList<Activity> cActivities = new ArrayList<>();
            ArrayList<Activity> jActivities = new ArrayList<>();

            for (int j = 0; j < nActv; j++) {
                Activity activity = new Activity(in.nextInt(), in.nextInt());
                boolean impossible = false;

                if (activity.getStartMin() >= 0 && activity.getStartMin() < activity.getEndMin() && activity.getEndMin() <= 24 * 60) {
                    boolean cJob = true;
                    boolean jJob = true;

                    for (int c = 0; c < Math.max(cActivities.size(), jActivities.size()); c++) {
                        if (c < cActivities.size() && !cActivities.get(c).isValid(activity)) {
                            cJob = false;
                        }
                        if (c < jActivities.size() && !jActivities.get(c).isValid(activity)) {
                            jJob = false;
                        }
                        if (!cJob && !jJob) {
                            break;
                        }
                    }

                    if (cJob) {
                        actvStrb.append("C");
                        cActivities.add(activity);
                    } else if (jJob) {
                        actvStrb.append("J");
                        jActivities.add(activity);
                    } else {
                        impossible = true;
                    }
                } else {
                    impossible = true;
                }

                if (impossible) {
                    actvStrb.setLength(0);
                    actvStrb.append("IMPOSSIBLE");

                    while (++j < nActv) {
                        in.nextInt();
                        in.nextInt();
                    }

                    break;
                }
            }

            if (nActv > 0) {
                System.out.println("Case #" + (i + 1) + ": " + actvStrb.toString());
            }
        }
    }
}