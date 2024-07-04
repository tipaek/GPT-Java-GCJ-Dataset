import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[] startTimes = new int[N];
            int[] finishTimes = new int[N];

            for (int j = 0; j < N; j++) {
                startTimes[j] = in.nextInt();
                finishTimes[j] = in.nextInt();
            }

            List<String> stringResults = new ArrayList<>();
            result.add(stringResults);
            boolean possible = true;
            int ceiling = (int) Math.ceil((double) N / 2);

            for (int n = 0; n < N && possible; n++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (k != n && finishTimes[n] > startTimes[k] && finishTimes[k] > startTimes[n]) {
                        count++;
                    }
                    if (count >= ceiling) {
                        stringResults.add("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                int CcurrentStart = -1, CcurrentEnd = -1;
                int JcurrentStart = -1, JcurrentEnd = -1;

                for (int n = 0; n < N; n++) {
                    if (n == 0 || (CcurrentStart >= finishTimes[n] || CcurrentEnd <= startTimes[n])) {
                        stringResults.add("C");
                        CcurrentStart = startTimes[n];
                        CcurrentEnd = finishTimes[n];
                    } else if (JcurrentStart == -1 || (JcurrentStart >= finishTimes[n] || JcurrentEnd <= startTimes[n])) {
                        stringResults.add("J");
                        JcurrentStart = startTimes[n];
                        JcurrentEnd = finishTimes[n];
                    }
                }
            }
        }

        for (int m = 0; m < T; m++) {
            System.out.print("Case #" + (m + 1) + ": ");
            for (String s : result.get(m)) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}