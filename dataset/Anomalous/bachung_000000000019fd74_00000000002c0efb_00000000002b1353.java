import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= testCases; i++) {
                processTestCase(reader, i);
            }
        }
    }

    private static void processTestCase(BufferedReader reader, int caseNumber) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        System.out.printf("Case #%d:%n", caseNumber);
        if (n <= 500) {
            printSequence(n, 1);
        } else if (n == 501) {
            printSpecialSequence(n);
        }
    }

    private static void printSequence(int length, int fixedColumn) {
        for (int i = 1; i <= length; i++) {
            System.out.printf("%d %d%n", i, fixedColumn);
        }
    }

    private static void printSpecialSequence(int length) {
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("2 2");
        System.out.println("3 2");
        for (int i = 5; i < length; i++) {
            System.out.printf("%d %d%n", i - 2, 1);
        }
    }
}