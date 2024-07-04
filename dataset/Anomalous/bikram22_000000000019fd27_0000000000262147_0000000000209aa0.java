import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        int[][] inputs = new int[numCases][2];

        for (int i = 0; i < numCases; i++) {
            inputs[i][0] = scanner.nextInt();
            inputs[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < numCases; i++) {
            processCase(inputs[i][0], inputs[i][1], i + 1);
        }

        scanner.close();
    }

    private static void processCase(int n, int k, int caseNumber) {
        int result = calculateSortK(n, k);

        if (result == -2) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");

            if (result == -1) {
                printChrono(n);
            } else {
                if (n % 2 == 0) {
                    printEvenTable(n, k, result);
                } else {
                    printConstantTable(n, k, result);
                }
            }
        }
    }

    private static int calculateSortK(int n, int k) {
        if (n % 2 != 0) {
            if (k == IntStream.rangeClosed(1, n).sum()) return -1;
            for (int i = 1; i <= n; i++) {
                if (k == i * n) return i;
            }
        } else {
            if (k == calculateEvenProduct(n)) {
                return 2;
            } else if (k == calculateOddProduct(n)) {
                return 1;
            }
        }
        return -2;
    }

    private static void printEvenTable(int n, int k, int sortType) {
        boolean isEven = sortType == 2;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int value = r + c + (isEven ? 2 : 1);
                if (value > n) value -= n;
                System.out.print(value + (c == n - 1 ? "" : " "));
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
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int value = r + c - 1;
                if (value > n) value -= n;
                System.out.print(value + (c == n ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void printConstantTable(int n, int k, int sortType) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int value = sortType - r + c;
                if (value < 1) value += n;
                System.out.print(value + (c == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}