import java.util.Scanner;

class Solution {
    public static boolean isPossible(int N, int K) {
        int sumEven = (N * (2 + N)) / 4;
        int sumOdd = (N + 1) * (1 + N) / 4;
        
        if (K == sumEven || K == sumOdd) {
            return true;
        }
        
        for (int i = 1; i <= N; ++i) {
            if (K == (i * N)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < T; ++i) {
            result.append("Case #").append(i + 1).append(": ");
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            
            if (isPossible(N, K)) {
                result.append("POSSIBLE\n");
            } else {
                result.append("IMPOSSIBLE\n");
            }
        }
        
        System.out.print(result);
    }
}