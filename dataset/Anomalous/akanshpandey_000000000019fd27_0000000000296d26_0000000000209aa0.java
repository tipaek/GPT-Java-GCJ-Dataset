import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            int N2 = N * N;
            int K = scanner.nextInt();
            int sum = (N2 + N) / 2;
            boolean isImpossible = false;

            if (K < N || K > N2 || (N % 2 == 0 && K == sum) || (K != sum && N2 % K != 0)) {
                isImpossible = true;
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println("POSSIBLE");
                if (K == sum) {
                    for (int row = 0; row < N; row++) {
                        for (int col = 0; col < N; col++) {
                            int value = (row + col + N) % N;
                            if (value == 0) value = N;
                            System.out.print(value + " ");
                        }
                        System.out.println();
                    }
                } else if (N2 % K == 0) {
                    int value = N2 / K;
                    for (int row = 0; row < N; row++) {
                        for (int col = 0; col < N; col++) {
                            if (col != 0) value--;
                            if (value == 0) value = N;
                            System.out.print(value + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }

        scanner.close();
    }
}