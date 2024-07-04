import java.util.*;
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
        int sortResult = evaluateSortK(n, k);
        String casePossible = "Case #" + caseNumber + ": POSSIBLE";
        String caseImpossible = "Case #" + caseNumber + ": IMPOSSIBLE";
        
        switch (sortResult) {
            case -2:
                System.out.println(caseImpossible);
                break;
            case -1:
                System.out.println(casePossible);
                printChronologicalTable(n);
                break;
            case -4:
            case -5:
                System.out.println(casePossible);
                printEvenTable(n, sortResult == -4);
                break;
            default:
                System.out.println(casePossible);
                printConstantTable(n, sortResult);
                break;
        }
    }

    private static int evaluateSortK(int n, int k) {
        int sumOfFirstNNumbers = IntStream.rangeClosed(1, n).sum();
        if (k == sumOfFirstNNumbers) return -1;
        
        for (int i = 1; i <= n; i++) {
            if (k == i * n) return i;
        }
        
        if (n % 2 == 0) {
            if (k == calculateEvenProduct(n)) return -4;
            if (k == calculateOddProduct(n)) return -3;
        }
        
        return -2;
    }

    private static void printEvenTable(int n, boolean isEven) {
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

    private static void printChronologicalTable(int n) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int value = (r + c - 1) % n;
                if (value == 0) value = n;
                System.out.print(value + (c == n ? "" : " "));
            }
            System.out.println();
        }
    }

    private static void printConstantTable(int n, int constant) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int value = (constant - r + c) % n;
                if (value <= 0) value += n;
                System.out.print(value + (c == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}