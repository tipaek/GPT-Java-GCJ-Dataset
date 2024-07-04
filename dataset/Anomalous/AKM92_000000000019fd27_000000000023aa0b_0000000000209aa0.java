import java.util.Scanner;

public class Solution {

    public static int computeSum(int N) {
        if (N == 1) {
            return 1;
        }
        return N + computeSum(N - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            boolean isPossible = true;

            if (K >= N) {
                if (K % N == 0) {
                    int quotient = K / N;
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    for (int j = 0; j < N; j++) {
                        StringBuilder row = new StringBuilder();
                        for (int k = 0; k < N; k++) {
                            int value = (quotient - j + k - 1) % N;
                            row.append(value + 1).append(" ");
                        }
                        System.out.println(row.toString().trim());
                    }
                } else {
                    isPossible = false;
                }
            } else {
                isPossible = false;
            }

            if (!isPossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}