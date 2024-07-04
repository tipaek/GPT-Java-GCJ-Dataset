import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            int bitLength = scanner.nextInt();

            for (int i = 1; i <= testCases; i++) {
                handleTestCase(i, bitLength, scanner);
            }
        }
    }

    private static void handleTestCase(int caseNumber, int bitLength, Scanner scanner) {
        if (bitLength != 10) {
            throw new IllegalArgumentException("Only support bit length of 10 for now");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= bitLength; i++) {
            System.out.println(i);
            System.out.flush();

            String response = scanner.next();

            if ("N".equals(response)) {
                return;
            }

            result.append(response);
        }

        System.out.println(result.toString());
        System.out.flush();

        String finalResponse = scanner.next();
    }
}