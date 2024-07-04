import java.io.*;
import java.util.*;

public class Solution {
    private static final String FILE_NAME = null;

    private static String solve(Scanner in) {
        int N = in.nextInt();

        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Activity activity = new Activity();
            activity.startTime = in.nextInt();
            activity.endTime = in.nextInt();
            activity.originalIndex = i;
            activities.add(activity);
        }

        activities.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.startTime - o2.startTime;
            }
        });

        int jFreeTime = 0;
        int cFreeTime = 0;
        for (int i = 0; i < N; i++) {
            if (jFreeTime <= activities.get(i).startTime) {
                activities.get(i).assignee = 'J';
                jFreeTime = activities.get(i).endTime;
            } else if (cFreeTime <= activities.get(i).startTime) {
                activities.get(i).assignee = 'C';
                cFreeTime = activities.get(i).endTime;
            } else {
                jFreeTime = Integer.MAX_VALUE;
                cFreeTime = Integer.MAX_VALUE;
            }
        }

        StringBuilder schedule = new StringBuilder();

        if (jFreeTime == Integer.MAX_VALUE) {
            schedule.append("IMPOSSIBLE");
        } else {
            activities.sort(new Comparator<Activity>() {
                @Override
                public int compare(Activity o1, Activity o2) {
                    return o1.originalIndex - o2.originalIndex;
                }
            });

            for (int i = 0; i < activities.size(); i++) {
                schedule.append(activities.get(i).assignee);
            }
        }

        return schedule.toString();
    }

    private static class Activity {
        int startTime;
        int endTime;
        int originalIndex;
        char assignee;
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                System.out.println("Case #" + t + ": " + solution);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
