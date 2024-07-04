import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        for (int testcase = 1; testcase <= T; testcase++) {
            boolean hit = false;
            int hitX = 0, hitY = 0;

            // Find an initial hit point
            while (!hit) {
                int guessX = (int) (2 * Math.pow(10, 9) * Math.random() - Math.pow(10, 9));
                int guessY = (int) (2 * Math.pow(10, 9) * Math.random() - Math.pow(10, 9));
                System.out.println(guessX + " " + guessY);
                String response = sc.next();
                if (response.equals("HIT")) {
                    hitX = guessX;
                    hitY = guessY;
                    hit = true;
                }
            }

            int rx1 = findBoundary(sc, hitX, 0, -1);
            int rx2 = findBoundary(sc, hitX, 0, 1);
            int ry1 = findBoundary(sc, hitY, 1, -1);
            int ry2 = findBoundary(sc, hitY, 1, 1);

            int centerX = (rx1 + rx2) / 2;
            int centerY = (ry1 + ry2) / 2;

            if (!searchCenter(sc, centerX, centerY)) {
                for (int i = 0; i < 49; i++) {
                    int guessX = centerX - 3 + i % 7;
                    int guessY = centerY - 3 + i / 7;
                    System.out.println(guessX + " " + guessY);
                    if (sc.next().equals("CENTER")) break;
                }
            }
        }
    }

    private static int findBoundary(Scanner sc, int start, int axis, int direction) {
        int inc = (int) Math.pow(10, 7) * 2;
        int a = start + direction * inc;
        int b = a + direction * inc;

        while (true) {
            String response = "";
            do {
                a += direction * inc;
                b += direction * inc;
                if (axis == 0) {
                    System.out.println(b + " 0");
                } else {
                    System.out.println("0 " + b);
                }
                response = sc.next();
            } while (response.equals("MISS"));

            if (response.equals("CENTER")) {
                return 0;
            } else {
                while (a + 1 != b) {
                    int mid = (a + b) / 2;
                    if (axis == 0) {
                        System.out.println(mid + " 0");
                    } else {
                        System.out.println("0 " + mid);
                    }
                    response = sc.next();
                    if (response.equals("MISS")) {
                        a = mid;
                    } else {
                        b = mid;
                    }
                }
                return a;
            }
        }
    }

    private static boolean searchCenter(Scanner sc, int centerX, int centerY) {
        for (int i = 0; i < 49; i++) {
            int guessX = centerX - 3 + i % 7;
            int guessY = centerY - 3 + i / 7;
            System.out.println(guessX + " " + guessY);
            if (sc.next().equals("CENTER")) {
                return true;
            }
        }
        return false;
    }
}