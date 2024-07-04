import java.util.*;

class Solution {
    public static boolean isPossible(int N, int K) {
        int maxSum = N * N;
        int minSum = N;
        if (K < minSum || K > maxSum) return false;

        boolean[] possibleSums = new boolean[maxSum + 1];
        Arrays.fill(possibleSums, true);

        for (int i = 1; i <= N; ++i) {
            int baseSum = i * (N - 1);
            for (int j = 1; j <= N; ++j) {
                if (i != j) {
                    possibleSums[baseSum + j] = false;
                }
            }
        }
        return possibleSums[K];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; ++t) {
            result.append("Case #").append(t).append(": ");
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