package qualificationRound;

import java.util.Scanner;

public class SolutionProblem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            boolean[] jamie = new boolean[1441];
            boolean[] cameron = new boolean[1441];
            int n = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            boolean isPossible = true;
            for (int j = 0; j < n; j++) {
                int beginTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isPossible) {
                    if (isAvailable(jamie, beginTime, endTime)) {
                        solution.append("J");
                        markTime(jamie, beginTime, endTime);
                    } else if (isAvailable(cameron, beginTime, endTime)) {
                        solution.append("C");
                        markTime(cameron, beginTime, endTime);
                    } else {
                        solution = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + solution);
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            if (schedule[k]) {
                return false;
            }
        }
        return true;
    }

    private static void markTime(boolean[] schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            schedule[k] = true;
        }
    }
}