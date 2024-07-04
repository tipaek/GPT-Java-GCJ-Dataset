import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        for (int testcase = 1; testcase <= T; testcase++) {
            boolean hit = false;
            int mx = 0, my = 0;

            while (!hit) {
                int guessX = (int) (2 * Math.pow(10, 9) * Math.random() - Math.pow(10, 9));
                int guessY = (int) (2 * Math.pow(10, 9) * Math.random() - Math.pow(10, 9));
                System.out.println(guessX + " " + guessY);
                String response = sc.next();

                if (response.equals("HIT")) {
                    mx = guessX;
                    my = guessY;
                    hit = true;
                }
            }

            int rx1 = findBoundary(sc, -Math.pow(10, 9), Math.pow(10, 9), 0, true);
            int rx2 = findBoundary(sc, Math.pow(10, 9), -Math.pow(10, 9), 0, false);
            int ry1 = findBoundary(sc, Math.pow(10, 9), -Math.pow(10, 9), rx2, false);

            int ox = (rx1 + rx2) / 2;
            int oy = ry1 / 2;

            if (!hit) {
                for (int i = 0; i < 49; i++) {
                    int guessX = ox - 3 + i % 7;
                    int guessY = oy - 3 + i / 7;
                    System.out.println(guessX + " " + guessY);
                    if (sc.next().equals("CENTER")) break;
                }
            }
        }
    }

    private static int findBoundary(Scanner sc, double start, double end, int fixedCoord, boolean isX) {
        int inc = (int) (Math.pow(10, 7)) * 2;
        int a = (int) start - inc;
        int b = a + inc;
        boolean found = false;

        while (!found) {
            String response;
            do {
                a += inc;
                b += inc;
                if (isX) {
                    System.out.println(b + " " + fixedCoord);
                } else {
                    System.out.println(fixedCoord + " " + a);
                }
                response = sc.next();
            } while (response.equals("MISS"));

            if (response.equals("CENTER")) {
                found = true;
                break;
            } else {
                while (a + 1 < b) {
                    int mid = (a + b) / 2;
                    if (isX) {
                        System.out.println(mid + " " + fixedCoord);
                    } else {
                        System.out.println(fixedCoord + " " + mid);
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
                        found = true;
                        break;
                    }
                }
                found = true;
            }
        }
        return isX ? a : b;
    }
}