import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static class Time implements Comparable<Time> {
        int start;
        int end;
        int index;
        char assigned;

        public Time(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Time other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int readTestCases() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static int assignTasks(ArrayList<Time> schedule) {
        Time cameronCurrent = new Time(-1, -1, -1);
        Time jamieCurrent = new Time(-1, -1, -1);

        for (Time task : schedule) {
            int start = task.start;
            int end = task.end;

            if (cameronCurrent.end <= start) {
                task.assigned = 'C';
                cameronCurrent = task;
            } else if (jamieCurrent.end <= start) {
                task.assigned = 'J';
                jamieCurrent = task;
            } else {
                return -1;
            }
        }
        return 1;
    }

    public static int[][] readMatrix() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        int[][] mat = new int[size][2];
        for (int i = 0; i < size; i++) {
            String[] row = reader.readLine().split(" ");
            mat[i][0] = Integer.parseInt(row[0]);
            mat[i][1] = Integer.parseInt(row[1]);
        }
        return mat;
    }

    public static void solveTest(int[][] time, int testCaseNo, StringBuilder ansSb) {
        ArrayList<Time> schedule = new ArrayList<>();

        for (int i = 0; i < time.length; i++) {
            schedule.add(new Time(time[i][0], time[i][1], i));
        }
        Collections.sort(schedule);

        int result = assignTasks(schedule);
        if (result == -1) {
            ansSb.append("Case #").append(testCaseNo).append(": IMPOSSIBLE\n");
            return;
        }

        char[] ans = new char[schedule.size()];
        for (Time job : schedule) {
            ans[job.index] = job.assigned;
        }

        ansSb.append("Case #").append(testCaseNo).append(": ").append(new String(ans)).append("\n");
    }

    public static void main(String[] args) throws IOException {
        int numberOfTestCases = readTestCases();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= numberOfTestCases; i++) {
            solveTest(readMatrix(), i, ans);
        }
        System.out.println(ans.toString());
    }
}