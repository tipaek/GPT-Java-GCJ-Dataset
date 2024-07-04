import java.util.Scanner;

public class Indicium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int cas = 1; cas <= t; cas++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int rtrace = Integer.parseInt(input[1]);
            boolean possible = false;

            for (int i = 1; i <= n; i++) {
                if (rtrace == n * i) {
                    possible = true;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + cas + ": POSSIBLE");
            } else {
                System.out.println("Case #" + cas + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}