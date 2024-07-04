import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            run();
        }
    }

    private static void run() {
        int count = 0;
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= -5; j++) { // Note: This loop will only run once because j is always -5
                count++;
                if (count > 300) {
                    return;
                }
                System.out.printf("%d %d%n", i, j);
                System.out.flush();

                String response = scanner.next();
                if ("CENTER".equals(response)) {
                    return;
                } 
                // No action needed for "MISS" or "HIT"
            }
        }
    }
}