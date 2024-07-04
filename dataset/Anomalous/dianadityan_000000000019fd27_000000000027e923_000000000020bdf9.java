import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX_ACTIVITIES = 1000;
    private static int[] cStart = new int[MAX_ACTIVITIES];
    private static int[] cEnd = new int[MAX_ACTIVITIES];
    private static int[] jStart = new int[MAX_ACTIVITIES];
    private static int[] jEnd = new int[MAX_ACTIVITIES];
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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        int[] S = new int[MAX_ACTIVITIES];
        int[] E = new int[MAX_ACTIVITIES];

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            init();

            for (int i = 0; i < N; i++) {
                S[i] = in.nextInt();
                E[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                if (canAssignToC(S[i], E[i])) {
                    validCase += "C";
                } else if (canAssignToJ(S[i], E[i])) {
                    validCase += "J";
                } else {
                    validCase = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + validCase);
        }

        in.close();
    }

    private static boolean canAssignToC(int start, int end) {
        for (int j = 0; j < countC; j++) {
            if (start < cEnd[j] && end > cStart[j]) {
                return false;
            }
        }
        cStart[countC] = start;
        cEnd[countC] = end;
        countC++;
        return true;
    }

    private static boolean canAssignToJ(int start, int end) {
        for (int j = 0; j < countJ; j++) {
            if (start < jEnd[j] && end > jStart[j]) {
                return false;
            }
        }
        jStart[countJ] = start;
        jEnd[countJ] = end;
        countJ++;
        return true;
    }
}