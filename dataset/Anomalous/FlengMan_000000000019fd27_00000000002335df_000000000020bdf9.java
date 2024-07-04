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
            boolean possible = true;
            int ceiling = (int) Math.ceil((double) N / 2);

            for (int n = 0; n < N; n++) {
                int count = 0;
                if (possible) {
                    for (int k = 0; k < N; k++) {
                        if (k != n && finishTimes[n] > startTimes[k] && finishTimes[k] > startTimes[n]) {
                            count++;
                        }
                        if (count >= ceiling) {
                            result.add("IMPOSSIBLE");
                            possible = false;
                            break;
                        }
                    }
                }
            }

            if (possible) {
                int[] backlogC = new int[N * 2];
                int[] backlogJ = new int[N * 2];
                int CcurrentStart = -1, CcurrentEnd = -1;
                int JcurrentStart = -1, JcurrentEnd = -1;
                int countC = 0, countJ = 0;

                for (int n = 0; n < N; n++) {
                    if (n == 0) {
                        result.add("C");
                        CcurrentStart = startTimes[n];
                        CcurrentEnd = finishTimes[n];
                    } else {
                        boolean assigned = false;
                        if (isNonOverlapping(CcurrentStart, CcurrentEnd, startTimes[n], finishTimes[n])) {
                            if (isNonOverlappingWithBacklog(backlogC, countC, startTimes[n], finishTimes[n])) {
                                result.add("J");
                                JcurrentStart = startTimes[n];
                                JcurrentEnd = finishTimes[n];
                                backlogJ[countJ++] = startTimes[n];
                                backlogJ[countJ++] = finishTimes[n];
                                assigned = true;
                            }
                        }
                        if (!assigned && (JcurrentStart == -1 || isNonOverlapping(JcurrentStart, JcurrentEnd, startTimes[n], finishTimes[n]))) {
                            if (isNonOverlappingWithBacklog(backlogJ, countJ, startTimes[n], finishTimes[n])) {
                                result.add("C");
                                CcurrentStart = startTimes[n];
                                CcurrentEnd = finishTimes[n];
                                backlogC[countC++] = startTimes[n];
                                backlogC[countC++] = finishTimes[n];
                            }
                        } else if (!assigned) {
                            result.add("J");
                            JcurrentStart = startTimes[n];
                            JcurrentEnd = finishTimes[n];
                            backlogJ[countJ++] = startTimes[n];
                            backlogJ[countJ++] = finishTimes[n];
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

    private static boolean isNonOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 >= end2 || end1 <= start2);
    }

    private static boolean isNonOverlappingWithBacklog(int[] backlog, int count, int start, int end) {
        for (int i = 0; i < count; i += 2) {
            if (!isNonOverlapping(backlog[i], backlog[i + 1], start, end)) {
                return false;
            }
        }
        return true;
    }
}