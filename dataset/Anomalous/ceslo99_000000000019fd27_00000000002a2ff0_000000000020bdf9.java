import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] schedule = new int[n][2];
            for (int j = 0; j < n; j++) {
                schedule[j][0] = scanner.nextInt();
                schedule[j][1] = scanner.nextInt();
            }
            scheduleJC(schedule, i);
        }
    }

    public static void scheduleJC(int[][] schedule, int caseNum) {
        int n = schedule.length;
        int[][] jamie = new int[n][2];
        int[][] cameron = new int[n][2];
        int jJobs = 0, cJobs = 0;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
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
                    System.out.println("Case #" + (caseNum + 1) + ": IMPOSSIBLE");
                    return;
                }
            }
        }

        System.out.println("Case #" + (caseNum + 1) + ": " + answer.toString());
    }
}