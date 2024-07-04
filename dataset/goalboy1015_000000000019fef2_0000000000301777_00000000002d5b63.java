import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            boolean found = false;
            for (int x = -5; x <= 5; ++x) {
                for (int y = -5; y <= 5; ++y) {
                    System.out.println(String.format("%d %d", x, y));

                    String result = sc.next();
                    if (result.equals("CENTER")) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    break;
                }
            }
        }

        sc.close();
    }
}