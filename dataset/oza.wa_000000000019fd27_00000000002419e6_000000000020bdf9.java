import java.util.*;

class Solution {

    private static void solve(int N, Scanner sc, int x) {
        int[] S = new int[N];
        int[] E = new int[N];

        int[] table = new int[1441];
        boolean[][] busy  = new boolean[2][1441]; //0:C, 1:J
        boolean[][] begin = new boolean[2][1441]; //0:C, 1:J

        boolean possible = true;

        for (int i = 0; i < N; i++) {
            S[i] = sc.nextInt();
            E[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int owner = 0;
            for (int j = S[i]; j < E[i]; j++) {
                if (j == S[i]) {
                    if (!busy[0][j]) {
                        owner = 0;
                        begin[0][j] = true;
                    } else if (!busy[1][j]){
                        owner = 1;
                        begin[1][j] = true;
                    } else {
                        possible = false;
                        break;
                    }
                }
                table[j]++;
                busy[owner][j] = true;
            }
            if (!possible) break;
        }


        if (possible) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length; i++) {
                if (begin[0][S[i]]) {
                    sb.append('C');
                } else if (begin[1][S[i]]){
                    sb.append('J');
                } else {
                    System.out.println("Error.");
                    System.exit(1);
                }
            }

            System.out.println(String.format("Case #%d: %s", x, sb.toString()));
        } else {
            System.out.println(String.format("Case #%d: IMPOSSIBLE", x));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            solve(N, sc, i + 1);
        }
    }
}
