import java.util.Scanner;

class Solution {

    private static final long CAP = 1_000_000_000L;

    private static int guess(Scanner scanner, long x, long y) {
        System.out.printf("%d %d%n", x, y);
        System.out.flush();
        String response = scanner.next();

        switch (response) {
            case "CENTER":
                return 0;
            case "HIT":
                return 1;
            case "MISS":
                return -1;
            default:
                throw new IllegalStateException("Unexpected response: " + response);
        }
    }

    private static void handle(Scanner scanner, long a, long b) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                if (guess(scanner, i, j) == 0) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            for (int i = 0; i < testCases; i++) {
                handle(scanner, a, b);
            }
        }
    }
}