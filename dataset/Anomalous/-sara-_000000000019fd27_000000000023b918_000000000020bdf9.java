package qualificationRound;

import java.util.Scanner;

public class SolutionProblem3 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                boolean[] jamie = new boolean[1441];
                boolean[] cameron = new boolean[1441];
                int n = in.nextInt();
                StringBuilder solution = new StringBuilder();
                boolean possible = true;

                for (int j = 0; j < n; j++) {
                    int beginTime = in.nextInt();
                    int endTime = in.nextInt();

                    if (isTimeSlotAvailable(jamie, beginTime, endTime)) {
                        markTimeSlot(jamie, beginTime, endTime);
                        solution.append("J");
                    } else if (isTimeSlotAvailable(cameron, beginTime, endTime)) {
                        markTimeSlot(cameron, beginTime, endTime);
                        solution.append("C");
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (!possible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + solution.toString());
                }
            }
        }
    }

    private static boolean isTimeSlotAvailable(boolean[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k]) {
                return false;
            }
        }
        return true;
    }

    private static void markTimeSlot(boolean[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = true;
        }
    }
}