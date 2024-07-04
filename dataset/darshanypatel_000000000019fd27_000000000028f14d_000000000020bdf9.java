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

    public void setAssignedTo(String person) {
        this.assignedTo = person;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        outer:
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] times = reader.readLine().split(" ");
                activities.add(new Activity(i, Integer.parseInt(times[0]),
                        Integer.parseInt(times[1])));
            }

            activities.sort(Comparator.comparing(Activity::getStart));

            boolean busyC = false;
            boolean busyJ = false;
            Activity C = null;
            Activity J = null;

            for (Activity activity : activities) {
                int newActivityStart = activity.getStart();
                if (busyC && newActivityStart >= C.getEnd()) {
                    busyC = false;
                    C = null;
                }
                if (busyJ && newActivityStart >= J.getEnd()) {
                    busyJ = false;
                    J = null;
                }

                if (!busyC) {
                    busyC = true;
                    C = activity;
                    activity.setAssignedTo("C");
                } else if (!busyJ) {
                    busyJ = true;
                    J = activity;
                    activity.setAssignedTo("J");
                } else {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
                    continue outer;
                }
            }

            StringBuilder answer = new StringBuilder();
            activities.sort(Comparator.comparing(Activity::getIndex));
            for (Activity activity : activities) {
                answer.append(activity.getAssignedTo());
            }

            System.out.println(String.format("Case #%d: %s", t, answer.toString()));
        }

    }
}
