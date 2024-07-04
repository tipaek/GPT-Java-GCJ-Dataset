import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            executeRun();
            System.out.flush();
        }
    }

    private static void executeRun() {
        int count = 0;
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                count++;
                if (count > 300) {
                    return;
                }
                System.out.println(i + " " + j);
                System.out.flush();

                String response = scanner.next();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }
}