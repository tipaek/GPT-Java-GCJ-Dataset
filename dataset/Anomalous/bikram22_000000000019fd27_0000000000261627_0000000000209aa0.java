import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] inputs = new int[num][2];

        for (int i = 0; i < num; i++) {
            inputs[i][0] = sc.nextInt();
            inputs[i][1] = sc.nextInt();
        }

        for (int i = 0; i < num; i++) {
            processCase(inputs[i][0], inputs[i][1], i + 1);
        }

        sc.close();
    }

    private static void processCase(int n, int k, int caseNumber) {
        int sortResult = determineSortType(n, k);

        if (sortResult == -2) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else if (sortResult == -1) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            generateChronologicalTable(n);
        } else {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            if (n % 2 == 0) {
                generateEvenTable(n, sortResult);
            } else {
                generateConstantTable(n, sortResult);
            }
        }
    }

    private static int determineSortType(int n, int k) {
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

    private static void generateEvenTable(int n, int sortType) {
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

    private static void generateChronologicalTable(int n) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int value = r + c - 1;
                if (value > n) value -= n;
                System.out.print(value + (c == n ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void generateConstantTable(int n, int sortType) {
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