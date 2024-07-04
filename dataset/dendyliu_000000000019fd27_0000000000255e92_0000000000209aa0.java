import java.util.*;
import java.io.*;

class Solution {
    public static boolean possible(int N, int K) {
        int sumEven = (N * (2 + N)) / 4;
        int sumOdd = (N + 1) * (1 + N) / 4;
        if (K == sumEven || K == sumOdd) return true;
        for (int i = 1; i <= N; ++i) {
            if (K == (i * N)) return true;
        }
        return false;
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