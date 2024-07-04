import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            run();
        }
    }

    private static void run() {
        int cnt = 0;
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                cnt++;
                if (cnt > 300) {
                    return;
                }
                System.out.printf("%d %d%n", i, j);
                String answer = scanner.next();
                if ("CENTER".equals(answer)) {
                    return;
                }
            }
        }
    }
}