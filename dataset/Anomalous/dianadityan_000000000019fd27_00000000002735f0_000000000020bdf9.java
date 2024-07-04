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
        // Scanner in = new Scanner(new File("./input.txt"));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            StringBuilder validCase = new StringBuilder();
            List<Schedule> C = new ArrayList<>();
            List<Schedule> J = new ArrayList<>();

            boolean isPossible = true;
            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();
                Schedule s = new Schedule(S, E);

                if (canAddToSchedule(C, s)) {
                    validCase.append("C");
                    C.add(s);
                } else if (canAddToSchedule(J, s)) {
                    validCase.append("J");
                    J.add(s);
                } else {
                    validCase.setLength(0);
                    validCase.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + validCase.toString());
        }

        in.close();
    }

    private static boolean canAddToSchedule(List<Schedule> scheduleList, Schedule newSchedule) {
        for (Schedule schedule : scheduleList) {
            if (!(newSchedule.end <= schedule.start || newSchedule.start >= schedule.end)) {
                return false;
            }
        }
        return true;
    }
}