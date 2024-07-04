import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                handleTestCase(i, scanner);
            }
        }
    }

    private static void handleTestCase(int caseNumber, Scanner scanner) {
        int B = scanner.nextInt();
        if (B != 10) {
            throw new IllegalArgumentException("Only support simple case for now");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= B; i++) {
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
        scanner.next();
    }
}