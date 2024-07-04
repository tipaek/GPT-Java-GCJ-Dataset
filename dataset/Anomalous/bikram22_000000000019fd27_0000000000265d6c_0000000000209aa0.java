import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            int[][] inputs = new int[num][2];
            for (int i = 0; i < num; i++) {
                inputs[i][0] = sc.nextInt();
                inputs[i][1] = sc.nextInt();
            }
            for (int i = 0; i < num; i++) {
                processCase(inputs[i][0], inputs[i][1], i + 1);
            }
        }
    }

    private static void processCase(int n, int k, int idx) {
        int result = evaluateK(n, k);
        String casePossible = "Case #" + idx + ": POSSIBLE";
        String caseImpossible = "Case #" + idx + ": IMPOSSIBLE";

        switch (result) {
            case -2:
                System.out.println(caseImpossible);
                break;
            case -1:
                System.out.println(casePossible);
                generateChronoTable(n);
                break;
            case -4:
            case -5:
                System.out.println(casePossible);
                generateEvenTable(n, result);
                break;
            default:
                System.out.println(casePossible);
                generateConstantTable(n, result);
                break;
        }
    }

    private static int evaluateK(int n, int k) {
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

    private static void generateEvenTable(int n, int result) {
        boolean isEven = result == -4;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int value = isEven ? r + c + 2 : r + c + 1;
                if (value > n) {
                    value -= n;
                }
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

    private static void generateChronoTable(int n) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int value = r + c - 1;
                if (value > n) {
                    value -= n;
                }
                System.out.print(value + (c == n ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void generateConstantTable(int n, int constant) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int value = constant - r + c;
                if (value < 1) {
                    value += n;
                } else if (value > n) {
                    value -= n;
                }
                System.out.print(value + (c == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}