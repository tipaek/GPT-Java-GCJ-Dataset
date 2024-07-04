import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] schedule = new int[2][n];
            for (int j = 0; j < n; j++) {
                schedule[0][j] = scanner.nextInt();
                schedule[1][j] = scanner.nextInt();
            }
            processSchedule(schedule, i);
        }
    }

    public static void processSchedule(int[][] schedule, int caseNum) {
        int[][] jamie = new int[2][schedule[0].length];
        int jJobs = 0;
        int[][] cameron = new int[2][schedule[0].length];
        int cJobs = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < schedule[0].length; i++) {
            boolean jFail = false;
            boolean cFail = false;

            // Check for Jamie's schedule
            for (int k = 0; k < jJobs; k++) {
                if ((schedule[0][i] < jamie[1][k] && schedule[1][i] > jamie[0][k])) {
                    jFail = true;
                    break;
                }
            }

            if (!jFail) {
                jamie[0][jJobs] = schedule[0][i];
                jamie[1][jJobs] = schedule[1][i];
                jJobs++;
                result.append("J");
                continue;
            }

            // Check for Cameron's schedule
            for (int k = 0; k < cJobs; k++) {
                if ((schedule[0][i] < cameron[1][k] && schedule[1][i] > cameron[0][k])) {
                    cFail = true;
                    break;
                }
            }

            if (!cFail) {
                cameron[0][cJobs] = schedule[0][i];
                cameron[1][cJobs] = schedule[1][i];
                cJobs++;
                result.append("C");
                continue;
            }

            // If both fail
            System.out.println("Case #" + (caseNum + 1) + ": IMPOSSIBLE");
            return;
        }

        System.out.println("Case #" + (caseNum + 1) + ": " + result.toString());
    }
}