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

            List<String> result = new ArrayList<>();
            results.add(result);

            if (isImpossible(startTimes, finishTimes, N)) {
                result.add("IMPOSSIBLE");
            } else {
                allocateTasks(startTimes, finishTimes, N, result);
            }
        }

        printResults(results, T);
    }

    private static boolean isImpossible(int[] startTimes, int[] finishTimes, int N) {
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

    private static void allocateTasks(int[] startTimes, int[] finishTimes, int N, List<String> result) {
        int CcurrentStart = -1, CcurrentEnd = -1;
        int JcurrentStart = -1, JcurrentEnd = -1;

        for (int n = 0; n < N; n++) {
            if ((CcurrentStart == -1 || (CcurrentStart >= startTimes[n] && CcurrentStart >= finishTimes[n]) ||
                    (CcurrentStart < startTimes[n] && (CcurrentEnd <= finishTimes[n] && CcurrentEnd <= startTimes[n])))) {
                result.add("C");
                CcurrentStart = startTimes[n];
                CcurrentEnd = finishTimes[n];
            } else if ((JcurrentStart == -1 || (JcurrentStart >= startTimes[n] && JcurrentStart >= finishTimes[n]) ||
                    (JcurrentStart < startTimes[n] && (JcurrentEnd <= finishTimes[n] && JcurrentEnd <= startTimes[n])))) {
                result.add("J");
                JcurrentStart = startTimes[n];
                JcurrentEnd = finishTimes[n];
            }
        }
    }

    private static void printResults(List<List<String>> results, int T) {
        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            for (String res : results.get(i)) {
                System.out.print(res);
            }
            System.out.println();
        }
    }
}