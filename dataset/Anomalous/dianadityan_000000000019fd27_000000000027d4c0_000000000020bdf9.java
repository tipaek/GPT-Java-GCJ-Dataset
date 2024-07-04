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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();

            init();
            for (int i = 0; i < N; i++) {
                int S = in.nextInt();
                int E = in.nextInt();

                boolean isOverlapC = false;
                for (int j = 0; j < countC; j++) {
                    if (S >= cEnd[j] || E <= cStart[j]) continue;
                    isOverlapC = true;
                    break;
                }

                if (!isOverlapC) {
                    validCase += "C";
                    cStart[countC] = S;
                    cEnd[countC] = E;
                    countC++;
                    continue;
                }

                boolean isOverlapJ = false;
                for (int j = 0; j < countJ; j++) {
                    if (S >= jEnd[j] || E <= jStart[j]) continue;
                    isOverlapJ = true;
                    break;
                }

                if (!isOverlapJ) {
                    validCase += "J";
                    jStart[countJ] = S;
                    jEnd[countJ] = E;
                    countJ++;
                    continue;
                }

                if (isOverlapC && isOverlapJ) {
                    validCase = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + validCase);
        }

        in.close();
    }
}