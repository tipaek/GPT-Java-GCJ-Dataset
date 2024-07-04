import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int minRadius = scanner.nextInt();
        int maxRadius = scanner.nextInt();

        final int LOWER_BOUND = -1_000_000_000;
        final int UPPER_BOUND = 1_000_000_000;

        int previousX = 0;
        int previousY = 0;

        for (int i = 0; i < testCases; i++) {
            String feedback = scanner.next();

            int x = LOWER_BOUND + (int) (Math.random() * (UPPER_BOUND - LOWER_BOUND + 1));
            int y = LOWER_BOUND + (int) (Math.random() * (UPPER_BOUND - LOWER_BOUND + 1));

            System.out.printf("%d %d%n", x, y);

            if ("CENTER".equals(feedback)) {
                continue;
            }

            if ("HIT".equals(feedback)) {
                previousX = x;
                previousY = y;
            }

            // No action needed for "MISS" feedback
        }
    }
}