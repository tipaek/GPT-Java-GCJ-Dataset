import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        final int INC = (int) Math.pow(10, 7) * 2;
        final int MAX = (int) Math.pow(10, 9);

        for (int testcase = 1; testcase <= T; testcase++) {
            int rx1 = findBoundary(sc, -MAX - INC, INC, true, false);
            int rx2 = findBoundary(sc, MAX + INC, -INC, true, true);
            int ry1 = findBoundary(sc, MAX + INC, -INC, false, true);

            int ox = (rx1 + rx2) / 2;
            int oy = ry1 / 2;

            if (!tryCenter(sc, ox, oy)) {
                for (int i = 0; i < 25; i++) {
                    int giskx = ox - 2 + i % 5;
                    int gisky = oy - 2 + i / 5;
                    if (tryCenter(sc, giskx, gisky)) break;
                }
            }
        }
    }

    private static int findBoundary(Scanner sc, int start, int inc, boolean isX, boolean decreasing) {
        int a = start;
        int b = start + inc;
        boolean found = false;
        boolean midja = false;

        while (!found && !midja) {
            String response;
            do {
                a += inc;
                b += inc;
                System.out.println((isX ? b : 0) + " " + (isX ? 0 : b));
                response = sc.next();
            } while (response.equals("MISS"));

            if (response.equals("CENTER")) {
                midja = true;
            } else {
                while (a + 1 < b) {
                    int c = (a + b) / 2;
                    System.out.println((isX ? c : 0) + " " + (isX ? 0 : c));
                    response = sc.next();
                    if (response.equals("MISS")) {
                        if (decreasing) {
                            b = c;
                        } else {
                            a = c;
                        }
                    } else if (response.equals("HIT")) {
                        if (decreasing) {
                            a = c;
                        } else {
                            b = c;
                        }
                    } else {
                        midja = true;
                        break;
                    }
                }
                if (!midja) found = true;
            }
        }
        return a;
    }

    private static boolean tryCenter(Scanner sc, int x, int y) {
        System.out.println(x + " " + y);
        return sc.next().equals("CENTER");
    }
}