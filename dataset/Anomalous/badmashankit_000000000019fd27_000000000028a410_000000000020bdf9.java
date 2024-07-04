import java.io.*;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        for (int n = 0; n < N; ++n) {
            String[] line = br.readLine().split(" ");
            schedules[n] = new Schedule(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
    }

    private boolean solve(int index) {
        if (index == N) {
            return true;
        }

        Schedule currentSchedule = schedules[index];

        if (canAssign(currentSchedule, cameron)) {
            currentSchedule.parent = 0;
            cameron.addSchedule(currentSchedule);

            if (solve(index + 1)) {
                return true;
            }

            cameron.removeLastSchedule();
        }

        if (canAssign(currentSchedule, james)) {
            currentSchedule.parent = 1;
            james.addSchedule(currentSchedule);

            if (solve(index + 1)) {
                return true;
            }

            james.removeLastSchedule();
        }

        return false;
    }

    private boolean canAssign(Schedule schedule, Parent parent) {
        for (int i = 0; i < parent.pN; i++) {
            if (schedule.isOverlapping(parent.pSchedules[i])) {
                return false;
            }
        }
        return true;
    }

    private static class Schedule {
        int start;
        int end;
        int parent;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isOverlapping(Schedule other) {
            return (this.start < other.end && this.end > other.start);
        }
    }

    private static class Parent {
        Schedule[] pSchedules;
        int pN;

        Parent() {
            pSchedules = new Schedule[1000];
            pN = 0;
        }

        void addSchedule(Schedule schedule) {
            pSchedules[pN++] = schedule;
        }

        void removeLastSchedule() {
            pSchedules[--pN] = null;
        }
    }
}