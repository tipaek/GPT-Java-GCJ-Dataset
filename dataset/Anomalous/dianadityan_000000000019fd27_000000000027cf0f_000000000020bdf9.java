import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX_TASKS = 1000;
    private static int[] cStart = new int[MAX_TASKS];
    private static int[] cEnd = new int[MAX_TASKS];
    private static int[] jStart = new int[MAX_TASKS];
    private static int[] jEnd = new int[MAX_TASKS];
    private static String validCase;
    private static int countC, countJ;

    private static void init() {
        validCase = "";
        countC = 0;
        countJ = 0;
        Arrays.fill(cStart, 0);
        Arrays.fill(cEnd, 0);
        Arrays.fill(jStart, 0);
        Arrays.fill(jEnd, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            init();

            boolean possible = true;
            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();

                if (canAssign(S, E, cStart, cEnd, countC)) {
                    validCase += "C";
                    cStart[countC] = S;
                    cEnd[countC] = E;
                    countC++;
                } else if (canAssign(S, E, jStart, jEnd, countJ)) {
                    validCase += "J";
                    jStart[countJ] = S;
                    jEnd[countJ] = E;
                    countJ++;
                } else {
                    validCase = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + validCase);
        }

        in.close();
    }

    private static boolean canAssign(int S, int E, int[] start, int[] end, int count) {
        for (int i = 0; i < count; i++) {
            if (!(S >= end[i] || E <= start[i])) {
                return false;
            }
        }
        return true;
    }
}