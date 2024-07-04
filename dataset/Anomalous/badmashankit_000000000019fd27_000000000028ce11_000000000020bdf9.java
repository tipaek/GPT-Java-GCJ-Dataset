import java.io.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final char[] PARENT_CHAR = { 'C', 'J' };

    private int N;
    private Schedule[] schedules;
    private Parent cameron, james;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            solution.N = Integer.parseInt(br.readLine());
            solution.initializeSchedules();

            if (solution.assignSchedules(0)) {
                StringBuilder result = new StringBuilder();
                for (Schedule schedule : solution.schedules) {
                    result.append(PARENT_CHAR[schedule.parent]);
                }
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private void initializeSchedules() throws IOException {
        cameron = new Parent();
        james = new Parent();
        schedules = new Schedule[N];
        cameron.schedules = new Schedule[N];
        cameron.count = 0;
        james.schedules = new Schedule[N];
        james.count = 0;

        for (int i = 0; i < N; ++i) {
            String[] input = br.readLine().split(" ");
            schedules[i] = new Schedule(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
    }

    private boolean assignSchedules(int index) {
        if (index == N) return true;

        if (index == 0) {
            schedules[index].parent = 0;
            cameron.schedules[cameron.count++] = schedules[index];
            return assignSchedules(index + 1);
        }

        boolean canAssignToCameron = canAssignToParent(cameron, schedules[index]);
        boolean canAssignToJames = canAssignToParent(james, schedules[index]);

        if (!canAssignToCameron && !canAssignToJames) return false;

        if (canAssignToCameron) {
            schedules[index].parent = 0;
            cameron.schedules[cameron.count++] = schedules[index];
            if (assignSchedules(index + 1)) return true;
            cameron.schedules[--cameron.count] = null;
        }

        if (canAssignToJames) {
            schedules[index].parent = 1;
            james.schedules[james.count++] = schedules[index];
            return assignSchedules(index + 1);
        }

        return false;
    }

    private boolean canAssignToParent(Parent parent, Schedule schedule) {
        for (int i = 0; i < parent.count; ++i) {
            if (schedule.isOverlapping(parent.schedules[i])) return false;
        }
        return true;
    }

    private static class Schedule {
        public int start, end, parent;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapping(Schedule other) {
            return !(this.end <= other.start || this.start >= other.end);
        }
    }

    private static class Parent {
        public Schedule[] schedules;
        public int count;
    }
}