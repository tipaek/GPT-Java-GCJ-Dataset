import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner scr = new Scanner(System.in);
        int T = scr.nextInt();

        if (T < 1 || T > 100) return;

        for (int i = 0; i < T; i++) {
            int N = scr.nextInt();
            if (N < 2 || N > 1000) return;

            StringBuilder outputStr = new StringBuilder();
            int[] S = new int[N];
            int[] E = new int[N];

            for (int j = 0; j < N; j++) {
                S[j] = scr.nextInt();
                E[j] = scr.nextInt();

                if (S[j] < 0 || S[j] > 1440 || E[j] < 0 || E[j] > 1440 || S[j] > E[j]) {
                    outputStr = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (outputStr.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (i + 1) + ": " + outputStr);
                continue;
            }

            int[] indices = new int[N];
            for (int j = 0; j < N; j++) indices[j] = j;

            Arrays.sort(indices, (a, b) -> S[a] - S[b]);

            int C_end = 0, J_end = 0;
            char[] result = new char[N];
            boolean possible = true;

            for (int j = 0; j < N; j++) {
                int idx = indices[j];
                if (S[idx] >= C_end) {
                    result[idx] = 'C';
                    C_end = E[idx];
                } else if (S[idx] >= J_end) {
                    result[idx] = 'J';
                    J_end = E[idx];
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                outputStr = new StringBuilder("IMPOSSIBLE");
            } else {
                for (char c : result) outputStr.append(c);
            }

            System.out.println("Case #" + (i + 1) + ": " + outputStr);
        }
    }
}