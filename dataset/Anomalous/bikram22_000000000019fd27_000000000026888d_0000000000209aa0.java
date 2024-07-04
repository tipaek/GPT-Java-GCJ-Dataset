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
        int sortResult = determineSortType(n, k);
        String casePossible = "Case #" + caseNumber + ": POSSIBLE";
        String caseImpossible = "Case #" + caseNumber + ": IMPOSSIBLE";

        if (n == 1 || sortResult == -2) {
            System.out.println(caseImpossible);
        } else {
            System.out.println(casePossible);
            if (sortResult == -1) {
                generateChronologicalTable(n);
            } else if (sortResult == -4 || sortResult == -5) {
                generateEvenOddTable(n, sortResult);
            } else {
                generateConstantTable(n, sortResult);
            }
        }
    }

    private static int determineSortType(int n, int k) {
        if (n % 2 != 0 && k == IntStream.rangeClosed(1, n).sum()) {
            return -1;
        }

        for (int i = 1; i <= n; i++) {
            if (k == i * n) {
                return i;
            }
        }

        if (n % 2 == 0) {
            if (k == calculateEvenProduct(n)) {
                return -4;
            } else if (k == calculateOddProduct(n)) {
                return -3;
            }
        }

        return -2;
    }

    private static int calculateEvenProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 == 0).sum();
    }

    private static int calculateOddProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 != 0).sum();
    }

    private static void generateChronologicalTable(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                int value = (row + col - 1) % n;
                if (value == 0) value = n;
                System.out.print(value + (col == n ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void generateEvenOddTable(int n, int sortType) {
        boolean isEven = sortType == -4;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = (row + col + (isEven ? 2 : 1)) % n;
                if (value == 0) value = n;
                System.out.print(value + (col == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void generateConstantTable(int n, int constant) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = (constant - row + col) % n;
                if (value <= 0) value += n;
                System.out.print(value + (col == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}