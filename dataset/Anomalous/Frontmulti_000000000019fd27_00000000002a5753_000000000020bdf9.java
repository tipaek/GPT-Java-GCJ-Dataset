import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int N;
    static int[] S, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            S = new int[N + 1];
            E = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                S[i] = Integer.parseInt(st.nextToken());
                E[i] = Integer.parseInt(st.nextToken());
            }
            solve(testCase);
        }
        br.close();
    }

    private static void solve(int testCase) {
        // Check for impossible cases
        for (int i = 1; i <= N; i++) {
            int start = S[i];
            int end = E[i];
            int overlapCount = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (start <= S[j] && E[j] <= end) {
                    overlapCount++;
                }
            }
            if (overlapCount >= 2) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }

        boolean[] cameron = new boolean[1441];
        boolean[] jamie = new boolean[1441];
        StringBuilder result = new StringBuilder();

        // Schedule jobs
        for (int i = 1; i <= N; i++) {
            int start = S[i];
            int end = E[i];
            boolean canAssignToCameron = true;

            for (int j = start + 1; j <= end - 1; j++) {
                if (cameron[j]) {
                    canAssignToCameron = false;
                    break;
                }
            }
            if (canAssignToCameron) {
                for (int j = start; j <= end; j++) {
                    cameron[j] = true;
                }
                result.append("C");
            } else {
                for (int j = start; j <= end; j++) {
                    jamie[j] = true;
                }
                result.append("J");
            }
        }

        System.out.println("Case #" + testCase + ": " + result.toString());
    }
}