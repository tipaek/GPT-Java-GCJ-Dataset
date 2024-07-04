import java.io.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private char[] parentChar = { 'C', 'J' };
    private int N;

    private Schedule[] schedules;

    private Parent Cameron;
    private Parent James;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            solution.N = Integer.parseInt(br.readLine());

            solution.init();

            if (solution.solve(0)) {
                StringBuilder sb = new StringBuilder();
                for (Schedule schedule : solution.schedules) {
                    sb.append(solution.parentChar[schedule.parent]);
                }
                System.out.println("Case #" + t + ": " + sb.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private void init() throws IOException {
        Cameron = new Parent();
        James = new Parent();
        schedules = new Schedule[N];
        Cameron.pSchedules = new Schedule[N];
        Cameron.pN = 0;
        James.pSchedules = new Schedule[N];
        James.pN = 0;

        for (int n = 0; n < N; ++n) {
            String[] line = br.readLine().split(" ");
            schedules[n] = new Schedule();
            schedules[n].start = Integer.parseInt(line[0]);
            schedules[n].end = Integer.parseInt(line[1]);
        }
    }

    private boolean solve(int index) {
        if (index == N) {
            return true;
        }
        if (index == 0) {
            schedules[index].parent = 0;
            Cameron.pSchedules[Cameron.pN++] = schedules[index];
            if (solve(index + 1)) {
                return true;
            } else {
                return false;
            }
        }
        // Check Cameron schedules
        boolean isCameron = true;
        for (int c = 0; c < Cameron.pN; ++c) {
            Schedule schedule = Cameron.pSchedules[c];
            if (schedule.isOverlapping(schedules[index])) {
                isCameron = false;
                break;
            }
        }
        // Check James schedules
        boolean isJames = true;
        for (int j = 0; j < James.pN; ++j) {
            Schedule schedule = James.pSchedules[j];
            if (schedule.isOverlapping(schedules[index])) {
                isJames = false;
                break;
            }
        }
        if (!isCameron && !isJames) {
            return false;
        }
        if (isCameron) {
            schedules[index].parent = 0;
            Cameron.pSchedules[Cameron.pN++] = schedules[index];
            if (solve(index + 1)) {
                return true;
            } else {
                // This means Cameron is not fit for this schedule
                // Check is James is available
                if (isJames) {
                    // free up Cameron
                    Cameron.pSchedules[Cameron.pN--] = null;
                    // Add schedule to James
                    schedules[index].parent = 1;
                    James.pSchedules[James.pN++] = schedules[index];
                    return solve(index + 1);
                } else {
                    return false;
                }
            }
        } else {
            schedules[index].parent = 1;
            James.pSchedules[James.pN++] = schedules[index];
            return solve(index + 1);
        }
    }

    private class Schedule {
        public int start;
        public int end;
        public int parent;

        public boolean isOverlapping(Schedule other) {
            if (this.end == other.start || this.start == other.end) {
                return false;
            }
            if (this.end > other.start && this.end <= other.end) {
                return true;
            }
            if (this.start >= other.start && this.start < other.end) {
                return true;
            }
            if (this.start <= other.start && this.end >= other.end) {
                return true;
            }
            return false;
        }
    }

    private class Parent {
        public Schedule[] pSchedules;
        public int pN;
    }
}