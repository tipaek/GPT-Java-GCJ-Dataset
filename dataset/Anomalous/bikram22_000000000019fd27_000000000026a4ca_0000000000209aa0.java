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
        int result = evaluateK(n, k);

        String possibleMessage = "Case #" + caseNumber + ": POSSIBLE";
        String impossibleMessage = "Case #" + caseNumber + ": IMPOSSIBLE";

        switch (result) {
            case -2:
                System.out.println(impossibleMessage);
                break;
            case -1:
                System.out.println(possibleMessage);
                generateChronoMatrix(n);
                break;
            case -4:
            case -5:
                System.out.println(possibleMessage);
                generateEvenTableMatrix(n, result);
                break;
            default:
                System.out.println(possibleMessage);
                generateConstantMatrix(n, result);
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

    private static int calculateEvenProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 == 0).sum();
    }

    private static int calculateOddProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 != 0).sum();
    }

    private static void generateEvenTableMatrix(int n, int result) {
        boolean isEven = result == -4;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int value = r + c + (isEven ? 2 : 1);
                if (value > n) {
                    value -= n;
                }
                System.out.print(value + (c == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void generateChronoMatrix(int n) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int value = (r + c - 1) % n;
                if (value == 0) {
                    value = n;
                }
                System.out.print(value + (c == n ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void generateConstantMatrix(int n, int e) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int value = (e - r + c) % n;
                if (value <= 0) {
                    value += n;
                }
                System.out.print(value + (c == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}