import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        List<List<String>> results = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[] startTimes = new int[N];
            int[] finishTimes = new int[N];

            for (int j = 0; j < N; j++) {
                startTimes[j] = in.nextInt();
                finishTimes[j] = in.nextInt();
            }

            List<String> schedule = new ArrayList<>();
            results.add(schedule);

            if (isImpossible(N, startTimes, finishTimes)) {
                schedule.add("IMPOSSIBLE");
            } else {
                allocateTasks(N, startTimes, finishTimes, schedule);
            }
        }

        for (int m = 0; m < T; m++) {
            System.out.print("Case #" + (m + 1) + ": ");
            for (String result : results.get(m)) {
                System.out.print(result);
            }
            System.out.println();
        }
    }

    private static boolean isImpossible(int N, int[] startTimes, int[] finishTimes) {
        int ceiling = (int) Math.ceil((double) N / 2);
        for (int n = 0; n < N; n++) {
            int count = 0;
            for (int k = 0; k < N; k++) {
                if (k != n && finishTimes[n] > startTimes[k] && finishTimes[k] > startTimes[n]) {
                    count++;
                }
                if (count >= ceiling) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void allocateTasks(int N, int[] startTimes, int[] finishTimes, List<String> schedule) {
        int[] backlogC = new int[N * 2];
        int[] backlogJ = new int[N * 2];
        int CcurrentStart = -1, CcurrentEnd = -1;
        int JcurrentStart = -1, JcurrentEnd = -1;
        int countC = 0, countJ = 0;

        for (int n = 0; n < N; n++) {
            if (n == 0) {
                schedule.add("C");
                CcurrentStart = startTimes[n];
                CcurrentEnd = finishTimes[n];
                backlogC[countC++] = startTimes[n];
                backlogC[countC++] = finishTimes[n];
            } else if (canAssign(startTimes[n], finishTimes[n], CcurrentStart, CcurrentEnd, backlogC, countC)) {
                schedule.add("C");
                CcurrentStart = startTimes[n];
                CcurrentEnd = finishTimes[n];
                backlogC[countC++] = startTimes[n];
                backlogC[countC++] = finishTimes[n];
            } else if (canAssign(startTimes[n], finishTimes[n], JcurrentStart, JcurrentEnd, backlogJ, countJ)) {
                schedule.add("J");
                JcurrentStart = startTimes[n];
                JcurrentEnd = finishTimes[n];
                backlogJ[countJ++] = startTimes[n];
                backlogJ[countJ++] = finishTimes[n];
            }
        }
    }

    private static boolean canAssign(int startTime, int finishTime, int currentStart, int currentEnd, int[] backlog, int count) {
        if (currentStart == -1 || (currentStart >= finishTime || currentEnd <= startTime)) {
            return true;
        }
        for (int i = 0; i < count; i += 2) {
            if (backlog[i] >= finishTime || backlog[i + 1] <= startTime) {
                return true;
            }
        }
        return false;
    }
}