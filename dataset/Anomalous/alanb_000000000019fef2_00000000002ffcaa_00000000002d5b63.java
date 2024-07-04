import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            boolean hit = false;
            boolean center = false;
            int hitX = 0, hitY = 0;

            for (int i = -1000000000 + a / 2; i <= 1000000000 && !hit && !center; i += a) {
                for (int j = -1000000000 + a / 2; j <= 1000000000 && !hit && !center; j += a) {
                    int result = query(i, j);
                    if (result == 1) {
                        hitX = i;
                        hitY = j;
                        hit = true;
                    } else if (result == 2) {
                        center = true;
                    }
                }
            }

            int dist = Math.abs(hitX + 1000000000) / 4;
            int x1 = (hitX - 1000000000) / 2;
            int x2 = (hitX + 1000000000) / 2;
            int y1 = (hitY - 1000000000) / 2;
            int y2 = (hitY + 1000000000) / 2;

            while (dist > 0 && !center) {
                int result = query(x1, hitY);
                if (result == 0) {
                    x1 += dist;
                } else if (result == 1) {
                    x1 -= dist;
                } else {
                    center = true;
                }
                dist >>= 1;
            }

            dist = Math.abs(1000000000 - hitX) / 4;
            while (dist > 0 && !center) {
                int result = query(x2, hitY);
                if (result == 0) {
                    x2 -= dist;
                } else if (result == 1) {
                    x2 += dist;
                } else {
                    center = true;
                }
                dist >>= 1;
            }

            dist = Math.abs(hitY + 1000000000) / 4;
            while (dist > 0 && !center) {
                int result = query(hitX, y1);
                if (result == 0) {
                    y1 += dist;
                } else if (result == 1) {
                    y1 -= dist;
                } else {
                    center = true;
                }
                dist >>= 1;
            }

            dist = Math.abs(1000000000 - hitY) / 4;
            while (dist > 0 && !center) {
                int result = query(hitX, y2);
                if (result == 0) {
                    y2 -= dist;
                } else if (result == 1) {
                    y2 += dist;
                } else {
                    center = true;
                }
                dist >>= 1;
            }

            hitX = (x1 + x2) / 2;
            hitY = (y1 + y2) / 2;

            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (!center) {
                        int result = query(hitX + i, hitY + j);
                        if (result == 2) {
                            center = true;
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    private static int query(int x, int y) {
        System.out.print(x + " " + y);
        String response = scanner.next();
        if (response.equals("MISS")) {
            return 0;
        } else if (response.equals("HIT")) {
            return 1;
        } else {
            return 2;
        }
    }
}