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
        int[] S = new int[MAX_TASKS];
        int[] E = new int[MAX_TASKS];
        
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            init();
            
            for (int i = 0; i < N; i++) {
                S[i] = in.nextInt();
                E[i] = in.nextInt();
            }
            
            boolean impossible = false;
            for (int i = 0; i < N; i++) {
                if (canAssignTask(S[i], E[i], cStart, cEnd, countC)) {
                    validCase += "C";
                    cStart[countC] = S[i];
                    cEnd[countC] = E[i];
                    countC++;
                } else if (canAssignTask(S[i], E[i], jStart, jEnd, countJ)) {
                    validCase += "J";
                    jStart[countJ] = S[i];
                    jEnd[countJ] = E[i];
                    countJ++;
                } else {
                    validCase = "IMPOSSIBLE";
                    impossible = true;
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + validCase);
        }
        
        in.close();
    }
    
    private static boolean canAssignTask(int start, int end, int[] startTimes, int[] endTimes, int count) {
        for (int i = 0; i < count; i++) {
            if ((start < startTimes[i] && end <= startTimes[i]) || (start >= endTimes[i] && end > endTimes[i])) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}