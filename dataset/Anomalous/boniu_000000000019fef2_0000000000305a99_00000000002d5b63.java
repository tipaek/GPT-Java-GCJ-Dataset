import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            executeTest();
        }
    }

    private static void executeTest() {
        int attemptCount = 0;

        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                attemptCount++;

                if (attemptCount > 300) {
                    return;
                }

                System.out.println(i);
                System.out.println(j);
                System.out.flush();

                String response = scanner.next();
                if ("CENTER".equals(response)) {
                    return;
                } else if ("WRONG".equals(response)) {
                    System.exit(0);
                }
            }
        }
    }
}