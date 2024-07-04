import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            result.append("Case #").append(i).append(": ");
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int sum = K / N;

            if (K % N == 0 && sum <= N) {
                result.append("POSSIBLE\n");
                StringBuilder[] rows = new StringBuilder[N];
                for (int j = 0; j < N; j++) {
                    rows[j] = new StringBuilder();
                }

                for (int j = 0; j < N; j++) {
                    for (int k = 1; k <= N; k++) {
                        rows[j].append((k + j - 1) % N + 1).append(" ");
                    }
                    rows[j].append("\n");
                }

                result.append(rows[sum - 1]);
                for (int j = 0; j < N; j++) {
                    if (j != sum - 1) {
                        result.append(rows[j]);
                    }
                }
            } else {
                result.append("IMPOSSIBLE\n");
            }
        }

        System.out.print(result.toString());
    }
}