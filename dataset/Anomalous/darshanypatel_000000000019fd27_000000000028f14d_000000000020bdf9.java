import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Activity {
    private final int index;
    private final int start;
    private final int end;
    private String assignedTo;

    Activity(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    public int getIndex() {
        return index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] times = reader.readLine().split(" ");
                activities.add(new Activity(i, Integer.parseInt(times[0]), Integer.parseInt(times[1])));
            }

            activities.sort(Comparator.comparingInt(Activity::getStart));

            boolean cBusy = false, jBusy = false;
            Activity cActivity = null, jActivity = null;

            boolean impossible = false;

            for (Activity activity : activities) {
                if (cBusy && activity.getStart() >= cActivity.getEnd()) {
                    cBusy = false;
                }
                if (jBusy && activity.getStart() >= jActivity.getEnd()) {
                    jBusy = false;
                }

                if (!cBusy) {
                    cBusy = true;
                    cActivity = activity;
                    activity.setAssignedTo("C");
                } else if (!jBusy) {
                    jBusy = true;
                    jActivity = activity;
                    activity.setAssignedTo("J");
                } else {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                activities.sort(Comparator.comparingInt(Activity::getIndex));
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.getAssignedTo());
                }
                System.out.println(String.format("Case #%d: %s", t, result.toString()));
            }
        }
    }
}