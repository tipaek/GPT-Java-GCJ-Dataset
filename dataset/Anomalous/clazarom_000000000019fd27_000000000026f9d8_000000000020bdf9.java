import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {

    private static final Logger logger = Logger.getLogger(Solution.class.getName());

    private static final char CAMERON = 'C';
    private static final char JAMIE = 'J';

    public class Parent {
        public static final char UNAVAILABLE = 'X';
        private char id;
        private int[][] activities;

        public Parent(char id, int maxDailyActivities) {
            this.id = id;
            this.activities = new int[maxDailyActivities][2];
        }

        public boolean isAvailable(int[] newActivity) {
            for (int[] activity : activities) {
                if (activity[0] != 0 || activity[1] != 0) {
                    if ((activity[0] < newActivity[0] && newActivity[0] < activity[1]) ||
                            (activity[0] < newActivity[1] && newActivity[1] < activity[1])) {
                        logger.log(Level.FINE, "Not an available slot: parent busy");
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return false;
        }

        public char assignActivity(int[] activity) {
            if (isAvailable(activity)) {
                for (int i = 0; i < activities.length; i++) {
                    if (activities[i][0] == 0) {
                        activities[i][0] = activity[0];
                        activities[i][1] = activity[1];
                        return id;
                    }
                }
            }
            logger.log(Level.WARNING, "Unfair system: all slots already covered?");
            return UNAVAILABLE;
        }
    }

    public static String[] readInput(InputStream inStream) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }

    private int[][] convertActivities(String[] activities) {
        int[][] convertedActivities = new int[activities.length][2];
        for (int i = 0; i < activities.length; i++) {
            String[] timesString = activities[i].split(" ");
            convertedActivities[i][0] = Integer.parseInt(timesString[0]);
            convertedActivities[i][1] = Integer.parseInt(timesString[1]);
        }
        return convertedActivities;
    }

    public String computeSchedule(String[] activities, int numActivities) {
        StringBuilder schedule = new StringBuilder();
        Parent cameron = new Parent(CAMERON, activities.length);
        Parent jamie = new Parent(JAMIE, activities.length);

        if (activities.length == numActivities) {
            int[][] timeActivities = convertActivities(activities);
            for (int[] timeActivity : timeActivities) {
                char assignResult = Parent.UNAVAILABLE;
                if (timeActivity.length == 2) {
                    if (cameron.isAvailable(timeActivity)) {
                        assignResult = cameron.assignActivity(timeActivity);
                        if (assignResult == Parent.UNAVAILABLE && jamie.isAvailable(timeActivity)) {
                            assignResult = jamie.assignActivity(timeActivity);
                        }
                    } else if (jamie.isAvailable(timeActivity)) {
                        assignResult = jamie.assignActivity(timeActivity);
                    }
                }

                if (assignResult == Parent.UNAVAILABLE) {
                    logger.log(Level.WARNING, "Overlapping of schedules: " + schedule);
                    return "IMPOSSIBLE";
                } else {
                    schedule.append(assignResult);
                }
            }
        } else {
            logger.log(Level.WARNING, "Wrong set of activities" + activities.length);
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        String[] lines = readInput(System.in);
        Solution solution = new Solution();

        int T = Integer.parseInt(lines[0]);
        int scheduleIndex = 1;
        int outputCase = 1;

        while (scheduleIndex < lines.length && T > 0) {
            int N = Integer.parseInt(lines[scheduleIndex]);
            scheduleIndex++;
            System.out.println(String.format("Case #%d: %s", outputCase, solution.computeSchedule(Arrays.copyOfRange(lines, scheduleIndex, scheduleIndex + N), N)));
            outputCase++;
            scheduleIndex += N;
            T--;
        }
    }
}