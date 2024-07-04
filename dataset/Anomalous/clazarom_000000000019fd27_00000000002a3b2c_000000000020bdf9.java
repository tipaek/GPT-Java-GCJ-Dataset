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
            newDay(maxDailyActivities);
        }

        public boolean isAvailable(int[] newActivity) {
            return canFitActivity(activities, newActivity) == 0;
        }

        public int canFitActivity(int[][] schedule, int[] newActivity) {
            int conflicts = 0;
            for (int[] activity : schedule) {
                if (activity[0] != 0 || activity[1] != 0) {
                    int newStart = newActivity[0];
                    int newEnd = newActivity[1];
                    if ((newStart >= activity[0] && newStart < activity[1]) ||
                        (newEnd > activity[0] && newEnd <= activity[1]) ||
                        (newStart < activity[0] && newEnd > activity[0]) ||
                        (newStart < activity[1] && newEnd > activity[1])) {
                        conflicts++;
                    }
                }
            }
            return conflicts == 0 ? conflicts : schedule.length;
        }

        public char assignActivity(int[] activity) {
            if (isAvailable(activity)) {
                for (int i = 0; i < activities.length; i++) {
                    if (activities[i][0] == 0 && activities[i][1] == 0) {
                        activities[i][0] = activity[0];
                        activities[i][1] = activity[1];
                        return id;
                    }
                }
            }
            return UNAVAILABLE;
        }

        public void newDay(int maxDailyActivities) {
            activities = new int[maxDailyActivities][2];
        }
    }

    public class TwoParents {
        private int[][] activities;
        private char[] assignedIDs;
        private Parent parent1;
        private Parent parent2;

        public TwoParents(Parent parent1, Parent parent2, int N) {
            this.parent1 = parent1;
            this.parent2 = parent2;
            activities = new int[N][2];
            assignedIDs = new char[N];
        }

        private boolean reorderActivities(int position) {
            boolean success = true;
            int N = activities.length;
            assignedIDs = new char[N];
            parent1.newDay(N);
            parent2.newDay(N);
            for (int i = 0; i < position && success; i++) {
                success = assignNewActivity(activities[i], i);
            }
            return success;
        }

        public boolean assignNewActivity(int[] timeActivity, int order) {
            boolean success = false;
            char assignResult = Parent.UNAVAILABLE;
            if (timeActivity.length == 2) {
                assignResult = parent1.assignActivity(timeActivity);
                if (assignResult == Parent.UNAVAILABLE) {
                    assignResult = parent2.assignActivity(timeActivity);
                }
            }
            if (assignResult == Parent.UNAVAILABLE) {
                int conflicts = parent1.canFitActivity(activities, timeActivity);
                if (conflicts < 2) {
                    activities[order] = timeActivity;
                    assignedIDs[order] = assignResult;
                    reorderActivities(order);
                } else {
                    activities = new int[activities.length][2];
                    assignedIDs = new char[activities.length];
                }
            } else {
                success = true;
                activities[order] = timeActivity;
                assignedIDs[order] = assignResult;
            }
            return success;
        }

        public String getSchedule() {
            StringBuilder schedule = new StringBuilder();
            for (char name : assignedIDs) {
                schedule.append(name);
            }
            return schedule.toString();
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
        Parent parent1 = (scheduledDay % 2 != 0) ? new Parent(CAMERON, activities.length) : new Parent(JAMIE, activities.length);
        Parent parent2 = (scheduledDay % 2 != 0) ? new Parent(JAMIE, activities.length) : new Parent(CAMERON, activities.length);

        TwoParents parents = new TwoParents(parent1, parent2, numActivities);
        int[][] timeActivities = convertActivities(activities);
        boolean scheduleOK = true;

        for (int i = 0; i < timeActivities.length && scheduleOK; i++) {
            scheduleOK = parents.assignNewActivity(timeActivities[i], i);
        }

        String schedule = scheduleOK ? parents.getSchedule() : "IMPOSSIBLE";
        return schedule.isEmpty() ? "IMPOSSIBLE" : schedule;
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
            System.out.println(String.format("Case #%d: %s", outputCase, computedSchedule));

            if (!computedSchedule.contains("IMPOSSIBLE")) {
                scheduledDays++;
            }

            outputCase++;
            scheduleIndex += N;
            T--;
        }
    }
}