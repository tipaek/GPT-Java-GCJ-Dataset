import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + (t + 1) + ": ");
            if (n < 404) {
                printSequence(n, 1, 1);
            } else if (n < 911) {
                printSequence(10, 1, 1);
                printSequence(10, 2, 2);
                printSequence(10, 3, 3);
                printSequence(10, 4, 4);
                printSequence(10, 5, 5);
                printReverseSequence(10, 4, 1);
                printRemaining(n, 404, 11);
            } else {
                printSequence(10, 1, 1);
                printSequence(10, 2, 2);
                printSequence(10, 3, 3);
                printSequence(10, 4, 4);
                printSequence(10, 5, 5);
                printSequence(11, 6, 6);
                printReverseSequence(11, 5, 1);
                printRemaining(n, 912, 12);
            }
        }
        scanner.close();
    }

    private static void printSequence(int limit, int startRow, int endRow) {
        for (int i = startRow; i <= limit; i++) {
            System.out.println(i + " " + endRow);
        }
    }

    private static void printReverseSequence(int startRow, int startCol, int endCol) {
        for (int i = startRow; i >= endCol; i--) {
            System.out.println(startRow + " " + i);
        }
    }

    private static void printRemaining(int n, int total, int start) {
        for (int i = start; total < n; i++, total++) {
            System.out.println(i + " 1");
        }
    }
}