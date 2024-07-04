import java.util.Scanner;

public class Indicium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- != 0) {
            String s = scanner.nextLine();
            int cas = 1;
            int n = Integer.parseInt(s.split(" ")[0]);
            int rtrace = Integer.parseInt(s.split(" ")[1]);
            boolean possible = false; // Using boolean for clarity

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

            cas++;
        }

        scanner.close();
    }
}