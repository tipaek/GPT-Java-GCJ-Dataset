import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            for (int i=0; i<N; i++) {
                S[i] = sc.nextInt();
                E[i] = sc.nextInt();
            }

            System.out.println("Case #" + (t+1) + ": " + solveSmall(N, S, E));
        }
    }

    private static String solve(int N, int[] S, int[] E) {
        StringBuilder sb = new StringBuilder();
        int[] timeline = new int[24*60+1];
        for (int i=0; i<N; i++) {

            timeline[S[i]]++;
            timeline[E[i]]--;
        }




        return sb.toString();
    }

    private static String solveSmall(int N, int[] S, int[] E) {
        for (int i=0; i<Math.pow(2, N); i++) {
            if(valid(i, N, S, E)) {
                return toString(N, i);
            }
        }

        return "IMPOSSIBLE";
    }

    private static boolean valid(int pattern, int N, int[] S, int[] E) {
        boolean[][] timeline = new boolean[24*60][2];

        for (int i=0; i<N; i++) {
            int val = pattern%2 & 1;

            for (int time = S[i]; time < E[i]; time++) {
                if (timeline[time][val]) return false;

                timeline[time][val] = true;
            }

            pattern /= 2;
        }

        return true;
    }

    private static String toString(int N, int pattern) {
        String ans = "";

        for (int i=0; i<N; i++) {
            int val = pattern%2 & 1;
            if (val == 0) {
                ans = ans + "C";
            } else {
                ans = ans + "J";
            }
            pattern /= 2;
        }

        return ans;
    }
}
