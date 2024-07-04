import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity {
    int id;
    int startTime;
    int endTime;

    public Activity(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tC = 1; tC <= t; tC++) {
            int n = Integer.parseInt(br.readLine());
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] activityDetails = br.readLine().split(" ");
                int startTime = Integer.parseInt(activityDetails[0]);
                int endTime = Integer.parseInt(activityDetails[1]);
                activities.add(new Activity(i, startTime, endTime));
            }

            activities.sort(Comparator.comparingInt(Activity::getStartTime));
            char[] assignment = new char[n];
            boolean[] available = {true, true}; // C and J availability
            int[] endTimes = {0, 0}; // End times for C and J

            boolean possible = true;
            for (Activity activity : activities) {
                if (activity.getStartTime() >= endTimes[0]) {
                    assignment[activity.getId()] = 'C';
                    endTimes[0] = activity.getEndTime();
                } else if (activity.getStartTime() >= endTimes[1]) {
                    assignment[activity.getId()] = 'J';
                    endTimes[1] = activity.getEndTime();
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                sb.append("Case #").append(tC).append(": ");
                for (char c : assignment) {
                    sb.append(c);
                }
                sb.append("\n");
            } else {
                sb.append("Case #").append(tC).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(sb);
    }
}