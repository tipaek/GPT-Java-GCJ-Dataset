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
            StringBuilder validCase = new StringBuilder();
            List<Schedule> C = new ArrayList<>();
            List<Schedule> J = new ArrayList<>();

            boolean impossible = false;
            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();
                Schedule schedule = new Schedule(S, E);

                if (canSchedule(C, schedule)) {
                    validCase.append("C");
                    C.add(schedule);
                } else if (canSchedule(J, schedule)) {
                    validCase.append("J");
                    J.add(schedule);
                } else {
                    validCase = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    in.nextLine(); // Skip remaining inputs for this test case
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + validCase.toString());
        }
    }

    private static boolean canSchedule(List<Schedule> schedules, Schedule newSchedule) {
        for (Schedule schedule : schedules) {
            if (!(newSchedule.end <= schedule.start || newSchedule.start >= schedule.end)) {
                return false;
            }
        }
        return true;
    }
}