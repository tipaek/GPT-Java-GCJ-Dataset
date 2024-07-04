import java.util.*;
import java.io.*;

class Solution {
    public static boolean possible(int N, int K) {
        int max = N * N;
        int min = 1 * N;
        if (K < min || K > max) return false;
        boolean[] pos = new boolean[max + 1];
        Arrays.fill(pos, true);
        for (int i = 1; i <= N; ++i) {
            int same = i * (N - 1);
            for (int j = 1; j <= N; ++j) {
                if (i != j) {
                    pos[same + j] = false;
                }
            }
        }
        return pos[K];
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; ++i) {
            answer.append("Case #" + (i + 1) + ": ");
            int N = scan.nextInt();
            int K = scan.nextInt();
            if (possible(N, K)) {
                answer.append("POSSIBLE\n");
            } else {
                answer.append("IMPOSSIBLE\n");
            }
        }
        System.out.println(answer);
    }
}