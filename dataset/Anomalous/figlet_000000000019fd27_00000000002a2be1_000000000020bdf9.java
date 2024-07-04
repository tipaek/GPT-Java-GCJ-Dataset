import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    private static boolean isOverlapping(ArrayList<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if ((activity.s < newActivity.s && activity.e > newActivity.s) ||
                (newActivity.s < activity.s && newActivity.e > activity.s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(reader.readLine());
            StringBuilder result = new StringBuilder();

            for (int i = 1; i <= t; i++) {
                int n = Integer.parseInt(reader.readLine());
                ArrayList<Activity> cameron = new ArrayList<>();
                ArrayList<Activity> jamie = new ArrayList<>();
                StringBuilder schedule = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if ("IMPOSSIBLE".equals(schedule.toString().trim())) {
                        reader.readLine();
                        continue;
                    }

                    String[] input = reader.readLine().split(" ");
                    int s = Integer.parseInt(input[0]);
                    int e = Integer.parseInt(input[1]);
                    Activity activity = new Activity(s, e);

                    if (!isOverlapping(cameron, activity)) {
                        cameron.add(activity);
                        schedule.append("C");
                    } else if (!isOverlapping(jamie, activity)) {
                        jamie.add(activity);
                        schedule.append("J");
                    } else {
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                    }
                }

                result.append("Case #").append(i).append(": ").append(schedule.toString()).append("\n");
            }

            System.out.print(result.toString());

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

class Activity {
    int s, e;

    Activity(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public String toString() {
        return s + ":" + e;
    }
}