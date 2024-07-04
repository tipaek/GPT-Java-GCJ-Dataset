import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] S = new int[N], E = new int[N];

            for (int i = 0; i < N; i++) {
                S[i] = sc.nextInt();
                E[i] = sc.nextInt();
            }
            System.out.println("Case #" + test_case + ": " + solve(S, E));
        }
        sc.close();
    }

    static String solve (int[] S, int[] E) {
        // S = start time, E = end time

        if (S == null || E == null || S.length < 1 || E.length < 1 || S.length != E.length) return "IMPOSSIBLE";
        int N = S.length;

        // sorting S[] and E[] based on end times

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < N; i++) {
            map.put(E[i], S[i]);
        }
        Arrays.sort(E);
        for (int i = 0; i < N; i++) {
            S[i] = map.get(E[i]);
        }

        StringBuilder builder = new StringBuilder();
        builder.append("C");
        boolean isPreviousC = true;

        if (N == 1) {
            return builder.toString();
        }

        for (int i = 1; i < N; i++) {
            if (S[i] < E[i-1]) {
                // overlapping
                builder.append(isPreviousC ? "J" : "C");
                isPreviousC = !isPreviousC;
            } else {
                // non overlapping
                builder.append(isPreviousC ? "C" : "J");
            }
        }
        return builder.toString();
    }


}
