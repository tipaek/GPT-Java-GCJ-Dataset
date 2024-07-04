import java.util.Scanner;

public class Solution {
    static final int LIMIT = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            solve(sc, A, B);
        }

        sc.close();
    }

    static void solve(Scanner sc, int A, int B) {
        int minX = -LIMIT;
        while (true) {
            System.out.println(String.format("%d 0", minX));
            System.out.flush();

            String result = sc.next();
            if (result.equals("CENTER")) {
                return;
            }
            if (result.equals("HIT")) {
                break;
            }

            ++minX;
        }

        int maxX = LIMIT;
        while (true) {
            System.out.println(String.format("%d 0", maxX));
            System.out.flush();

            String result = sc.next();
            if (result.equals("CENTER")) {
                return;
            }
            if (result.equals("HIT")) {
                break;
            }

            --maxX;
        }

        int X = (minX + maxX) / 2;
        for (int Y = -50;; ++Y) {
            System.out.println(String.format("%d %d", X, Y));
            System.out.flush();

            String result = sc.next();
            if (result.equals("CENTER")) {
                return;
            }
        }
    }
}