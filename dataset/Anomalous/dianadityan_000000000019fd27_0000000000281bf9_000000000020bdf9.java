import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX_TASKS = 1000;
    private static int[] CStart = new int[MAX_TASKS];
    private static int[] CEnd = new int[MAX_TASKS];
    private static int[] JStart = new int[MAX_TASKS];
    private static int[] JEnd = new int[MAX_TASKS];
    private static char[] validCase = new char[MAX_TASKS];
    private static int countC, countJ;

    private static void init(int N) {
        countC = 0;
        countJ = 0;
        Arrays.fill(validCase, 0, N, '\0');
        Arrays.fill(CStart, 0, N, -1);
        Arrays.fill(CEnd, 0, N, -1);
        Arrays.fill(JStart, 0, N, -1);
        Arrays.fill(JEnd, 0, N, -1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];

            init(N);
            for (int i = 0; i < N; i++) {
                S[i] = in.nextInt();
                E[i] = in.nextInt();
            }

            boolean possible = true;
            for (int i = 0; i < N; i++) {
                if (canAssign(S[i], E[i], CStart, CEnd, countC)) {
                    validCase[i] = 'C';
                    CStart[countC] = S[i];
                    CEnd[countC] = E[i];
                    countC++;
                } else if (canAssign(S[i], E[i], JStart, JEnd, countJ)) {
                    validCase[i] = 'J';
                    JStart[countJ] = S[i];
                    JEnd[countJ] = E[i];
                    countJ++;
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (possible) {
                for (int i = 0; i < N; i++) {
                    System.out.print(validCase[i]);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        in.close();
    }

    private static boolean canAssign(int start, int end, int[] startTimes, int[] endTimes, int count) {
        for (int i = 0; i < count; i++) {
            if (!(end <= startTimes[i] || start >= endTimes[i])) {
                return false;
            }
        }
        return true;
    }
}