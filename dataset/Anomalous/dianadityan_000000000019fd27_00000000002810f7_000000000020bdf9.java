import java.util.*;
import java.io.*;

public class Solution {
    private static int[] CStart = new int[1000];
    private static int[] CEnd = new int[1000];
    private static int[] JStart = new int[1000];
    private static int[] JEnd = new int[1000];
    private static String validCase;
    private static int countC, countJ;

    private static void init(int N) {
        validCase = "";
        countC = 0;
        countJ = 0;
        Arrays.fill(CStart, 0, N, -1);
        Arrays.fill(CEnd, 0, N, -1);
        Arrays.fill(JStart, 0, N, -1);
        Arrays.fill(JEnd, 0, N, -1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        int[] S = new int[1000];
        int[] E = new int[1000];

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            init(N);

            for (int i = 0; i < N; i++) {
                S[i] = in.nextInt();
                E[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                if (canAssignTask(S[i], E[i], CStart, CEnd, countC)) {
                    validCase += "J";
                    CStart[countC] = S[i];
                    CEnd[countC] = E[i];
                    countC++;
                } else if (canAssignTask(S[i], E[i], JStart, JEnd, countJ)) {
                    validCase += "C";
                    JStart[countJ] = S[i];
                    JEnd[countJ] = E[i];
                    countJ++;
                } else {
                    validCase = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + validCase);
        }

        in.close();
    }

    private static boolean canAssignTask(int start, int end, int[] startArray, int[] endArray, int count) {
        for (int j = 0; j < count; j++) {
            if (!((start < startArray[j] && end <= startArray[j]) || (start >= endArray[j] && end > endArray[j]))) {
                return false;
            }
        }
        return true;
    }
}