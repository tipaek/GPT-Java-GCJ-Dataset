import java.io.*;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final char[] PARENTS = { 'C', 'J' };
    private int numSchedules;
    private Schedule[] schedules;
    private Parent cameron;
    private Parent james;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            solution.numSchedules = Integer.parseInt(br.readLine());
            solution.initialize();

            if (solution.assignSchedules(0)) {
                StringBuilder result = new StringBuilder();
                for (Schedule schedule : solution.schedules) {
                    result.append(PARENTS[schedule.assignedParent]);
                }
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private void initialize() throws IOException {
        cameron = new Parent(numSchedules);
        james = new Parent(numSchedules);
        schedules = new Schedule[numSchedules];

        for (int i = 0; i < numSchedules; i++) {
            String[] times = br.readLine().split(" ");
            schedules[i] = new Schedule(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
        }
    }

    private boolean assignSchedules(int index) {
        if (index == numSchedules) {
            return true;
        }

        Schedule currentSchedule = schedules[index];

        if (canAssignToParent(currentSchedule, cameron)) {
            currentSchedule.assignedParent = 0;
            cameron.addSchedule(currentSchedule);

            if (assignSchedules(index + 1)) {
                return true;
            }

            cameron.removeLastSchedule();
        }

        if (canAssignToParent(currentSchedule, james)) {
            currentSchedule.assignedParent = 1;
            james.addSchedule(currentSchedule);

            if (assignSchedules(index + 1)) {
                return true;
            }

            james.removeLastSchedule();
        }

        return false;
    }

    private boolean canAssignToParent(Schedule schedule, Parent parent) {
        for (int i = 0; i < parent.scheduleCount; i++) {
            if (parent.schedules[i].isOverlapping(schedule)) {
                return false;
            }
        }
        return true;
    }

    private static class Schedule {
        public final int start;
        public final int end;
        public int assignedParent;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapping(Schedule other) {
            return !(this.end <= other.start || this.start >= other.end);
        }
    }

    private static class Parent {
        public final Schedule[] schedules;
        public int scheduleCount;

        public Parent(int capacity) {
            schedules = new Schedule[capacity];
            scheduleCount = 0;
        }

        public void addSchedule(Schedule schedule) {
            schedules[scheduleCount++] = schedule;
        }

        public void removeLastSchedule() {
            schedules[--scheduleCount] = null;
        }
    }
}