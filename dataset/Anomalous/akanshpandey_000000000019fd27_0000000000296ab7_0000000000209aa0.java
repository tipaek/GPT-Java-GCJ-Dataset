import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            int N2 = N * N;
            int K = scanner.nextInt();
            int sum = (N2 + N) / 2;
            boolean isImpossible = isImpossible(N, K, N2, sum);

            System.out.print("Case #" + caseNumber + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println("POSSIBLE");
                if (K == sum) {
                    printMatrix(N);
                } else if (N2 % K == 0) {
                    printMatrixWithRemainder(N, N2 / K);
                }
            }
        }
    }

    private static boolean isImpossible(int N, int K, int N2, int sum) {
        return K < N || K > N2 || (N % 2 == 0 && K == sum) || (K != sum && N2 % K != 0);
    }

    private static void printMatrix(int N) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int value = (row + col + N) % N;
                if (value == 0) value = N;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrixWithRemainder(int N, int remainder) {
        int value = remainder;
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