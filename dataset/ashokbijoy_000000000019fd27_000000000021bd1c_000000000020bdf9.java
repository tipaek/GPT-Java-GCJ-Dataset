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
        if (S.length == 1) return "C";
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

        int[] partition = new int[N];

        partition[0] = 1;
        boolean isLastOne = true;

        for (int i = 1; i < N; i++) {
            if (S[i] < E[i-1]) {
                // overlapping

                // keep going left until it stops overlapping
                // if it overlaps only with J, assign this to C, and vice versa
                // if it overlaps with both, return impossible

                boolean overlaps1 = false, overlaps2 = false;

                for (int j = i-1; j >= 0; j--) {
                    if (S[i] >= E[j]) break;

                    if (partition[j] == 1) overlaps1 = true;
                    if (partition[j] == 2) overlaps2 = true;

                    if (overlaps1 && overlaps2) return "IMPOSSIBLE";
                }

                if (overlaps1 && overlaps2) {
                    return "IMPOSSIBLE";
                } else if (overlaps1) {
                    partition[i] = 2;
                    isLastOne = false;
                } else if (overlaps2) {
                    partition[i] = 1;
                    isLastOne = true;
                } else {
                    partition[i] = partition[i-1];
                }
            } else {
                // non overlapping
                partition[i] = isLastOne ? 1 : 2;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (partition[i] == 1) {
                builder.append("C");
            } else if (partition[i] == 2) {
                builder.append("J");
            }
        }
        return builder.toString();
    }


}
