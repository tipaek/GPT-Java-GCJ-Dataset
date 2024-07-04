import java.util.*;
import java.io.*;

public class Solution {
    private static class Schedule {
        int start;
        int end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            String result = "";
            List<Schedule> C = new ArrayList<>();
            List<Schedule> J = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();
                Schedule s = new Schedule(S, E);

                if (canAddSchedule(C, s)) {
                    result += "C";
                    C.add(s);
                } else if (canAddSchedule(J, s)) {
                    result += "J";
                    J.add(s);
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        in.close();
    }

    private static boolean canAddSchedule(List<Schedule> schedules, Schedule newSchedule) {
        for (Schedule schedule : schedules) {
            if (!(newSchedule.end <= schedule.start || newSchedule.start >= schedule.end)) {
                return false;
            }
        }
        return true;
    }
}