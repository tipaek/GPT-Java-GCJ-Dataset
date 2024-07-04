import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        final int INC = (int) Math.pow(10, 7);
        final int LIMIT = (int) Math.pow(10, 9);

        for (int testcase = 1; testcase <= T; testcase++) {
            boolean foundCenter = false;
            int rx1 = findBoundary(sc, -LIMIT - 2 * INC, 0, INC, true);
            if (rx1 == Integer.MIN_VALUE) {
                foundCenter = true;
            }

            if (!foundCenter) {
                int rx2 = findBoundary(sc, LIMIT + 2 * INC, 0, -INC, true);
                if (rx2 == Integer.MIN_VALUE) {
                    foundCenter = true;
                }

                if (!foundCenter) {
                    int ry1 = findBoundary(sc, LIMIT + 2 * INC, 0, -INC, false);
                    if (ry1 == Integer.MIN_VALUE) {
                        foundCenter = true;
                    }

                    if (!foundCenter) {
                        int ox = (rx1 + rx2) / 2;
                        int oy = ry1 / 2;
                        for (int i = 0; i < 25; i++) {
                            int guessX = ox - 2 + i % 5;
                            int guessY = oy - 2 + i / 5;
                            System.out.println(guessX + " " + guessY);
                            if (sc.next().equals("CENTER")) break;
                        }
                    }
                }
            }
        }
    }

    private static int findBoundary(Scanner sc, int start, int y, int inc, boolean isX) {
        int a = start;
        int b = a + inc;
        while (true) {
            String response;
            do {
                a += inc;
                b += inc;
                if (isX) {
                    System.out.println(b + " " + y);
                } else {
                    System.out.println(y + " " + b);
                }
                response = sc.next();
            } while (response.equals("MISS"));

            if (response.equals("CENTER")) {
                return Integer.MIN_VALUE;
            }

            while (a + 1 < b) {
                int mid = (a + b) / 2;
                if (isX) {
                    System.out.println(mid + " " + y);
                } else {
                    System.out.println(y + " " + mid);
                }
                response = sc.next();
                if (response.equals("MISS")) {
                    if (isX) {
                        a = mid;
                    } else {
                        b = mid;
                    }
                } else if (response.equals("HIT")) {
                    if (isX) {
                        b = mid;
                    } else {
                        a = mid;
                    }
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            return a;
        }
    }
}