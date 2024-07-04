import java.io.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final char[] PARENT_CHAR = { 'C', 'J' };
    private int N;
    private Schedule[] schedules;
    private Parent cameron;
    private Parent james;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            solution.N = Integer.parseInt(br.readLine());
            solution.init();

            if (solution.solve(0)) {
                StringBuilder sb = new StringBuilder();
                for (Schedule schedule : solution.schedules) {
                    sb.append(PARENT_CHAR[schedule.parent]);
                }
                System.out.println("Case #" + t + ": " + sb.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private void init() throws IOException {
        cameron = new Parent();
        james = new Parent();
        schedules = new Schedule[N];
        cameron.pSchedules = new Schedule[N];
        cameron.pN = 0;
        james.pSchedules = new Schedule[N];
        james.pN = 0;

        for (int n = 0; n < N; ++n) {
            String[] line = br.readLine().split(" ");
            schedules[n] = new Schedule(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
    }

    private boolean solve(int index) {
        if (index == N) {
            return true;
        }

        Schedule current = schedules[index];
        
        if (canAssignToParent(current, cameron)) {
            assignToParent(current, cameron, 0);
            if (solve(index + 1)) {
                return true;
            }
            unassignFromParent(cameron);
        }

        if (canAssignToParent(current, james)) {
            assignToParent(current, james, 1);
            if (solve(index + 1)) {
                return true;
            }
            unassignFromParent(james);
        }

        return false;
    }

    private boolean canAssignToParent(Schedule schedule, Parent parent) {
        for (int i = 0; i < parent.pN; i++) {
            if (schedule.isOverlapping(parent.pSchedules[i])) {
                return false;
            }
        }
        return true;
    }

    private void assignToParent(Schedule schedule, Parent parent, int parentId) {
        schedule.parent = parentId;
        parent.pSchedules[parent.pN++] = schedule;
    }

    private void unassignFromParent(Parent parent) {
        parent.pSchedules[--parent.pN] = null;
    }

    private static class Schedule {
        public int start;
        public int end;
        public int parent;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapping(Schedule other) {
            return !(this.end <= other.start || this.start >= other.end);
        }
    }

    private static class Parent {
        public Schedule[] pSchedules;
        public int pN;
    }
}