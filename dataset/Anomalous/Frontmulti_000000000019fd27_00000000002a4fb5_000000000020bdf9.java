import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int N;
    static int[] startTimes, endTimes;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(reader.readLine());
            startTimes = new int[N + 1];
            endTimes = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                startTimes[i] = Integer.parseInt(tokenizer.nextToken());
                endTimes[i] = Integer.parseInt(tokenizer.nextToken());
            }
            processTestCase(testCase);
        }
        reader.close();
    }

    private static void processTestCase(int testCase) {
        for (int i = 1; i <= N; i++) {
            int start = startTimes[i];
            int end = endTimes[i];
            int overlapCount = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (start < startTimes[j] && endTimes[j] < end) {
                    overlapCount++;
                }
            }
            if (overlapCount >= 2) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }

        boolean[] cameronSchedule = new boolean[1441];
        boolean[] jamieSchedule = new boolean[1441];
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int start = startTimes[i];
            int end = endTimes[i];

            boolean isCameronAvailable = true;
            for (int j = start + 1; j <= end - 1; j++) {
                if (cameronSchedule[j]) {
                    isCameronAvailable = false;
                    break;
                }
            }
            if (isCameronAvailable) {
                for (int j = start; j <= end; j++) {
                    cameronSchedule[j] = true;
                }
                result.append("C");
            } else {
                for (int j = start; j <= end; j++) {
                    jamieSchedule[j] = true;
                }
                result.append("J");
            }
        }

        System.out.println("Case #" + testCase + ": " + result.toString());
    }
}