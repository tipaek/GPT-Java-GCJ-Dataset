import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int nact = sc.nextInt();
            processActivities(nact, i + 1);
        }
    }

    public static void processActivities(int nact, int caseNumber) {
        int[][] activities = new int[nact][2];
        for (int i = 0; i < nact; i++) {
            activities[i][0] = sc.nextInt();
            activities[i][1] = sc.nextInt();
        }

        char[] schedule = new char[nact];
        boolean impossible = false;

        for (int i = 0; i < nact; i++) {
            int startI = activities[i][0];
            int endI = activities[i][1];
            int j = i + 1;

            while (j < nact) {
                int nextStart = activities[j][0];
                int nextEnd = activities[j][1];

                boolean overlap = Math.min(startI, nextStart) < Math.max(startI, nextStart) && 
                                  Math.max(startI, nextStart) < Math.min(endI, nextEnd);

                if (overlap) {
                    if (j + 1 < nact) {
                        int nextNextStart = activities[j + 1][0];
                        boolean impossibleCondition = Math.max(Math.max(startI, nextStart), nextNextStart) < 
                                                      Math.min(endI, nextEnd);

                        if (impossibleCondition) {
                            impossible = true;
                            break;
                        }
                    }
                    if (nact == 2) {
                        schedule[0] = 'J';
                        schedule[1] = 'C';
                    }
                    if (i == 0 && schedule[i] != 'J') {
                        schedule[i] = 'C';
                    }
                    if (i == 0 || schedule[j] != 'C') {
                        schedule[j] = 'J';
                    }
                } else {
                    if (nact == 2) {
                        schedule[0] = 'J';
                        schedule[1] = 'J';
                    }
                    if (i == 0 && schedule[j] != 'J') {
                        schedule[j] = 'C';
                    }
                }
                j++;
            }

            if (impossible) {
                break;
            }
        }

        if (impossible) {
            printResult(caseNumber, "IMPOSSIBLE");
        } else {
            printResult(caseNumber, new String(schedule));
        }
    }

    public static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}