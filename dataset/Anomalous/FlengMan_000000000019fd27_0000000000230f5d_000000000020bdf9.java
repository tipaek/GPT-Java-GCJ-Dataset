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

            List<String> currentResult = new ArrayList<>();
            results.add(currentResult);
            boolean possible = true;
            int ceiling = (int) Math.ceil((double) N / 2);

            for (int n = 0; n < N && possible; n++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (k != n && finishTimes[n] > startTimes[k]) {
                        if (finishTimes[k] > startTimes[n]) {
                            count++;
                        }
                    }
                }
                if (count >= ceiling) {
                    currentResult.add("IMPOSSIBLE");
                    possible = false;
                }
            }

            if (possible) {
                int CcurrentStart = -1;
                int CcurrentEnd = -1;
                int JcurrentStart = -1;
                int JcurrentEnd = -1;

                for (int n = 0; n < N; n++) {
                    if (n == 0) {
                        currentResult.add("C");
                        CcurrentStart = startTimes[n];
                        CcurrentEnd = finishTimes[n];
                    } else {
                        if ((CcurrentStart >= startTimes[n] && CcurrentStart >= finishTimes[n]) ||
                            (CcurrentStart <= startTimes[n] && (CcurrentEnd <= finishTimes[n] && CcurrentEnd <= startTimes[n]) ||
                             CcurrentEnd <= startTimes[n])) {
                            currentResult.add("C");
                            CcurrentStart = startTimes[n];
                            CcurrentEnd = finishTimes[n];
                        } else if ((JcurrentStart >= startTimes[n] && CcurrentStart >= finishTimes[n]) || JcurrentStart == -1 ||
                                   (JcurrentStart <= startTimes[n] && (JcurrentEnd <= finishTimes[n] && JcurrentEnd <= startTimes[n]) ||
                                    JcurrentStart <= startTimes[n])) {
                            currentResult.add("J");
                            JcurrentStart = startTimes[n];
                            JcurrentEnd = finishTimes[n];
                        }
                    }
                }
            }
        }

        for (int m = 0; m < T; m++) {
            System.out.print("Case #" + (m + 1) + ": ");
            for (String res : results.get(m)) {
                System.out.print(res);
            }
            System.out.println();
        }
    }
}