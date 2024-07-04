import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            boolean possible = false;
            int R = 1;

            if (K < N * N) {
                for (R = 1; R <= N; R++) {
                    if (R * N == K) {
                        possible = true;
                        break;
                    }
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                printMatrix(N, R);
            }
        }

        scanner.close();
    }

    private static void printMatrix(int N, int R) {
        for (int row = 1; row <= N; row++) {
            int temp = R;

            // Print numbers from R to N
            while (temp <= N) {
                System.out.print(temp + " ");
                temp++;
            }

            // Print numbers from 1 to R-1
            for (int j = 1; j < R; j++) {
                System.out.print(j + " ");
            }

            R--;
            if (R == 0) {
                R = N;
            }
            System.out.println();
        }
    }
}