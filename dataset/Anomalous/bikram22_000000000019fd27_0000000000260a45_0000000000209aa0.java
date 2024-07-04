import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        int[][] inputs = new int[cases][2];

        for (int i = 0; i < cases; i++) {
            inputs[i][0] = scanner.nextInt();
            inputs[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < cases; i++) {
            processCase(inputs[i][0], inputs[i][1], i + 1);
        }

        scanner.close();
    }

    private static void processCase(int n, int k, int caseIndex) {
        int result = evaluateSortK(n, k);

        if (result == -2) {
            System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
        } else if (result == -1) {
            System.out.println("Case #" + caseIndex + ": POSSIBLE");
            printChrono(n);
        } else {
            System.out.println("Case #" + caseIndex + ": POSSIBLE");
            if (n % 2 == 0) {
                printEvenTable(n, k, result);
            } else {
                printConstantTable(n, k, result);
            }
        }
    }

    private static int evaluateSortK(int n, int k) {
        if (n % 2 != 0) {
            if (k == IntStream.rangeClosed(1, n).sum()) return -1;
            for (int i = 1; i <= n; i++) {
                if (k == i * n) return i;
            }
        } else {
            if (k == calculateEvenProduct(n)) return 2;
            if (k == calculateOddProduct(n)) return 1;
        }
        return -2;
    }

    private static void printEvenTable(int n, int k, int factor) {
        boolean isEven = (factor == 2);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = isEven ? row + col + 2 : row + col + 1;
                if (value > n) value -= n;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int calculateEvenProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 == 0).sum();
    }

    private static int calculateOddProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 != 0).sum();
    }

    private static void printChrono(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                int value = (row + col - 1);
                if (value > n) value -= n;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void printConstantTable(int n, int k, int factor) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = (factor - row) + col;
                if (value < 1) value += n;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}