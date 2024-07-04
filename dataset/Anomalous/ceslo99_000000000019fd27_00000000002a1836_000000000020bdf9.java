import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            int[][] schedule = new int[n][2];
            for (int j = 0; j < n; j++) {
                schedule[j][0] = in.nextInt();
                schedule[j][1] = in.nextInt();
            }
            scheduleJC(schedule, i);
        }
    }

    public static void scheduleJC(int[][] schedule, int caseNum) {
        int[][] jamie = new int[schedule.length][2];
        int[][] cameron = new int[schedule.length][2];
        int jJobs = 0, cJobs = 0;
        boolean fail = false;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < schedule.length; i++) {
            boolean jFail = false, cFail = false;

            for (int j = 0; j < jJobs; j++) {
                if ((schedule[i][0] < jamie[j][1] && schedule[i][1] > jamie[j][0])) {
                    jFail = true;
                    break;
                }
            }

            if (!jFail) {
                jamie[jJobs][0] = schedule[i][0];
                jamie[jJobs][1] = schedule[i][1];
                jJobs++;
                answer.append("J");
            } else {
                for (int j = 0; j < cJobs; j++) {
                    if ((schedule[i][0] < cameron[j][1] && schedule[i][1] > cameron[j][0])) {
                        cFail = true;
                        break;
                    }
                }

                if (!cFail) {
                    cameron[cJobs][0] = schedule[i][0];
                    cameron[cJobs][1] = schedule[i][1];
                    cJobs++;
                    answer.append("C");
                } else {
                    fail = true;
                    break;
                }
            }
        }

        if (fail) {
            System.out.println("Case #" + (caseNum + 1) + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + (caseNum + 1) + ": " + answer.toString());
        }
    }
}