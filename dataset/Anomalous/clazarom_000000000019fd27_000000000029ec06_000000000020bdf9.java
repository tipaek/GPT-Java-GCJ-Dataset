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
    private static final char UNAVAILABLE = 'X';

    public class Parent {
        private char id;
        private int[][] activities;

        public Parent(char id, int maxDailyActivities) {
            this.id = id;
            newDay(maxDailyActivities);
        }

        public boolean isAvailable(int[] newActivity) {
            for (int[] activity : activities) {
                if (activity[0] != 0 || activity[1] != 0) {
                    if ((newActivity[0] >= activity[0] && newActivity[0] < activity[1]) ||
                        (newActivity[1] > activity[0] && newActivity[1] <= activity[1]) ||
                        (newActivity[0] < activity[0] && newActivity[1] > activity[0]) ||
                        (newActivity[0] < activity[1] && newActivity[1] > activity[1])) {
                        logger.log(Level.FINE, "Not an available slot: parent busy");
                        return false;
                    }
                }
            }
            return true;
        }

        public char assignActivity(int[] activity) {
            if (isAvailable(activity)) {
                for (int[] slot : activities) {
                    if (slot[0] == 0 && slot[1] == 0) {
                        slot[0] = activity[0];
                        slot[1] = activity[1];
                        return id;
                    }
                }
            }
            logger.log(Level.WARNING, "Unfair system: all slots already covered?");
            return UNAVAILABLE;
        }

        public void newDay(int maxDailyActivities) {
            activities = new int[maxDailyActivities][2];
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
            String[] times = activities[i].split(" ");
            convertedActivities[i][0] = Integer.parseInt(times[0]);
            convertedActivities[i][1] = Integer.parseInt(times[1]);
        }
        return convertedActivities;
    }

    public String computeSchedule(String[] activities, int numActivities, int scheduledDay) {
        Parent parent1 = new Parent(scheduledDay % 2 == 0 ? JAMIE : CAMERON, activities.length);
        Parent parent2 = new Parent(scheduledDay % 2 == 0 ? CAMERON : JAMIE, activities.length);

        if (activities.length != numActivities) {
            logger.log(Level.WARNING, "Wrong set of activities: " + activities.length);
            return "IMPOSSIBLE";
        }

        int[][] timeActivities = convertActivities(activities);
        StringBuilder schedule = new StringBuilder();

        for (int[] timeActivity : timeActivities) {
            char assignResult = UNAVAILABLE;
            if (timeActivity.length == 2) {
                if (parent1.isAvailable(timeActivity)) {
                    assignResult = parent1.assignActivity(timeActivity);
                }
                if (assignResult == UNAVAILABLE && parent2.isAvailable(timeActivity)) {
                    assignResult = parent2.assignActivity(timeActivity);
                }
            }
            if (assignResult == UNAVAILABLE) {
                logger.log(Level.WARNING, "Overlapping of schedules: " + schedule.toString());
                return "IMPOSSIBLE";
            } else {
                schedule.append(assignResult);
            }
        }
        return schedule.toString();
    }

    public static void main(String[] args) {
        String[] lines = readInput(System.in);
        Solution solution = new Solution();

        int T = Integer.parseInt(lines[0]);
        int scheduleIndex = 1;
        int outputCase = 1;
        int scheduledDays = 1;

        while (scheduleIndex < lines.length && T > 0) {
            int N = Integer.parseInt(lines[scheduleIndex]);
            scheduleIndex++;
            String computedSchedule = solution.computeSchedule(Arrays.copyOfRange(lines, scheduleIndex, scheduleIndex + N), N, scheduledDays);
            System.out.printf("Case #%d: %s%n", outputCase, computedSchedule);
            if (!computedSchedule.contains("IMPOSSIBLE")) {
                scheduledDays++;
            }
            outputCase++;
            scheduleIndex += N;
            T--;
        }
    }
}