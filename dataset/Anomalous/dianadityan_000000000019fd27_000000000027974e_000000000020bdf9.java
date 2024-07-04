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

    private static Schedule[] C = new Schedule[1000];
    private static Schedule[] J = new Schedule[1000];
    private static String validCase;
    private static int countC, countJ;

    private static void init() {
        validCase = "";
        countC = 0;
        countJ = 0;
        for (int i = 0; i < 1000; i++) {
            C[i] = new Schedule(0, 0);
            J[i] = new Schedule(0, 0);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            init();

            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();

                if (canAssignTo(S, E, C, countC)) {
                    validCase += "C";
                    C[countC++] = new Schedule(S, E);
                } else if (canAssignTo(S, E, J, countJ)) {
                    validCase += "J";
                    J[countJ++] = new Schedule(S, E);
                } else {
                    validCase = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + testCase + ": " + validCase);
        }
    }

    private static boolean canAssignTo(int S, int E, Schedule[] schedules, int count) {
        for (int i = 0; i < count; i++) {
            if (!(S >= schedules[i].end || E <= schedules[i].start)) {
                return false;
            }
        }
        return true;
    }
}