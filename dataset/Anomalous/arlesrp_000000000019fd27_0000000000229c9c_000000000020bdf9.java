import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int id;

    public Activity(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.end, other.end);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = Integer.parseInt(br.readLine());
            List<Activity> activities = new ArrayList<>();
            char[] solution = new char[N];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);
                activities.add(new Activity(start, end, i));
            }

            Collections.sort(activities);

            if (assignActivities(activities, solution)) {
                System.out.println("Case #" + caseNum + ": " + new String(solution));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean assignActivities(List<Activity> activities, char[] solution) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (canAssign(activity, cameronActivities)) {
                cameronActivities.add(activity);
                solution[activity.id] = 'C';
            } else if (canAssign(activity, jamieActivities)) {
                jamieActivities.add(activity);
                solution[activity.id] = 'J';
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean canAssign(Activity activity, List<Activity> assignedActivities) {
        if (assignedActivities.isEmpty()) {
            return true;
        }
        Activity lastActivity = assignedActivities.get(assignedActivities.size() - 1);
        return lastActivity.end <= activity.start;
    }
}