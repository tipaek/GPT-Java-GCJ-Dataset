import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX_TASKS = 1000;
    private static int[] CStart = new int[MAX_TASKS];
    private static int[] CEnd = new int[MAX_TASKS];
    private static int[] JStart = new int[MAX_TASKS];
    private static int[] JEnd = new int[MAX_TASKS];
    private static String validCase;
    private static int countC, countJ;

    private static void init() {
        validCase = "";
        countC = 0;
        countJ = 0;
        Arrays.fill(CStart, 0);
        Arrays.fill(CEnd, 0);
        Arrays.fill(JStart, 0);
        Arrays.fill(JEnd, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner in = new Scanner(new File("./input.txt"));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();

            init();
            int[] S = new int[N];
            int[] E = new int[N];

            for (int i = 0; i < N; i++) {
                S[i] = in.nextInt();
                E[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                boolean isOverlapC = false;
                for (int j = 0; j < countC; j++) {
                    if (S[i] < CEnd[j] && E[i] >= CStart[j]) {
                        isOverlapC = true;
                        break;
                    }
                }
                if (!isOverlapC) {
                    validCase += "C";
                    CStart[countC] = S[i];
                    CEnd[countC] = E[i];
                    countC++;
                    continue;
                }

                boolean isOverlapJ = false;
                for (int j = 0; j < countJ; j++) {
                    if (S[i] < JEnd[j] && E[i] >= JStart[j]) {
                        isOverlapJ = true;
                        break;
                    }
                }
                if (!isOverlapJ) {
                    validCase += "J";
                    JStart[countJ] = S[i];
                    JEnd[countJ] = E[i];
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